package org.example.domain.service;

import org.example.domain.entity.Programme;
import org.example.domain.enums.AlimentType;
import org.example.domain.exceptions.BaseMetabolicRateException;
import org.example.domain.exceptions.BulkingException;
import org.example.domain.ports.AlimentsDAO;
import org.example.domain.ports.ExercicesDAO;
import org.example.domain.ports.ProgrammeService;
import org.example.domain.vo.BaseMetabolicRate;
import org.example.domain.vo.Bulking;

import java.util.List;

public class SimpleProgramme implements ProgrammeService {

    private final AlimentsDAO alimentsDAO;

    private final ExercicesDAO exercicesDAO;

    public SimpleProgramme(AlimentsDAO alimentsDAO, ExercicesDAO exercicesDAO) {
        this.alimentsDAO = alimentsDAO;
        this.exercicesDAO = exercicesDAO;
    }


    @Override
    public Programme creerUnProgrammePdm(double poids, double taille, int age, List<String> allergies) throws BaseMetabolicRateException, BulkingException {
        var alimentsUtilisateur = alimentsDAO.obtenirTout().stream().filter(aliment -> aliment.estRegimeModere()).toList();
        var exercisesUtilisateur = exercicesDAO.obtenirTout().stream().filter(exercice -> exercice.estPdm()).toList();
        var bulking = new Bulking(new BaseMetabolicRate(poids, taille, age));
        var lesAllergies = allergies.stream().map(allergie -> AlimentType.valueOf(allergie)).toList();
        return Programme.creer(alimentsUtilisateur, exercisesUtilisateur, lesAllergies, bulking);
    }
}
