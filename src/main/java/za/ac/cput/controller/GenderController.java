package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.api.GenderAPI;
import za.ac.cput.domain.Gender;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hospital_appointment_management-db/gender")
@Slf4j
public class GenderController {
    private GenderAPI api;

    @Autowired
    public GenderController(GenderAPI api) {
        this.api = api;
    }

    @PostMapping("save")
    public ResponseEntity<Gender> save(@Valid @RequestBody Gender gender){
        log.info("Save request: {}", gender);
        Gender response = this.api.save(gender);
        return ResponseEntity.ok(response);
    }

    @GetMapping("read/{gender_id}")
    public ResponseEntity<Gender> read(@PathVariable String id){
        log.info("Read request: {}", id);
        Gender response = this.api.read(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Gender not found"));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete/{gender}")
    public ResponseEntity<Void> delete(@PathVariable Gender gender){
        log.info("Delete request: {}", gender);
        this.api.delete(gender);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Gender>> getAll(){
        List<Gender> response = this.api.getAll();
        return ResponseEntity.ok(response);
    }
}
