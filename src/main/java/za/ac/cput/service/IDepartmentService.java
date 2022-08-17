package za.ac.cput.service;

import za.ac.cput.domain.Department;

import java.util.List;

public interface IDepartmentService extends IService<Department, String>{
    public List<Department> getAll();
}
