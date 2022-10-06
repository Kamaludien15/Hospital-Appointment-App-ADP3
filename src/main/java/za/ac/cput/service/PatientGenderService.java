package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.PatientGender;
import za.ac.cput.factory.PatientGenderFactory;
import za.ac.cput.repository.IPatientGenderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PatientGenderService implements IPatientGenderService{

    private static IPatientGenderRepository repository = null;

    @Autowired
    private PatientGenderService(IPatientGenderRepository patientGenderRepository){
        this.repository = patientGenderRepository;
    }

    @Override
    public PatientGender save(PatientGender patientGender) {
        PatientGender obj = PatientGenderFactory.createPatientGender(patientGender.getPatientID(), patientGender.getGenderID());
        return this.repository.save(obj);
    }

    @Override
    public Optional<PatientGender> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(PatientGender patientGender) {
        this.repository.delete(patientGender);
    }

    @Override
    public List<PatientGender> getAll() {
        return this.repository.findAll();
    }
}
