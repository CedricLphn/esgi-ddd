package org.example.model;

import org.example.DonneesUtilisateur;

public class BaseMetabolicRate {

    private DonneesUtilisateur donneesUtilisateur;

    public BaseMetabolicRate(DonneesUtilisateur donneesUtilisateur) {
        this.donneesUtilisateur = donneesUtilisateur;
    }

    public double getBaseMetabolicRate() {
        return 66.5 + (13.75 * donneesUtilisateur.obtenirPoids()) + (5.003 * donneesUtilisateur.obtenirTaille()) - (6.75 * donneesUtilisateur.obtenirAge());
    }
}
