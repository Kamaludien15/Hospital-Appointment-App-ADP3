package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Department;
import za.ac.cput.factory.DepartmentFactory;
import za.ac.cput.repository.IDepartmentRepository;


import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements IDepartmentService{

    private static IDepartmentRepository departmentRepository = null;

    @Autowired
    private DepartmentService(IDepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department save(Department department){
        return this.departmentRepository.save(department);
    }

    @Override
    public Optional<Department> read(String departmentId) {
        return this.departmentRepository.findById(departmentId);
    }

    @Override
    public void delete(Department department) {
        this.departmentRepository.delete(department);
    }

    @Override
    public List<Department> getAll() {
        return this.departmentRepository.findAll();
    }


}
