package org.example;

import org.example.model.AlimentType;

import java.util.List;

public class DonneesUtilisateur {
    private final double poids;
    private final double taille;
    private final int age;

    private final List<AlimentType> allergies;



    public DonneesUtilisateur(double poids, double taille, int age, List<AlimentType> allergies) {
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.allergies = allergies;
    }

    public double obtenirPoids() {
        return poids;
    }

    public double obtenirTaille() {
        return taille;
    }

    public int obtenirAge() {
        return age;
    }

    public List<AlimentType> getAllergies() {
        return allergies;
    }
}
