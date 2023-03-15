package example.use_case.pdm;

import org.example.model.DonneesUtilisateur;
import org.example.use_case.pdm.PlanifierPDM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DevraPlanifier {

    @DisplayName("Devrait planifier un programme avec un objectif prise de masse.")
    @Test
    void planifier_programme_prise_de_masse(){
        //Given
        DonneesUtilisateur donneesUtilisateur = new DonneesUtilisateur(poids, taille, age);
        // taille poids age

        //When
        PlanifierPDM planifierPDM = new PlanifierPDM(donneesUtilisateur);
        var data = planifierPDM.appliquer();

        //Then
        Assertions.assertNotNull(data);

    }
}
