package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.EmployeeDepartment;

@Repository
public interface IEmployeeDepartmentRepository extends JpaRepository<EmployeeDepartment, String> {
    //public EmployeeDepartment findEmployeeDepartmentByDepartmentName(String departmentName);
}
