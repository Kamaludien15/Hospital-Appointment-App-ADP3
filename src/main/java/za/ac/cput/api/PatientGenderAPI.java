package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.domain.PatientGender;
import za.ac.cput.service.IPatientGenderService;

import java.util.List;
import java.util.Optional;

@Component
public class PatientGenderAPI {

    private final IPatientGenderService patientGenderService;

    @Autowired
    public PatientGenderAPI(IPatientGenderService patientGenderService) {
        this.patientGenderService = patientGenderService;
    }

    public PatientGender save(PatientGender patientGender) {
        return this.patientGenderService.save(patientGender);
    }

    public Optional<PatientGender> read(String id) {
        return this.patientGenderService.read(id);
    }

    public void delete(PatientGender patientGender) {
        this.patientGenderService.delete(patientGender);
    }


    public List<PatientGender> getAll() {
        return this.patientGenderService.getAll();
    }
}
