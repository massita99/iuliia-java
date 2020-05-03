import iuliia.Iuliia
import iuliia.Schema
import iuliia.Schemas
import spock.lang.Shared
import spock.lang.Specification

class MainSpecification extends Specification {

    @Shared Schema schemaMetro = Schemas.forName("mosmetro")
    @Shared Schema schemaYandex = Schemas.forName("yandex_maps")

    def "One-to-one translate"(String input, String result) {
        expect:
            Iuliia.translate(input, schemaYandex) == result
        where:
            input        | result
            "привет"     | "privet"
            "пока"       | "poka"
        }

    def "With case translate"(String input, String result) {
        expect:
            Iuliia.translate(input, schemaYandex) == result
        where:
            input        | result
            "Юлия"       | "Yuliya"
    }

    def "With next translate"(String input, String result) {
        expect:
            Iuliia.translate(input, schemaYandex) == result
        where:
            input        | result
            "въезд"       | "vyezd"
    }

    def "With pref translate"(String input, String result) {
        expect:
            Iuliia.translate(input, schemaMetro) == result
        where:
            input        | result
            "враньё"       | "vranyo"
    }

    def "With endings translate"(String input, String result) {
        expect:
            Iuliia.translate(input, schemaMetro) == result
        where:
            input        | result
            "единый"     | "ediny"
    }

}
