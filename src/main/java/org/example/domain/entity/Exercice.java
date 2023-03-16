package org.example.domain.entity;

import org.example.domain.vo.ExerciceId;
import org.example.domain.enums.ExerciceType;

public class Exercice {

    private final ExerciceId id;
    private final String nom;
    private final ExerciceType exerciceType;

    public Exercice(ExerciceId id, String nom, ExerciceType exerciceType) {
        this.id = id;
        this.nom = nom;
        this.exerciceType = exerciceType;
    }

    public Boolean estPdm(){
        return this.exerciceType.equals(ExerciceType.pdm);
    }

    public Boolean estSeche(){
        return this.exerciceType.equals(ExerciceType.seche);
    }

    public ExerciceId getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public ExerciceType getExerciceType() {
        return exerciceType;
    }
}
