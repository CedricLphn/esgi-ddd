package org.example.domain.entity;

import org.example.domain.enums.AlimentType;
import org.example.domain.vo.Bulking;
import org.example.domain.vo.ProgrammeId;
import shared.allergie.Allergie;

import java.util.List;

public class Programme {

    ProgrammeId programmeId;
    Allergie allergie;
    List<Aliment> aliments;
    List<Exercice> exercices;

    public void setProgrammeId(ProgrammeId programmeId) {
        this.programmeId = programmeId;
    }

    Bulking bulking;

    public Programme() {
    }

    public static Programme creer(ProgrammeId id ,List<Aliment> aliments, List<Exercice> exercices, List<AlimentType> allergies, Bulking bulk){

        var prog = new Programme();
        prog.setProgrammeId(id);
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
        return allergie.getAllergies();
    }

    public void setAllergies(List<AlimentType> allergies) {
        allergie = new Allergie(allergies);
    }
}
