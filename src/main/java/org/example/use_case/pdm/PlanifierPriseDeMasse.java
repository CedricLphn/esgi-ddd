package org.example.use_case.pdm;

import org.example.model.*;

import java.util.List;

public class PlanifierPriseDeMasse {

    public static final int BULK_INCREASE_KCAL = 200;
    public static List<Aliment> aliments = List.of(
            new Aliment("Banane", 5, 10, 1, RegimeType.MODEREE),
            new Aliment("Cacahuètes", 5, 10, 1, RegimeType.MODEREE),
            new Aliment("Beurre", 5, 10, 20, RegimeType.FLEXIBLE), new Aliment("Oeuf", 20, 5, 1, RegimeType.STRICT));
    private final DonneesUtilisateur donneesUtilisateur;

    public PlanifierPriseDeMasse(DonneesUtilisateur donneesUtilisateur) {
        this.donneesUtilisateur = donneesUtilisateur;
    }

    public Programme appliquer(){
        var alimentsUtilisateur = aliments.stream().filter(aliment -> aliment.getRegimeType().equals(RegimeType.MODEREE)).toList();
        var caloriesUtilisateur = new BaseMetabolicRate(donneesUtilisateur).getBaseMetabolicRate()  + BULK_INCREASE_KCAL;

        return Programme.creer(alimentsUtilisateur, caloriesUtilisateur);
    }

}
