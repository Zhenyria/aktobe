package ru.zhenyria.aktobe.model.word_definition;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class WordDefinitionId implements Serializable {
    private Integer wordId;
    private Integer definitionId;
}
