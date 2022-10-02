package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.api.ProcedureAPI;
import za.ac.cput.domain.Procedure;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hospital_appointment_management-db/procedure")
@Slf4j
public class ProcedureController {
    private final ProcedureAPI api;

    @Autowired
    public ProcedureController(ProcedureAPI api) {
        this.api = api;
    }

    @PostMapping("save")
    public ResponseEntity<Procedure> save(@RequestBody @Valid Procedure procedure) {
        log.info("Save request: {}", procedure);
        Procedure save = this.api.save(procedure);

        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Procedure> read(@PathVariable String id) {
        log.info("Read request: {}", id);
        Procedure procedure = this.api.read(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Procedure Not Found"));

        return ResponseEntity.ok(procedure);
    }

    @DeleteMapping("delete/{procedure}")
    public ResponseEntity<Void> delete(@PathVariable Procedure procedure) {
        log.info("Delete request: {}", procedure);
        this.api.delete(procedure);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Procedure>> getAll() {
        List<Procedure> procedures = this.api.getAll();

        return ResponseEntity.ok(procedures);
    }
}
