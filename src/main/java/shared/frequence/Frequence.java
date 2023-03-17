package shared.frequence;

import org.example.domain.exceptions.FrequenceException;

import java.util.Objects;

public class Frequence {

    private final int value;

    public Frequence(int value) throws FrequenceException {
        if(value < 1 || value > 7) {
            throw new FrequenceException("la frequence doit etre comprise entre 1 et 7.");
        }

        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frequence frequence = (Frequence) o;
        return value == frequence.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
