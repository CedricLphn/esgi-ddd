package org.example.model;

public class DonneesUtilisateur {
    private final double poids;
    private final double taille;
    private final int age;

    public DonneesUtilisateur(double poids, double taille, int age) {
        this.poids = poids;
        this.taille = taille;
        this.age = age;
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
}
