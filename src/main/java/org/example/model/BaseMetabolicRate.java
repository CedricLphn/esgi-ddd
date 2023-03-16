package org.example.model;

import org.example.DonneesUtilisateur;

public class BaseMetabolicRate {

    private final double value;

    private DonneesUtilisateur donneesUtilisateur;

    public BaseMetabolicRate(DonneesUtilisateur donneesUtilisateur) {
        this.donneesUtilisateur = donneesUtilisateur;
    }
    public double getBmr() {
        return value;
    }
}
