package org.example.infrastructure;

import org.example.domain.model.Aliment;

import java.util.List;

public interface AlimentsDAO {
    List<Aliment> obtenirTout();

}
