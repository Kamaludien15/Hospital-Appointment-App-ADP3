package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.EmployeeDepartment;

import java.util.List;

@Service
public interface IEmployeeDepartmentService extends IService<EmployeeDepartment, String>{
    public List<EmployeeDepartment> getAll();
}
