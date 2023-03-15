package org.example.use_case.pdm;

import org.example.model.DonneesUtilisateur;

public class PlanifierPDM {

    private final DonneesUtilisateur donneesUtilisateur;

    public PlanifierPDM(DonneesUtilisateur donneesUtilisateur) {
        this.donneesUtilisateur = donneesUtilisateur;
    }

    public double appliquer(){
        return(66.5 + (13.75 * donneesUtilisateur.obtenirPoids()) + (5.003 * donneesUtilisateur.obtenirTaille()) - (6.75 * donneesUtilisateur.obtenirAge()));
    }
}
