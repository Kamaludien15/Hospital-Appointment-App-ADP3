package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.api.DepartmentAPI;
import za.ac.cput.domain.Department;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hospital_appointment_management-db/department")
@Slf4j
public class DepartmentController {

    private DepartmentAPI departmentAPI;

    @Autowired
    public DepartmentController(DepartmentAPI departmentAPI) {
        this.departmentAPI = departmentAPI;
    }

    @PostMapping("save")
    public ResponseEntity<Department> save(@Valid @RequestBody Department department){
        log.info("Save request: {}", department);
        Department response = this.departmentAPI.save(department);
        return ResponseEntity.ok(response);
    }

    @GetMapping("read/{department_id}")
    public ResponseEntity<Department> read(@PathVariable String departmentId){
        log.info("Read request: {}", departmentId);
        Department response = this.departmentAPI.read(departmentId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Department not found"));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete/{department}")
    public ResponseEntity<Void> delete(@PathVariable Department department){
        log.info("Delete request: {}", department);
        this.departmentAPI.delete(department);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Department>> getAll(){
        List<Department> response = this.departmentAPI.getAll();
        return ResponseEntity.ok(response);
    }
}
