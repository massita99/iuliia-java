package iuliia;

import lombok.Value;

import java.util.List;
import java.util.Map;

/**
 * Class <class>Schema</class> define schema
 *
 * @author maximk
 */
@Value
public class Schema {

    private String name;

    private String description;

    private String url;

    private Map<String, String> mapping;

    private Map<String, String> prev_mapping;

    private Map<String, String> next_mapping;

    private Map<String, String> ending_mapping;

    private List<List<String>> samples;

}

    
    