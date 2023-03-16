package org.example.domain.vo;

import org.example.domain.exceptions.BaseMetabolicRateException;

import java.util.Objects;

public class BaseMetabolicRate {

    private final double value;

    public BaseMetabolicRate(double poids, double taille, int age) throws BaseMetabolicRateException {
        if(age < 16 || poids < 40){
            throw new BaseMetabolicRateException("L'âge doit être supérieur à 16 ans et le poids supérieur à 40 kg");
        }
        this.value = 66.5 + (13.75 * poids) + (5.003 * taille) - (6.75 * age);
    }
    public double getBmr() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseMetabolicRate that = (BaseMetabolicRate) o;
        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
    
}
