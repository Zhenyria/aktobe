package ru.zhenyria.aktobe.model.word_definition;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.zhenyria.aktobe.model.Definition;
import ru.zhenyria.aktobe.model.Word;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "word_definition", schema = "dictionary")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WordDefinition {

    @EmbeddedId
    private WordDefinitionId id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("wordId")
    @JoinColumn(name = "word_id")
    private Word word;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("definitionId")
    @JoinColumn(name = "definition_id")
    private Definition definition;
}
