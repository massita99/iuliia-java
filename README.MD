[![Build Status](https://travis-ci.org/massita99/iuliia-java.svg?branch=master)](https://travis-ci.org/massita99/iuliia-java)
[![codecov](https://codecov.io/gh/massita99/transfer/branch/master/graph/badge.svg)](https://codecov.io/gh/massita99//iuliia-java)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.massita99/iuliia-java/badge.svg?style=plastic)](https://maven-badges.herokuapp.com/maven-central/io.github.massita99/iuliia-java)

# `Iuliia`
> Transliterate Cyrillic → Latin in every possible way

> This is the port of the incredible python library [iuliia](https://github.com/nalgeon/iuliia-py) made by @nalgeon

Transliteration means representing Cyrillic data (mainly names and geographic locations) with Latin letters. It is used for international passports, visas, green cards, driving licenses, mail and goods delivery etc.

`Iuliia` makes transliteration as easy as:

```java
import io.github.massita99.Iuliia;
import io.github.massita99.Schemas;

public class Application {

    public static void main(String[] args) {
        System.out.println(Iulia.translate("Юлия", Schemas.forName("yandex_maps")));
        //OR:
        System.out.println(Iulia.translate("Юлия", Schemas.AllSchemas.YANDEX_MAPS));

    }
}

>> Yuliya
```

## Why use `Iuliia`

- [20 transliteration schemas](https://github.com/nalgeon/iuliia) (rule sets), including all main international and Russian standards.
- Correctly implements not only the base mapping, but all the special rules for letter combinations and word endings (AFAIK, Iuliia is the only library which does so).
- Simple API and zero third-party dependencies.

## Installation

Gradle:
```gradle
dependencies {
  implementation 'io.github.massita99:iuliia-java:0.2'
}
```

Maven:
```xml
<dependency>
  <groupId>io.github.massita99</groupId>
  <artifactId>iuliia-java</artifactId>
  <version>0.2</version>
</dependency>
```

`schemas` folder is the git submodule from [general repository](https://github.com/nalgeon/iuliia). 

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Make sure to add or update tests as appropriate.

## License

[MIT](https://choosealicense.com/licenses/mit/)