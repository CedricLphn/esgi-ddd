package org.example.infrastructure.adapters;

import org.example.domain.ports.ExercicesDAO;
import org.example.domain.entity.Exercice;
import org.example.domain.vo.ExerciceId;
import org.example.domain.enums.ExerciceType;

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
