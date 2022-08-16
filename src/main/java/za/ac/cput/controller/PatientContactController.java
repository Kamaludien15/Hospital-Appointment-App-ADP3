package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.api.PatientContactAPI;
import za.ac.cput.domain.PatientContact;

import java.util.List;

@RestController
@RequestMapping("/hospital_appointment_management-db/PatientContact")
public class PatientContactController {

    private PatientContactAPI api;

    @Autowired public PatientContactController(PatientContactAPI api){this.api = api;}

    @PostMapping("save")
    public ResponseEntity<PatientContact> save(@RequestBody PatientContact patientContact){
        log.info("Save request: {}", patientContact);
        PatientContact response = this.api.save(patientContact);
        return ResponseEntity.ok(response);
    }

    @GetMapping("read/{patient_contact_id}")
    public ResponseEntity<PatientContact> read(@PathVariable String id){
        log.info("Read request: {}", id);
        PatientContact response = this.api.read(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient contact not found"));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete/{patientContact}")
    public ResponseEntity<Void> delete(@PathVariable PatientContact patientContact){
        log.info("Delete request: {}", patientContact);
        this.api.delete(patientContact);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<PatientContact>> getAll(){
        List<PatientContact> response = this.api.getAll();
        return ResponseEntity.ok(response);
    }
}
