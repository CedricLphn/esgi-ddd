package org.example.domain.ports;

import org.example.domain.entity.Aliment;

import java.util.List;

public interface AlimentsDAO {
    List<Aliment> obtenirTout();

}
