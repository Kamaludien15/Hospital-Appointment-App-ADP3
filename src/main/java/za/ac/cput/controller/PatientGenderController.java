package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.api.AppointmentAPI;
import za.ac.cput.api.PatientGenderAPI;
import za.ac.cput.domain.Appointment;
import za.ac.cput.domain.PatientGender;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hospital_appointment_management-db/patientgender")
@Slf4j
public class PatientGenderController {

    private PatientGenderAPI api;

    @Autowired
    public PatientGenderController(PatientGenderAPI api) {
        this.api = api;
    }

    @PostMapping("save")
    public ResponseEntity<PatientGender> save(@Valid @RequestBody PatientGender patientGender){
        log.info("Save request: {}", patientGender);
        PatientGender response = this.api.save(patientGender);
        return ResponseEntity.ok(response);
    }

    @GetMapping("read/{appointment_id}")
    public ResponseEntity<PatientGender> read(@PathVariable String id){
        log.info("Read request: {}", id);
        PatientGender response = this.api.read(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "PatientGender not found"));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete/{appointment}")
    public ResponseEntity<Void> delete(@PathVariable PatientGender patientGender){
        log.info("Delete request: {}", patientGender);
        this.api.delete(patientGender);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<PatientGender>> getAll(){
        List<PatientGender> response = this.api.getAll();
        return ResponseEntity.ok(response);
    }
}