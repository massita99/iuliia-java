package iuliia;

import lombok.Value;

import java.util.List;
import java.util.Map;

/**
 * Класс <class>Schema</class> TODO
 *
 * @author maximk
 */
@Value
public class Schema {

    String name;

    String description;

    String url;

    Map<String, String> mapping;

    Map<String, String> prev_mapping;

    Map<String, String> next_mapping;

    Map<String, String> ending_mapping;

    List<List<String>> samples;


}

    
    