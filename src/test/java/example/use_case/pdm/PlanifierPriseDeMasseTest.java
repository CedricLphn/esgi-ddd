package example.use_case.pdm;

import org.example.domain.exceptions.BaseMetabolicRateException;
import org.example.domain.exceptions.BulkingException;
import org.example.domain.exceptions.FrequenceException;
import org.example.domain.ports.ProgrammeService;
import org.example.domain.service.SimpleProgramme;
import org.example.domain.vo.BaseMetabolicRate;
import org.example.domain.vo.Bulking;
import shared.frequence.Frequence;
import org.example.use_case.pdm.DonneesUtilisateurDTO;
import org.example.domain.entity.Programme;
import org.example.domain.enums.AlimentType;
import org.example.infrastructure.adapters.Aliments;
import org.example.domain.ports.AlimentsDAO;
import org.example.infrastructure.adapters.Exercices;
import org.example.domain.ports.ExercicesDAO;
import org.example.use_case.pdm.PlanifierPDM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class PlanifierPriseDeMasseTest {

    private static final int AGE = 20;
    private static final double TAILLE = 1.80;
    private static final int POIDS = 80;

    @DisplayName("Devrait planifier un programme avec un objectif prise de masse avec une allergie.")
    @Test
    void planifier_programme_prise_de_masse_avec_allergie_succes() throws BulkingException, BaseMetabolicRateException, FrequenceException {
        //Given

        AlimentsDAO alimentsDAO = new Aliments();
        ExercicesDAO exercicesDAO = new Exercices();
        ProgrammeService programmeService = new SimpleProgramme(alimentsDAO, exercicesDAO);

        DonneesUtilisateurDTO donneesUtilisateur = new DonneesUtilisateurDTO(POIDS, TAILLE, AGE, List.of("fruitsSecs"), new Frequence(3));

        //When
        Programme programme = new PlanifierPDM(donneesUtilisateur, programmeService).appliquer();

        //Then
        Assertions.assertNotNull(programme);
        Assertions.assertEquals(2, programme.getAliments().size());
        Assertions.assertEquals(3, programme.getExercices().size());
        Assertions.assertEquals(1, programme.getAllergies().size());
        Assertions.assertEquals(AlimentType.fruitsSecs, programme.getAllergies().get(0));
    }

    @DisplayName("Devrait planifier un programme avec un objectif prise de masse sans allergie.")
    @Test
    void planifier_programme_prise_de_masse_sans_allergie_succes() throws BulkingException, BaseMetabolicRateException, FrequenceException {
        //Given

        AlimentsDAO alimentsDAO = new Aliments();
        ExercicesDAO exercicesDAO = new Exercices();
        ProgrammeService programmeService = new SimpleProgramme(alimentsDAO, exercicesDAO);


        DonneesUtilisateurDTO donneesUtilisateur = new DonneesUtilisateurDTO(POIDS, TAILLE, AGE, List.of("aucun"), new Frequence(5));

        //When
        Programme programme = new PlanifierPDM(donneesUtilisateur, programmeService).appliquer();

        //Then
        Assertions.assertNotNull(programme);
        Assertions.assertEquals(2, programme.getAliments().size());
        Assertions.assertEquals(3, programme.getExercices().size());
        Assertions.assertEquals(1, programme.getAllergies().size());
        Assertions.assertEquals(AlimentType.aucun, programme.getAllergies().get(0));
    }

    @DisplayName("Devrait planifier un programme avec une fréquence très élevé")
    @Test
    void planifier_programme_frequence_incorrecte() {
        //Given

        AlimentsDAO alimentsDAO = new Aliments();
        ExercicesDAO exercicesDAO = new Exercices();
        ProgrammeService programmeService = new SimpleProgramme(alimentsDAO, exercicesDAO);

        FrequenceException exception = Assertions.assertThrows(FrequenceException.class, () -> {
            DonneesUtilisateurDTO donneesUtilisateur = new DonneesUtilisateurDTO(POIDS, TAILLE, AGE, List.of("aucun"), new Frequence(99));
        });

        Assertions.assertEquals("la frequence doit etre comprise entre 1 et 7.", exception.getMessage());

    }

    @DisplayName("Devrait planifier un programme avec un BMR faux")
    @Test
    void planifier_programme_bmr_faux() throws BulkingException, BaseMetabolicRateException {
        //Given

        AlimentsDAO alimentsDAO = new Aliments();
        ExercicesDAO exercicesDAO = new Exercices();
        ProgrammeService programmeService = new SimpleProgramme(alimentsDAO, exercicesDAO);


        BaseMetabolicRateException exception = Assertions.assertThrows(BaseMetabolicRateException.class, () -> {
            Programme programme = Programme.creer(List.of(), List.of(), List.of(), new Bulking(new BaseMetabolicRate(20d, 13d, 13)));
        });

        Assertions.assertEquals("L'âge doit être supérieur à 16 ans et le poids supérieur à 40 kg", exception.getMessage());

    }

    @DisplayName("Devrait planifier un programme avec un BMR faux")
    @Test
    void planifier_programme_bmr_inferieur_a_1000() throws BulkingException, BaseMetabolicRateException {
        //Given

        AlimentsDAO alimentsDAO = new Aliments();
        ExercicesDAO exercicesDAO = new Exercices();
        ProgrammeService programmeService = new SimpleProgramme(alimentsDAO, exercicesDAO);


        BulkingException exception = Assertions.assertThrows(BulkingException.class, () -> {
            new Bulking(new BaseMetabolicRate(40d, 0d, 16));
        });

        Assertions.assertEquals("bmr doit etre inferieur a 3000", exception.getMessage());

    }


}
