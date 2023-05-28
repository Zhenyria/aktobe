package ru.zhenyria.aktobe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "word", schema = "dictionary")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Word extends EntityWithAutoIncrementId {

    @NotNull
    @Column(name = "root", nullable = false)
    private String root;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "part_of_speech_id")
    private PartOfSpeech partOfSpeech;
}
