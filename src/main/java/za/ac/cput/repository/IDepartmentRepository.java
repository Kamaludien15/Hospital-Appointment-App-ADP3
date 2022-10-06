package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Department;

@Repository
public interface IDepartmentRepository extends JpaRepository<Department, String> {
    //public Department findDepartmentByDepartmentName(String departmentName);
}
