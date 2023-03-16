package org.example.domain.ports;

import org.example.domain.entity.Exercice;

import java.util.List;

public interface ExercicesDAO {

    List<Exercice> obtenirTout();

}
