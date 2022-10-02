package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.api.PrescriptionAPI;
import za.ac.cput.domain.Prescription;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hospital_appointment_management-db/prescription")
@Slf4j
public class PrescriptionController {
    private final PrescriptionAPI api;

    @Autowired
    public PrescriptionController(PrescriptionAPI api) {
        this.api = api;
    }

    @PostMapping("save")
    public ResponseEntity<Prescription> save(@RequestBody @Valid Prescription prescription) {
        log.info("Save request: {}", prescription);
        Prescription save = this.api.save(prescription);

        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Prescription> read(@PathVariable String id) {
        log.info("Read request: {}", id);
        Prescription prescription = this.api.read(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Prescription Not Found"));

        return ResponseEntity.ok(prescription);
    }

    @DeleteMapping("delete/{prescription}")
    public ResponseEntity<Void> delete(@PathVariable Prescription prescription) {
        log.info("Delete request: {}", prescription);
        this.api.delete(prescription);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Prescription>> getAll() {
        List<Prescription> prescriptions = this.api.getAll();

        return ResponseEntity.ok(prescriptions);
    }
}
