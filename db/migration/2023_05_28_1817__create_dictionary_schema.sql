--liquibase formatted sql
--changeset Zhenyria:2023_05_28_1817__create_dictionary_schema

CREATE SCHEMA IF NOT EXISTS dictionary;

--rollback DROP SCHEMA IF EXISTS dictionary;

--changeset Zhenyria:2023_05_28_1817__create_dictionary_language_enum

CREATE TYPE dictionary.dictionary_language AS ENUM ('ENGLISH', 'KAZAKH', 'RUSSIAN');

--rollback DROP TYPE IF EXISTS dictionary.dictionary_language;

--changeset Zhenyria:2023_05_28_1817__create_part_of_speech_table

CREATE TABLE IF NOT EXISTS dictionary.part_of_speech
(
    id       SERIAL PRIMARY KEY,
    name_val VARCHAR(256)                   NOT NULL,
    language dictionary.dictionary_language NOT NULL
);

--rollback DROP TABLE IF EXISTS dictionary.part_of_speech;

--changeset Zhenyria:2023_05_28_1817__create_word_table

CREATE TABLE IF NOT EXISTS dictionary.word
(
    id                SERIAL PRIMARY KEY,
    root              VARCHAR(256) NOT NULL,
    part_of_speech_id INTEGER      NOT NULL,
    CONSTRAINT fk__word__part_of_speech__part_of_speech_id__id
        FOREIGN KEY (part_of_speech_id) REFERENCES dictionary.part_of_speech (id)
);

--rollback DROP TABLE IF EXISTS dictionary.word;

--changeset Zhenyria:2023_05_28_1817__create_definition_table

CREATE TABLE IF NOT EXISTS dictionary.definition
(
    id          SERIAL PRIMARY KEY,
    description TEXT                           NOT NULL,
    language    dictionary.dictionary_language NOT NULL
);

--rollback DROP TABLE IF EXISTS dictionary.definition;

--changeset Zhenyria:2023_05_28_1817__create_word_definition_table

CREATE TABLE IF NOT EXISTS dictionary.word_definition
(
    word_id       INTEGER NOT NULL,
    definition_id INTEGER NOT NULL,
    CONSTRAINT fk__word_definition__word__word_id__id
        FOREIGN KEY (word_id) REFERENCES dictionary.word (id),
    CONSTRAINT fk__word_definition__definition__definition_id__id
        FOREIGN KEY (definition_id) REFERENCES dictionary.definition (id)
);

--rollback DROP TABLE IF EXISTS dictionary.word_definition;
