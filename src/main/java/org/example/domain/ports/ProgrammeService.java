package org.example.domain.ports;

import org.example.domain.entity.Programme;
import org.example.domain.exceptions.BaseMetabolicRateException;
import org.example.domain.exceptions.BulkingException;

import java.util.List;

public interface ProgrammeService {

    Programme creerUnProgrammePdm(double poids, double taille, int age, List<String> allergies) throws BaseMetabolicRateException, BulkingException;
}
