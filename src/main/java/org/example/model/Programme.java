package org.example.model;

import java.util.List;
import java.util.Objects;

public class Programme {

    List<Aliment> aliments;
    double calories;

    private Programme() {
    }

    public static Programme creer(List<Aliment> aliments, double calories){
        var prog = new Programme();
        prog.setAliments(aliments);
        prog.setCalories(calories);
        return prog;
    }

    public List<Aliment> getAliments() {
        return aliments;
    }

    public void setAliments(List<Aliment> aliments) {
        this.aliments = aliments;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Programme programme = (Programme) o;
        return Double.compare(programme.calories, calories) == 0 && Objects.equals(aliments, programme.aliments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aliments, calories);
    }

    @Override
    public String toString() {
        return "Programme{" +
                "aliments=" + aliments +
                ", calories=" + calories +
                '}';
    }
}
