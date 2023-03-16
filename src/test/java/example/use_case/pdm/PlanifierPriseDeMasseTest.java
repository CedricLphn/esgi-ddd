package example.use_case.pdm;

import org.example.DonneesUtilisateur;
import org.example.domain.model.*;
import org.example.infrastructure.Aliments;
import org.example.infrastructure.AlimentsDAO;
import org.example.infrastructure.Exercices;
import org.example.infrastructure.ExercicesDAO;
import org.example.use_case.pdm.PlanifierPDM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class PlanifierPriseDeMasseTest {

    private static final int AGE = 20;
    private static final double TAILLE = 1.80;
    private static final int POIDS = 80;

    @DisplayName("Devrait planifier un programme avec un objectif prise de masse.")
    @Test
    void planifier_programme_prise_de_masse(){
        //Given

        AlimentsDAO alimentsDAO = new Aliments();
        ExercicesDAO exercicesDAO = new Exercices();

        DonneesUtilisateur donneesUtilisateur = new DonneesUtilisateur(POIDS, TAILLE, AGE, List.of(AlimentType.fruitsSecs));

        //When
        Programme programme = new PlanifierPDM(donneesUtilisateur,alimentsDAO, exercicesDAO).appliquer();

        //Then
        Assertions.assertNotNull(programme);
        Assertions.assertEquals(2, programme.getAliments().size());
        Assertions.assertEquals(3, programme.getExercices().size());
        Assertions.assertEquals(1, programme.getAllergies().size());
        Assertions.assertEquals(AlimentType.fruitsSecs, programme.getAllergies().get(0));
    }
}
