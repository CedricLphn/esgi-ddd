package org.example.use_case.pdm;

import org.example.DonneesUtilisateur;
import org.example.model.*;

import java.util.List;

public class PlanifierPDM {

    private final List<Aliment> aliments;
    private final List<Exercice> exercices;
    private final DonneesUtilisateur donneesUtilisateur;

    private final int BULK_INCREASE_KCAL;

    public PlanifierPDM(List<Aliment> aliments, List<Exercice> exercices, DonneesUtilisateur donneesUtilisateur) {
        this.aliments = aliments;
        this.donneesUtilisateur = donneesUtilisateur;
        this.BULK_INCREASE_KCAL = 200;
        this.exercices = exercices;
    }

    public Programme appliquer(){
        var alimentsUtilisateur = aliments.stream().filter(aliment -> aliment.getRegimeType().equals(RegimeType.MODEREE)).toList();
        var caloriesUtilisateur = new BaseMetabolicRate(donneesUtilisateur).getBaseMetabolicRate()  + BULK_INCREASE_KCAL;
        var exercisesUtilisateur = exercices.stream().filter(exercice -> exercice.getExerciceType().equals(ExerciceType.pdm)).toList();

       return Programme.creer(alimentsUtilisateur, exercisesUtilisateur, donneesUtilisateur.getAllergies(), caloriesUtilisateur);
    }
}
