package shared.allergie;

import org.example.domain.enums.AlimentType;

import java.util.List;

public class Allergie {
    List<AlimentType> allergies;

    public Allergie() {
    }

    public List<AlimentType> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<AlimentType> allergies) {
        this.allergies = allergies;
    }
}
