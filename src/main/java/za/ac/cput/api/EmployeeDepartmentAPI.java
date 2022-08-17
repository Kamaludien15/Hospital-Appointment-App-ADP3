package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.EmployeeDepartment;
import za.ac.cput.service.IEmployeeDepartmentService;
import za.ac.cput.service.IEmployeeService;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDepartmentAPI {

    private final IEmployeeDepartmentService iEmployeeDepartmentService;

    @Autowired
    public EmployeeDepartmentAPI(IEmployeeDepartmentService iEmployeeDepartmentService){
        this.iEmployeeDepartmentService = iEmployeeDepartmentService;
    }

    public EmployeeDepartment save(EmployeeDepartment employeeDepartment) {
        return this.iEmployeeDepartmentService.save(employeeDepartment);
    }

    public Optional<EmployeeDepartment> read(String id) {
        return this.iEmployeeDepartmentService.read(id);
    }

    public void delete(EmployeeDepartment employeeDepartment) {
        this.iEmployeeDepartmentService.delete(employeeDepartment);
    }

    public List<EmployeeDepartment> getAll() {
        return this.iEmployeeDepartmentService.getAll();
    }

}
