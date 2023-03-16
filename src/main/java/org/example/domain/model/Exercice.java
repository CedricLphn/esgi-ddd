package org.example.domain.model;

public class Exercice {

    private final ExerciceId id;
    private final String nom;
    private final ExerciceType exerciceType;

    public Exercice(ExerciceId id, String nom, ExerciceType exerciceType) {
        this.id = id;
        this.nom = nom;
        this.exerciceType = exerciceType;
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
