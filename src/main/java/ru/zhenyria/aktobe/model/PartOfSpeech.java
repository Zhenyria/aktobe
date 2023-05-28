package ru.zhenyria.aktobe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "part_of_speech", schema = "dictionary")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PartOfSpeech extends EntityWithAutoIncrementId {

    @NotNull
    @Column(name = "name_val")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "language")
    private Language language;
}
