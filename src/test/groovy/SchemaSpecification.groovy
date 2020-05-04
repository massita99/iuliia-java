import io.github.massita99.iuliia.Schema
import io.github.massita99.iuliia.Schemas
import spock.lang.Specification

class SchemaSpecification extends Specification {

    def "parse schema from properties"() {
        given:
            String schemaName = "yandex_maps"
        when:
            Schema schema = Schemas.forName(schemaName)
        then:
            schema != null
            schema.getDescription() != null
            schema.getMapping() != null
    }

    def "throw IllegalArgumentException if no schema"() {
        given:
            String schemaName = "fake"
        when:
            Schemas.forName(schemaName)
        then:
            thrown(IllegalArgumentException)
    }
}
