package io.github.massita99.iuliia;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Class {@link Schemas}define utility class to work with {@link Schema}
 *
 * @author maximk
 */
public abstract class Schemas {

    private static final Gson gson = new Gson();

    /**
     * Return schema by name
     * @param name of schema (@see <a href="https://github.com/nalgeon/iuliia">https://github.com/nalgeon/iuliia</a>}
     * @return schema
     * @throws IllegalArgumentException if no schema present
     */
    public static Schema forName(String name) {
        String fullPathToSchema = getFullPathToSchema(name);
        InputStream schemaStream = Schemas.class.getClassLoader().getResourceAsStream(fullPathToSchema);
        if (schemaStream == null) {
            throw new IllegalArgumentException(String.format("No schema with name '%s'", name));
        }
        return gson.fromJson(new BufferedReader(new InputStreamReader(schemaStream)), Schema.class);
    }

    private static String getFullPathToSchema(String name) {
        return "schemas" + File.separator + name + ".json";
    }

    public final static class AllSchemas {

        public static final Schema ALA_LC_ALT = Schemas.forName("ala_lc_alt");
        public final static Schema BGN_PCGN = Schemas.forName("bgn_pcgn");
        public final static Schema BGN_PCGN_ALT = Schemas.forName("bgn_pcgn_alt");
        public final static Schema BS_2979 = Schemas.forName("bs_2979");
        public final static Schema BS_2979_ALT = Schemas.forName("bs_2979_alt");
        public final static Schema GOST_779 = Schemas.forName("gost_779");
        public final static Schema GOST_779_ALT = Schemas.forName("gost_779_alt");
        public final static Schema GOST_7034 = Schemas.forName("gost_7034");
        public final static Schema GOST_16876 = Schemas.forName("gost_16876");
        public final static Schema GOST_16876_ALT = Schemas.forName("gost_16876_alt");
        public final static Schema GOST_52290 = Schemas.forName("gost_52290");
        public final static Schema GOST_52535 = Schemas.forName("gost_52535");
        public final static Schema ICAO_DOC_9303 = Schemas.forName("icao_doc_9303");
        public final static Schema ISO_9_1954 = Schemas.forName("iso_9_1954");
        public final static Schema ISO_9_1968 = Schemas.forName("iso_9_1968");
        public final static Schema ISO_9_1968_ALT = Schemas.forName("iso_9_1968_alt");
        public final static Schema MOSMETRO = Schemas.forName("mosmetro");
        public final static Schema MVD_310 = Schemas.forName("mvd_310");
        public final static Schema MVD_310_FR = Schemas.forName("mvd_310_fr");
        public final static Schema MVD_782 = Schemas.forName("mvd_782");
        public final static Schema SCIENTIFIC = Schemas.forName("scientific");
        public final static Schema TELEGRAM = Schemas.forName("telegram");
        public final static Schema UNGEGN_1987 = Schemas.forName("ungegn_1987");
        public final static Schema WIKIPEDIA = Schemas.forName("wikipedia");
        public final static Schema YANDEX_MAPS = Schemas.forName("yandex_maps");
        public final static Schema YANDEX_MONEY = Schemas.forName("yandex_money");
    }
}

    
    