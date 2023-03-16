package org.example.domain.entity;

import org.example.domain.enums.AlimentType;
import org.example.domain.vo.Bulking;

import java.util.List;

public class Programme {

    List<Aliment> aliments;
    List<Exercice> exercices;
    List<AlimentType> allergies;
    Bulking bulking;

    public Programme() {
    }

    public static Programme creer(List<Aliment> aliments, List<Exercice> exercices, List<AlimentType> allergies, Bulking bulk){
        var prog = new Programme();
        prog.setAliments(aliments);
        prog.setExercices(exercices);
        prog.setAllergies(allergies);
        prog.setBulking(bulk);
        return prog;
    }

    public Bulking getBulking() {
        return bulking;
    }

    public void setBulking(Bulking bulking) {
        this.bulking = bulking;
    }

    public List<Aliment> getAliments() {
        return aliments;
    }

    public void setAliments(List<Aliment> aliments) {
        this.aliments = aliments;
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
