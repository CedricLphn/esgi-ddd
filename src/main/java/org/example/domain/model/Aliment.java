package org.example.model;

import java.util.Objects;

public class Aliment {
    private final AlimentId alimentId;
    private final String nom;
    private final int proteines;
    private final int glucides;
    private final int lipides;
    private final RegimeType regimeType;
    private final AlimentType alimentType;

    public Aliment(String nom, int proteines, int glucides, int lipides, RegimeType regimeType, AlimentType alimentType) {
        this.nom = nom;
        this.proteines = proteines;
        this.glucides = glucides;
        this.lipides = lipides;
        this.regimeType = regimeType;
        this.alimentType = alimentType;
    }

    public String getNom() {
        return nom;
    }

    public int getProteines() {
        return proteines;
    }

    public int getGlucides() {
        return glucides;
    }

    public int getLipides() {
        return lipides;
    }

    public RegimeType getRegimeType() {
        return regimeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aliment aliment = (Aliment) o;
        return proteines == aliment.proteines && glucides == aliment.glucides && lipides == aliment.lipides && nom.equals(aliment.nom) && regimeType == aliment.regimeType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, proteines, glucides, lipides, regimeType);
    }
}
