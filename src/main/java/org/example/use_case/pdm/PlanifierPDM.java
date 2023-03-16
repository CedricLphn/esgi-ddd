package org.example.use_case.pdm;

import org.example.domain.entity.Programme;
import org.example.domain.exceptions.BaseMetabolicRateException;
import org.example.domain.exceptions.BulkingException;
import org.example.domain.ports.ProgrammeService;

public class PlanifierPDM {

    private final DonneesUtilisateurDTO donneesUtilisateur;
    private final ProgrammeService programmeService;


    public PlanifierPDM(DonneesUtilisateurDTO donneesUtilisateur, ProgrammeService programmeService) {
        this.donneesUtilisateur = donneesUtilisateur;
        this.programmeService = programmeService;
    }

    public Programme appliquer() throws BaseMetabolicRateException, BulkingException {
        return programmeService.creerUnProgrammePdm(donneesUtilisateur.obtenirPoids(), donneesUtilisateur.obtenirTaille(), donneesUtilisateur.obtenirAge(), donneesUtilisateur.getAllergies());
    }
}
