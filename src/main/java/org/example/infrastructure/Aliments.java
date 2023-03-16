package org.example.infrastructure;

import org.example.domain.model.Aliment;
import org.example.domain.model.AlimentId;
import org.example.domain.model.AlimentType;
import org.example.domain.model.RegimeType;

import java.util.List;

public class Aliments implements AlimentsDAO {

    private final List<Aliment> aliments = List.of(
            new Aliment(new AlimentId(), "Banane", 5, 10, 1, RegimeType.MODEREE, AlimentType.aucun),
            new Aliment(new AlimentId(), "Cacahuètes", 5, 10, 1, RegimeType.MODEREE, AlimentType.fruitsSecs),
            new Aliment(new AlimentId(), "Beurre", 5, 10, 20, RegimeType.FLEXIBLE, AlimentType.aucun),
            new Aliment(new AlimentId(), "Oeuf", 20, 5, 1, RegimeType.STRICT, AlimentType.aucun));
    @Override
    public List<Aliment> obtenirTout() {
        return this.aliments;
    }
}
