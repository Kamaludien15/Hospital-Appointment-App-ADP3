package za.ac.cput.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Department;
import za.ac.cput.factory.DepartmentFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class IDepartmentRepositoryTest {

    @Autowired
    private IDepartmentRepository departmentRepository;

    private Department department;

    @BeforeEach
    void setUp(){
        this.department = DepartmentFactory.createDepartment(this.department.getDepartmentName(),
                this.department.getDepartmentSize(),
                this.department.getDepartmentFloor());
    }

    @AfterEach
    void tearDown(){
        this.departmentRepository.delete(this.department);
    }

    @Test
    void save(){
        Department save = this.departmentRepository.save(this.department);
        System.out.println(save);
        assertAll(()->assertNotNull(save),
                ()->assertSame(this.department.getDepartmentId(), save.getDepartmentId()));
    }

    @Test void read(){
        Department saved = this.departmentRepository.save(this.department);
        Optional<Department> read = this.departmentRepository.findById(this.department.getDepartmentId());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved.getDepartmentId(), read.get().getDepartmentId())
        );
    }

    @Test
    void delete(){
        Department saved = this.departmentRepository.save(this.department);
        this.departmentRepository.delete(saved);
        List<Department> departmentList = this.departmentRepository.findAll();
        assertEquals(0, departmentList.size());
    }

    @Test
    void getAll(){
        this.departmentRepository.save(this.department);
        List<Department> departmentList = this.departmentRepository.findAll();
        assertEquals(1, departmentList.size());
    }

}
