package org.example.domain.vo;

import org.example.domain.exceptions.BulkingException;

import java.util.Objects;

public class Bulking {

    private final BaseMetabolicRate bmr;
    private final double value;

    public Bulking(BaseMetabolicRate bmr) throws BulkingException {
        if(bmr.getBmr() < 1000){
            throw new BulkingException("bmr doit etre inferieur a 3000");
        }
        this.bmr = bmr;
        this.value = bmr.getBmr() + 200;
    }
    public BaseMetabolicRate getBmr() {
        return bmr;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bulking bulking = (Bulking) o;
        return Double.compare(bulking.value, value) == 0 && Objects.equals(bmr, bulking.bmr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bmr, value);
    }
}
