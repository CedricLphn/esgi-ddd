package org.example.use_case.pdm;

import org.example.domain.enums.AlimentType;

import java.util.List;

public class DonneesUtilisateurDTO {
    private final double poids;
    private final double taille;
    private final int age;

    private final List<AlimentType> allergies;



    public DonneesUtilisateurDTO(double poids, double taille, int age, List<AlimentType> allergies) {
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
