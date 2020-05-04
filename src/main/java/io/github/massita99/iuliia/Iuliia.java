package io.github.massita99.iuliia;


import lombok.Value;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Class {@link Iuliia} add possibilities transliterate cyrilic string using {@link Schema} to latin
 *
 * @author maximk
 */
public abstract class Iuliia {

    /**
     * Transliterate string using specified schema
     *
     * @param input  string to transliterate
     * @param schema schema for transliterating
     * @return transliterating string
     */
    public static String translate(String input, Schema schema) {
        List<String> words = Arrays.asList(input.split("\\b"));
        return words.stream()
                .map(word -> translateWord(word, schema))
                .collect(Collectors.joining(""));
    }

    private static String translateWord(String input, Schema schema) {

        Optional<Map.Entry<String, String>> matchedEndingEntry = getMatchedEndingIfExist(input, schema);

        String inputWithoutMatchedEnding;
        String translatedEnding;

        if (matchedEndingEntry.isPresent()) {
            inputWithoutMatchedEnding = StringUtils.removeEndIgnoreCase(input, matchedEndingEntry.get().getKey());
            translatedEnding = matchedEndingEntry.get().getValue();
        } else {
            inputWithoutMatchedEnding = input;
            translatedEnding = "";
        }

        List<Latter> tokens = tokenizeWord(inputWithoutMatchedEnding);

        return tokens.stream()
                .map(latter -> translateToken(latter, schema))
                .collect(Collectors.joining("")) + translatedEnding;
    }

    private static Optional<Map.Entry<String, String>> getMatchedEndingIfExist(String input, Schema schema) {
        String inputWithoutCase = input.toLowerCase();
        boolean isUpper = !inputWithoutCase.equals(input);
        return Optional.ofNullable(schema.getEnding_mapping()).orElse(Collections.emptyMap())
                .entrySet()
                .stream()
                .filter(entry -> inputWithoutCase.endsWith(entry.getKey()))
                .peek(entry -> entry.setValue(isUpper ? entry.getValue().toUpperCase() : entry.getValue()))
                .findFirst();
    }

    private static List<Latter> tokenizeWord(String input) {
        List<Latter> tokens = new ArrayList<>(input.length());
        for (int i = 0; i < input.length(); i++) {
            if (input.length() == 1) {
                tokens.add(new Latter(null, input.charAt(i), null));
            } else if (i == 0) {
                tokens.add(new Latter(null, input.charAt(i), input.charAt(i + 1)));
            } else if (i == input.length() - 1) {
                tokens.add(new Latter(input.charAt(i - 1), input.charAt(i), null));
            } else {
                tokens.add(new Latter(input.charAt(i - 1), input.charAt(i), input.charAt(i + 1)));
            }
        }
        return tokens;
    }

    private static String translateToken(Latter latter, Schema schema) {
        //TODO: work with default
        String result;
        String tryPrev = Optional.ofNullable(schema.getPrev_mapping()).orElse(Collections.emptyMap()).get(latter.getPrevious());
        String tryNext = Optional.ofNullable(schema.getNext_mapping()).orElse(Collections.emptyMap()).get(latter.getNext());
        if (tryPrev != null) {
            result = tryPrev;
        } else if (tryNext != null) {
            result = tryNext;
        } else {
            result = schema.getMapping().getOrDefault(latter.getCurrent(), latter.getCurrent());
        }
        return latter.isUpper() ? StringUtils.capitalize(result) : result;
    }

    @Value
    private static class Latter {
        String previous;
        String next;
        String current;
        boolean isUpper;

        public Latter(String previous, String current, String next) {
            this.previous = previous.toLowerCase() + current.toLowerCase();
            this.current = current.toLowerCase();
            this.next = current.toLowerCase() + next.toLowerCase();
            this.isUpper = current.toUpperCase().equals(current);
        }

        public Latter(Character previous, Character current, Character next) {
            this(previous == null ? "" : previous.toString(),
                    current.toString(),
                    next == null ? "" : next.toString());
        }
    }
}

    
    