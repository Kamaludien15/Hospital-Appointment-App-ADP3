package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.api.EmployeeContactAPI;
import za.ac.cput.domain.EmployeeContact;
import java.util.List;

@RestController
@RequestMapping("/hospital_appointment_management-db/EmployeeContact")
@Slf4j
public class EmployeeContactController {

    private EmployeeContactAPI api;

    @Autowired
    public EmployeeContactController(EmployeeContactAPI api){this.api = api;}

    @PostMapping("save")
    public ResponseEntity<EmployeeContact> save(@RequestBody EmployeeContact employeeContact){
        log.info("Save request: {}", employeeContact);
        EmployeeContact response = this.api.save(employeeContact);
        return ResponseEntity.ok(response);
    }

    @GetMapping("read/{employee_contact_id}")
    public ResponseEntity<EmployeeContact> read(@PathVariable String id){
        log.info("Read request: {}", id);
        EmployeeContact response = this.api.read(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee contact not found"));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete/{employeeContact}")
    public ResponseEntity<Void> delete(@PathVariable EmployeeContact employeeContact){
        log.info("Delete request: {}", employeeContact);
        this.api.delete(employeeContact);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<EmployeeContact>> getAll(){
        List<EmployeeContact> response = this.api.getAll();
        return ResponseEntity.ok(response);
    }
}