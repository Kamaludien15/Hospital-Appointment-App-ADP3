package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.api.EmployeeDepartmentAPI;
import za.ac.cput.domain.EmployeeDepartment;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hospital_appointment_management-db/employeeDepartment")
@Slf4j
public class EmployeeDepartmentController {

    private EmployeeDepartmentAPI employeeDepartmentApi;

    @Autowired
    public EmployeeDepartmentController(EmployeeDepartmentAPI employeeDepartmentApi) {
        this.employeeDepartmentApi = employeeDepartmentApi;
    }

    @PostMapping("saveEmployeeDepartment")
    public ResponseEntity<EmployeeDepartment> save(@Valid @RequestBody EmployeeDepartment employeeDepartment){
        log.info("Save request: {}", employeeDepartment);
        EmployeeDepartment response = this.employeeDepartmentApi.save(employeeDepartment);
        return ResponseEntity.ok(response);
    }

    @GetMapping("readEmployeeDepartment/{employeeDepartmentId}")
    public ResponseEntity<EmployeeDepartment> read(@PathVariable String employeeDepartmentId){
        log.info("Read request: {}", employeeDepartmentId);
        EmployeeDepartment response = this.employeeDepartmentApi.read(employeeDepartmentId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Department not found"));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("deleteEmployeeInDepartment/{employeeInDepartment}")
    public ResponseEntity<Void> delete(@PathVariable EmployeeDepartment employeeInDepartment){
        log.info("Delete request: {}", employeeInDepartment);
        this.employeeDepartmentApi.delete(employeeInDepartment);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getAllEmployeeDepartments")
    public ResponseEntity<List<EmployeeDepartment>> getAll(){
        List<EmployeeDepartment> response = this.employeeDepartmentApi.getAll();
        return ResponseEntity.ok(response);
    }

}
