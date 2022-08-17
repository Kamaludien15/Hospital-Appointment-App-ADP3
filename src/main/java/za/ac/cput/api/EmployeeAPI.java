package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.domain.Employee;
import za.ac.cput.service.IEmployeeService;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeAPI {

    private final IEmployeeService iEmployeeService;

    @Autowired
    public EmployeeAPI(IEmployeeService iEmployeeService){
        this.iEmployeeService = iEmployeeService;
    }

    public Employee save(Employee employee) {
        return this.iEmployeeService.save(employee);
    }

    public Optional<Employee> read(String id) {
        return this.iEmployeeService.read(id);
    }

    public void delete(Employee employee) {
        this.iEmployeeService.delete(employee);
    }

    public List<Employee> getAll() {
        return this.iEmployeeService.getAll();
    }

}
