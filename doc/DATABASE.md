# Database

## Schema `dictionary`

### Types

| Type | Name                | Values                   |
|:-----|:--------------------|:-------------------------|
| ENUM | dictionary_language | ENGLISH, KAZAKH, RUSSIAN |

### Tables

```mermaid
classDiagram
    direction BT
    class part_of_speech {
        integer id
        varchar name
        dictionary_language language_id
    }
    class word {
        integer id
        varchar root
        integer part_of_speech_id
    }
    class definition {
        integer id
        text description
        dictionary_language language_id
    }
    class definition_word {
        integer definition_id
        integer word_id
    }
    word --> part_of_speech: fk__word__part_of_speech__part_of_speech_id__id
    definition_word --> definition: fk__definition_word__definition__definition_id__id
    definition_word --> word: fk__definition_word__word__word_id__id
```