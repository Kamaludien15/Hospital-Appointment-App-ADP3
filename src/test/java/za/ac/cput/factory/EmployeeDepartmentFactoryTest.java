package za.ac.cput.factory;

/*
 Employee.java
 entity for the Employee
 Author: Benelzane Kholani (218257465)
 Date: 10 April 2022
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Department;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.EmployeeDepartment;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDepartmentFactoryTest {

    private EmployeeDepartment employeeDepartment1;
    private EmployeeDepartment employeeDepartment2;

    private  Employee employee;
    private  Department department;

    private  Employee employee1;
    private  Department department1;

    @BeforeEach
    public void setUp() {
        employee = EmployeeFactory.createEmployee("Kholani", "Benelzane", "20 March");
        department = DepartmentFactory.createDepartment("Surgeon", "45", "9");

        employee1 = EmployeeFactory.createEmployee("Ernest", "Benzema", "22 April");
        department1 = DepartmentFactory.createDepartment("Bio Engineer", "77", "13");

        employeeDepartment1  = EmployeeDepartmentFactory.createEmployeeDepartment(employee,department);
        employeeDepartment2  = EmployeeDepartmentFactory.createEmployeeDepartment(employee1,department1);
    }

    @Test
    public void testEquality(){

        //test if the instance variables are as expected
        assertAll("EmployeeFactory",
                ()->assertEquals("Kholani", employeeDepartment1.getEmployee().getEmployeeFirstName()),
                ()->assertEquals("Surgeon", employeeDepartment1.getDepartment().getDepartmentName()));
    }//end of testEquality method

    @Test
    @Disabled
    public void testIdentity(){
        assertSame(employeeDepartment1,employeeDepartment2);//failed test, objects are not the same
    }//end of testIdentity method

    @Test
    public void testNull(){
        assertNotNull(employeeDepartment1, "Object is not null");//object is not null
    }


}