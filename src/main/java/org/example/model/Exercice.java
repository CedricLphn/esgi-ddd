package org.example.model;

public class Exercice {
    private final String nom;
    private final ExerciceType exerciceType;

    public Exercice(String nom, ExerciceType exerciceType) {
        this.nom = nom;
        this.exerciceType = exerciceType;
    }

    public String getNom() {
        return nom;
    }

    public ExerciceType getExerciceType() {
        return exerciceType;
    }
}
