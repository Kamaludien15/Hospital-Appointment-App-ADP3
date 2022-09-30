package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.domain.Department;
import za.ac.cput.domain.EmployeeDepartment;
import za.ac.cput.service.IDepartmentService;
import za.ac.cput.service.IEmployeeDepartmentService;

import java.util.List;
import java.util.Optional;

@Component
public class DepartmentAPI {

    private final IDepartmentService iDepartmentService;

    @Autowired
    public DepartmentAPI(IDepartmentService iDepartmentService){
        this.iDepartmentService = iDepartmentService;
    }

    public Department save(Department department) {
        return this.iDepartmentService.save(department);
    }

    public Optional<Department> read(String id) {
        return this.iDepartmentService.read(id);
    }

    public void delete(Department department) {
        this.iDepartmentService.delete(department);
    }

    public List<Department> getAll() {
        return this.iDepartmentService.getAll();
    }

}
