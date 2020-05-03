import iuliia.Iuliia
import iuliia.Schema
import iuliia.Schemas
import spock.lang.Shared
import spock.lang.Specification

class MainSpecification extends Specification {

    @Shared Schema schema = Schemas.forName("yandex_maps")

    def "One-to-one translate"(String input, String result) {
        expect:
            Iuliia.translate(input, schema) == result
        where:
            input        | result
            "привет"     | "privet"
            "пока"       | "poka"
        }

    def "With case translate"(String input, String result) {
        expect:
            Iuliia.translate(input, schema) == result
        where:
            input        | result
            "Юлия"       | "Yuliya"
    }

    def "With prev translate"(String input, String result) {
        expect:
            Iuliia.translate(input, schema) == result
        where:
            input        | result
            "въезд"       | "vyezd"
    }

}
