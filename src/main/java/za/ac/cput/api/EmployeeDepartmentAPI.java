package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.domain.EmployeeDepartment;
import za.ac.cput.service.IEmployeeDepartmentService;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDepartmentAPI {

    private final IEmployeeDepartmentService employeeDepartmentService;

    @Autowired
    public EmployeeDepartmentAPI(IEmployeeDepartmentService employeeDepartmentService){
        this.employeeDepartmentService = employeeDepartmentService;
    }

    public EmployeeDepartment save(EmployeeDepartment employeeDepartment) {
        return this.employeeDepartmentService.save(employeeDepartment);
    }

    public Optional<EmployeeDepartment> read(String id) {
        return this.employeeDepartmentService.read(id);
    }

    public void delete(EmployeeDepartment employeeDepartment) {
        this.employeeDepartmentService.delete(employeeDepartment);
    }

    public List<EmployeeDepartment> getAll() {
        return this.employeeDepartmentService.getAll();
    }

}
