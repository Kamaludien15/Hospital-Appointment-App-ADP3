package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.repository.IEmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    private static IEmployeeRepository employeeRepository = null;

    @Autowired
    private EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee save(Employee employee){
        return this.employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> read(String employeeId) {
        return this.employeeRepository.findById(employeeId);
    }

    @Override
    public void delete(Employee employee) {
        this.employeeRepository.delete(employee);
    }

    @Override
    public List<Employee> getAll() {
        return this.employeeRepository.findAll();
    }

}
