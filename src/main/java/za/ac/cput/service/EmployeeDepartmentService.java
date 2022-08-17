package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.EmployeeDepartment;
import za.ac.cput.factory.EmployeeDepartmentFactory;
import za.ac.cput.repository.IEmployeeDepartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeDepartmentService implements IEmployeeDepartmentService{

    private static IEmployeeDepartmentRepository employeeDepartmentRepository = null;

    @Autowired
    private EmployeeDepartmentService(IEmployeeDepartmentRepository employeeDepartmentRepository) {
        this.employeeDepartmentRepository = employeeDepartmentRepository;
    }

    @Override
    public EmployeeDepartment save(EmployeeDepartment employeeDepartment){
        EmployeeDepartment employeeDepartmentObj = EmployeeDepartmentFactory
                .createEmployeeDepartment(employeeDepartment.getEmployee(),
                        employeeDepartment.getDepartment());

        return this.employeeDepartmentRepository.save(employeeDepartmentObj);
    }

    @Override
    public Optional<EmployeeDepartment> read(String employeeDepartmentId) {
        return this.employeeDepartmentRepository.findById(employeeDepartmentId);
    }

    @Override
    public void delete(EmployeeDepartment employeeDepartment) {
        this.employeeDepartmentRepository.delete(employeeDepartment);
    }

    @Override
    public List<EmployeeDepartment> getAll() {
        return this.employeeDepartmentRepository.findAll();
    }

}
