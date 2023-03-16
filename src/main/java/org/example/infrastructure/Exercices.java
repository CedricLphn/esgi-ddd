package org.example.infrastructure;

import org.example.domain.model.Exercice;
import org.example.domain.model.ExerciceId;
import org.example.domain.model.ExerciceType;

import java.util.List;

public class Exercices implements ExercicesDAO {

    List<Exercice> exercices = List.of(
            new Exercice(new ExerciceId(),"Squats", ExerciceType.pdm),
            new Exercice(new ExerciceId(), "Bench Press", ExerciceType.pdm),
            new Exercice(new ExerciceId(), "Deadlift", ExerciceType.pdm),
            new Exercice(new ExerciceId(), "Tractions", ExerciceType.seche),
            new Exercice(new ExerciceId(), "Dips", ExerciceType.seche),
            new Exercice(new ExerciceId(), "Crunch", ExerciceType.seche)
    );

    @Override
    public List<Exercice> obtenirTout() {
        return this.exercices;
    }
}
