package shared.allergie;

import org.example.domain.enums.AlimentType;

import java.util.List;
import java.util.Objects;

public final class Allergie {
    final List<AlimentType> allergies;

    public Allergie(List<AlimentType> allergies) {
        this.allergies = allergies;
    }

    public List<AlimentType> getAllergies() {
        return allergies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Allergie allergie = (Allergie) o;
        return Objects.equals(allergies, allergie.allergies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allergies);
    }
}
