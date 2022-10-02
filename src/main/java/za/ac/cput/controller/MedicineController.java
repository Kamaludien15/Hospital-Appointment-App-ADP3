package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.api.MedicineAPI;
import za.ac.cput.domain.Medicine;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hospital_appointment_management-db/medicine")
@Slf4j
public class MedicineController {
    private final MedicineAPI api;

    @Autowired
    public MedicineController(MedicineAPI api) {
        this.api = api;
    }

    @PostMapping("save")
    public ResponseEntity<Medicine> save(@RequestBody @Valid Medicine medicine) {
        log.info("Save request: {}", medicine);
        Medicine save = this.api.save(medicine);

        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Medicine> read(@PathVariable String id) {
        log.info("Read request: {}", id);
        Medicine medicine = this.api.read(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medicine Not Found"));

        return ResponseEntity.ok(medicine);
    }

    @DeleteMapping("delete/{medicine}")
    public ResponseEntity<Void> delete(@PathVariable Medicine medicine) {
        log.info("Delete request: {}", medicine);
        this.api.delete(medicine);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Medicine>> getAll() {
        List<Medicine> medicines = this.api.getAll();

        return ResponseEntity.ok(medicines);
    }
}
