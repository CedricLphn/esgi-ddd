package org.example.domain.entity;

import org.example.domain.enums.AlimentType;
import org.example.domain.enums.RegimeType;
import org.example.domain.vo.AlimentId;

public class Aliment {
    private final AlimentId alimentId;
    private final String nom;
    private final int proteines;
    private final int glucides;
    private final int lipides;
    private final RegimeType regimeType;
    private final AlimentType alimentType;

    public Aliment(AlimentId alimentId, String nom, int proteines, int glucides, int lipides, RegimeType regimeType, AlimentType alimentType) {
        this.alimentId = alimentId;
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

}
