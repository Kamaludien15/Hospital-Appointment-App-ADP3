package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.api.PatientAPI;
import za.ac.cput.domain.Patient;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hospital_appointment_management-db/patient")
@Slf4j
public class PatientController {

    private PatientAPI api;

    @Autowired
    public PatientController(PatientAPI api) {
        this.api = api;
    }

    @PostMapping("save")
    public ResponseEntity<Patient> save(@Valid @RequestBody Patient patient){
        log.info("Save request: {}", patient);
        Patient response = this.api.save(patient);
        return ResponseEntity.ok(response);
    }

    @GetMapping("read/{patient_id}")
    public ResponseEntity<Patient> read(@PathVariable String id){
        log.info("Read request: {}", id);
        Patient response = this.api.read(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found"));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete/{patient}")
    public ResponseEntity<Void> delete(@PathVariable Patient patient){
        log.info("Delete request: {}", patient);
        this.api.delete(patient);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Patient>> getAll(){
        List<Patient> response = this.api.getAll();
        return ResponseEntity.ok(response);
    }
}