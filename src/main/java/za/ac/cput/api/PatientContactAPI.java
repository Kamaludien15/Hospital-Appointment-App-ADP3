package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.PatientContact;
import za.ac.cput.service.IContactTypeService;
import za.ac.cput.service.IPatientContactService;
import za.ac.cput.service.IPatientService;

import java.util.List;
import java.util.Optional;

@Component
public class PatientContactAPI {
    private final IPatientContactService patientContactService;
    private final IContactTypeService contactTypeService;
    private final IPatientService patientService;

    @Autowired
    public PatientContactAPI(IPatientContactService patientContactService, IContactTypeService contactTypeService, IPatientService patientService){
        this.patientContactService = patientContactService;
        this.contactTypeService = contactTypeService;
        this.patientService = patientService;
    }

    public PatientContact save(PatientContact patientContact){
        this.contactTypeService.read(patientContact.getContactType().getContactTypeId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found"));
        this.patientService.read(patientContact.getPatient().getPatientID()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found"));
        return this.patientContactService.save(patientContact);
    }

    public Optional<PatientContact> read(String id){
        return this.patientContactService.read(id);
    }

    public void delete(PatientContact patientContact){
        this.patientContactService.delete(patientContact);
    }

    public List<PatientContact> getAll(){
        return this.patientContactService.getAll();
    }
}
