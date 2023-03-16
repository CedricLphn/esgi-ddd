package example.use_case.pdm;

import org.example.DonneesUtilisateur;
import org.example.model.*;
import org.example.use_case.pdm.PlanifierPDM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PlanifierPriseDeMasseTest {


    @DisplayName("Devrait planifier un programme avec un objectif prise de masse.")
    @Test
    void planifier_programme_prise_de_masse(){
        //Given
        List<Aliment> aliments = List.of(
                new Aliment("Banane", 5, 10, 1, RegimeType.MODEREE, AlimentType.aucun),
                new Aliment("Cacahuètes", 5, 10, 1, RegimeType.MODEREE, AlimentType.fruitsSecs),
                new Aliment("Beurre", 5, 10, 20, RegimeType.FLEXIBLE, AlimentType.aucun), new Aliment("Oeuf", 20, 5, 1, RegimeType.STRICT, AlimentType.aucun));

        List<Exercice> exercices = List.of(
                new Exercice("Squats", ExerciceType.pdm),
                new Exercice("Bench Press", ExerciceType.pdm),
                new Exercice("Deadlift", ExerciceType.pdm),
                new Exercice("Tractions", ExerciceType.seche),
                new Exercice("Dips", ExerciceType.seche),
                new Exercice("Crunch", ExerciceType.seche)
        );

        DonneesUtilisateur donneesUtilisateur = new DonneesUtilisateur(80, 1.80, 20, List.of(AlimentType.fruitsSecs));

        //When
        Programme programme = new PlanifierPDM(aliments, exercices, donneesUtilisateur).appliquer();

        //Then
        Assertions.assertNotNull(programme);
    }
}
