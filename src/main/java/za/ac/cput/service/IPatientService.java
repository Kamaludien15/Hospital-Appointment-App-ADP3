/**
 * Rhegan Albert Fortuin
 * 219273693
 * IPatientService
 * 15 August 2022
 */

package za.ac.cput.service;

import za.ac.cput.domain.Patient;
import java.util.List;

public interface IPatientService extends IService<Patient, String>{

    public List<Patient> getAll();
}
