package za.ac.cput.factory;

/*
 Employee.java
 entity for the Employee
 Author: Benelzane Kholani (218257465)
 Date: 10 April 2022
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.EmployeeDepartment;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDepartmentFactoryTest {

    private EmployeeDepartment employeeDepartment1;
    private EmployeeDepartment employeeDepartment2;

    @BeforeEach
    public void setUp() {

        employeeDepartment1  = EmployeeDepartmentFactory.getEmployeeDepartment("2","4");
        employeeDepartment2  = EmployeeDepartmentFactory.getEmployeeDepartment("3","5");
    }

    @Test
    public void testEquality(){

        //test if the instance variables are as expected
        assertAll("EmployeeFactory",
                ()->assertEquals("2", employeeDepartment1.getDepartmentId()),
                ()->assertEquals("4", employeeDepartment1.getEmployeeId()));
    }//end of testEquality method

    @Test
    public void testIdentity(){
        assertSame(employeeDepartment1,employeeDepartment2);//failed test, objects are not the same
    }//end of testIdentity method

    @Test
    public void testNull(){
        assertNotNull(employeeDepartment1, "Object is not null");//object is not null
    }


}