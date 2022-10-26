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
import za.ac.cput.domain.Employee;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {

    private Employee employee;
    private Employee employee2;

    @BeforeEach
    public void setUp() {
       employee  = EmployeeFactory.createEmployee("Peter", "Bale", "02-03-88", "123456789", "gg");
       employee2 = EmployeeFactory.createEmployee("Kate", "Derek", "02-03-88", "123456789", "gg");
    }

    @Test
    public void testEquality(){

        //test if the instance variables are as expected
        assertAll("EmployeeFactory",
                ()->assertEquals("Peter", employee.getEmployeeFirstName()),
                ()->assertEquals("Bale", employee.getEmployeeLastName()),
                ()->assertEquals("02-03-88", employee.getEmployeeDateOfBirth()));
    }//end of testEquality method

    @Test
    public void testIdentity(){
        assertNotSame(employee,employee2);//pass test, objects are the same
    }//end of testIdentity method

    @Test
    public void testNull(){
        assertNotNull(employee, "Object is not null");//object is not null
    }

}