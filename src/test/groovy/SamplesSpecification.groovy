import io.github.massita99.iuliia.Iuliia
import io.github.massita99.iuliia.Schema
import io.github.massita99.iuliia.Schemas
import spock.lang.Specification

class SamplesSpecification extends Specification {

    def "check schema samples"(Schema schema, boolean result) {
        given:
            boolean checkPass = schema.getSamples()
                .stream()
                .allMatch({ sample -> Iuliia.translate(sample.get(0), schema) == sample.get(1) })
        where:
            schema                               | result
            Schemas.AllSchemas.ALA_LC_ALT        | true
            Schemas.AllSchemas.BGN_PCGN          | true
            Schemas.AllSchemas.BGN_PCGN_ALT      | true
            Schemas.AllSchemas.BS_2979           | true
            Schemas.AllSchemas.BS_2979_ALT       | true
            Schemas.AllSchemas.GOST_779          | true
            Schemas.AllSchemas.GOST_779_ALT      | true
            Schemas.AllSchemas.GOST_7034         | true
            Schemas.AllSchemas.GOST_16876        | true
            Schemas.AllSchemas.GOST_16876_ALT    | true
            Schemas.AllSchemas.GOST_52290        | true
            Schemas.AllSchemas.GOST_52535        | true
            Schemas.AllSchemas.ICAO_DOC_9303     | true
            Schemas.AllSchemas.ISO_9_1954        | true
            Schemas.AllSchemas.ISO_9_1968        | true
            Schemas.AllSchemas.ISO_9_1968_ALT    | true
            Schemas.AllSchemas.MOSMETRO          | true
            Schemas.AllSchemas.MVD_310           | true
            Schemas.AllSchemas.MVD_310_FR        | true
            Schemas.AllSchemas.MVD_782           | true
            Schemas.AllSchemas.SCIENTIFIC        | true
            Schemas.AllSchemas.TELEGRAM          | true
            Schemas.AllSchemas.UNGEGN_1987       | true
            Schemas.AllSchemas.WIKIPEDIA         | true
            Schemas.AllSchemas.YANDEX_MAPS       | true
            Schemas.AllSchemas.YANDEX_MONEY      | true
    }
}
