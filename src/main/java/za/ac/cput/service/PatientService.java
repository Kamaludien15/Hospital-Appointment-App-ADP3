/**
 * Rhegan Albert Fortuin
 * 219273693
 * PatientService
 * 15 August 2022
 */

package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Patient;
import za.ac.cput.factory.PatientFactory;
import za.ac.cput.repository.IPatientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService {
    public static IPatientRepository repository = null;

    @Autowired
    private PatientService(IPatientRepository patientRepository){
        this.repository = patientRepository;
    }

    @Override
    public Patient save(Patient patient) {
        Patient obj = PatientFactory.createPatient(patient.getPatientFirstName(), patient.getPatientLastName(), patient.getPatientDateOfBirth());
        return this.repository.save(obj);
    }

    @Override
    public Optional<Patient> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Patient patient) {
        this.repository.delete(patient);
    }

    @Override
    public List<Patient> getAll() {
        return this.repository.findAll();
    }
}
