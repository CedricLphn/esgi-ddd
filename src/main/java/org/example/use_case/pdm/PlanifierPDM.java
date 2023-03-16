package org.example.use_case.pdm;

import org.example.DonneesUtilisateur;
import org.example.domain.model.*;
import org.example.infrastructure.AlimentsDAO;
import org.example.infrastructure.ExercicesDAO;

public class PlanifierPDM {

    private final DonneesUtilisateur donneesUtilisateur;

    private final AlimentsDAO alimentsDAO;

    private final ExercicesDAO exercicesDAO;

    public PlanifierPDM( DonneesUtilisateur donneesUtilisateur, AlimentsDAO aliments, ExercicesDAO exercices) {
        this.donneesUtilisateur = donneesUtilisateur;
        this.alimentsDAO = aliments;
        this.exercicesDAO = exercices;
    }

    public Programme appliquer(){
        var alimentsUtilisateur = alimentsDAO.obtenirTout().stream().filter(aliment -> aliment.getRegimeType().equals(RegimeType.MODEREE)).toList();
        var exercisesUtilisateur = exercicesDAO.obtenirTout().stream().filter(exercice -> exercice.getExerciceType().equals(ExerciceType.pdm)).toList();
        var bulking = new Bulking(new BaseMetabolicRate(donneesUtilisateur.obtenirPoids(), donneesUtilisateur.obtenirTaille(), donneesUtilisateur.obtenirAge()));

       return Programme.creer(alimentsUtilisateur, exercisesUtilisateur, donneesUtilisateur.getAllergies(), bulking);
    }
}
