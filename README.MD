# `Iuliia`
> Transliterate Cyrillic → Latin in every possible way

> This is the port of the incredible python library [iuliia](https://github.com/nalgeon/iuliia-py) made by @nalgeon

Transliteration means representing Cyrillic data (mainly names and geographic locations) with Latin letters. It is used for international passports, visas, green cards, driving licenses, mail and goods delivery etc.

`Iuliia` makes transliteration as easy as:

```java
import iuliia.Iuliia;
import iuliia.Schemas;

public class Application {

    public static void main(String[] args) {
        System.out.println(Iulia.translate("Юлия", Schemas.forName("yandex_maps")));
    }
}

>> Yuliya
```

## Why use `Iuliia`

- [20 transliteration schemas](https://github.com/nalgeon/iuliia) (rule sets), including all main international and Russian standards.
- Correctly implements not only the base mapping, but all the special rules for letter combinations and word endings (AFAIK, Iuliia is the only library which does so).
- Simple API and zero third-party dependencies.

## Installation

TODO:

`schemas` folder is the git submodule from [general repository](https://github.com/nalgeon/iuliia). 

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Make sure to add or update tests as appropriate.

## License

[MIT](https://choosealicense.com/licenses/mit/)