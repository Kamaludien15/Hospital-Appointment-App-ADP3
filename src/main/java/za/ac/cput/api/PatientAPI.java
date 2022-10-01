package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.domain.Patient;
import za.ac.cput.service.IPatientService;

import java.util.List;
import java.util.Optional;

@Component
public class PatientAPI {

    private final IPatientService patientService;

    @Autowired
    public PatientAPI(IPatientService patientService) {
        this.patientService = patientService;
    }

    public Patient save(Patient patient) {
        return this.patientService.save(patient);
    }

    public Optional<Patient> read(String id) {
        return this.patientService.read(id);
    }

    public void delete(Patient patient) {
        this.patientService.delete(patient);
    }


    public List<Patient> getAll() {
        return this.patientService.getAll();
    }
}
