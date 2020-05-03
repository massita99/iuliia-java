package iuliia;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Class <class>Schemas</class> define utility class to work with {@link Schema}
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
}

    
    