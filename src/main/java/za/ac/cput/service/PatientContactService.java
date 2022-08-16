package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.PatientContact;
import za.ac.cput.factory.PatientContactFactory;
import za.ac.cput.repository.IPatientContactRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PatientContactService implements IPatientContactService{

    private static IPatientContactRepository repository = null;

    @Autowired
    private PatientContactService(IPatientContactRepository patientContactRepository){
        this.repository = patientContactRepository;
    }

    @Override
    public PatientContact save(PatientContact patientContact) {
        PatientContact obj = PatientContactFactory.createPatientContact(patientContact.getContactType(), patientContact.getPatient());
        return this.repository.save(obj);
    }

    @Override
    public Optional<PatientContact> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(PatientContact patientContact) {
        this.repository.delete(patientContact);
    }

    @Override
    public List<PatientContact> getAll() {
        return this.repository.findAll();
    }
}
