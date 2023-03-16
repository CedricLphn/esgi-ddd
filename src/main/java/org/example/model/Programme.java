package org.example.model;

import java.util.List;
import java.util.Objects;

public class Programme {

    List<Aliment> aliments;
    List<Exercice> exercices;
    List<AlimentType> allergies;
    double calories;

    private Programme() {
    }

    public static Programme creer(List<Aliment> aliments, List<Exercice> exercices, List<AlimentType> allergies, double calories){
        var prog = new Programme();
        prog.setAliments(aliments);
        prog.setCalories(calories);
        prog.setExercices(exercices);
        prog.setAllergies(allergies);
        return prog;
    }

    public List<Aliment> getAliments() {
        return aliments;
    }

    public void setAliments(List<Aliment> aliments) {
        this.aliments = aliments;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public List<Exercice> getExercices() {
        return exercices;
    }

    public void setExercices(List<Exercice> exercices) {
        this.exercices = exercices;
    }

    public List<AlimentType> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<AlimentType> allergies) {
        this.allergies = allergies;
    }
}
