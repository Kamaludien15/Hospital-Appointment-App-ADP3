package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.api.EmployeeAPI;
import za.ac.cput.domain.Employee;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hospital_appointment_management-db/employee")
@Slf4j
public class EmployeeController {

    private EmployeeAPI employeeAPI;

    @Autowired
    public EmployeeController(EmployeeAPI employeeAPI) {
        this.employeeAPI = employeeAPI;
    }

    @PostMapping("save")
    public ResponseEntity<Employee> save(@Valid @RequestBody Employee employee){
        log.info("Save request: {}", employee);
        Employee response = this.employeeAPI.save(employee);
        return ResponseEntity.ok(response);
    }

    @GetMapping("read/{employee_id}")
    public ResponseEntity<Employee> read(@PathVariable String employee_id){
        log.info("Read request: {}", employee_id);
        Employee response = this.employeeAPI.read(employee_id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete/{employee}")
    public ResponseEntity<Void> delete(@PathVariable Employee employee){
        log.info("Delete request: {}", employee);
        this.employeeAPI.delete(employee);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Employee>> getAll(){
        List<Employee> response = this.employeeAPI.getAll();
        return ResponseEntity.ok(response);
    }

}
