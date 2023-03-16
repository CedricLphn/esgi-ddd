package org.example.use_case.pdm;

import org.example.domain.entity.Programme;
import org.example.domain.enums.ExerciceType;
import org.example.domain.enums.RegimeType;
import org.example.domain.vo.BaseMetabolicRate;
import org.example.domain.vo.Bulking;
import org.example.domain.ports.AlimentsDAO;
import org.example.domain.ports.ExercicesDAO;

public class PlanifierPDM {

    private final DonneesUtilisateurDTO donneesUtilisateur;

    private final AlimentsDAO alimentsDAO;

    private final ExercicesDAO exercicesDAO;

    public PlanifierPDM(DonneesUtilisateurDTO donneesUtilisateur, AlimentsDAO aliments, ExercicesDAO exercices) {
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
