package za.ac.cput.factory;

/*
 Employee.java
 entity for the Employee
 Author: Benelzane Kholani (218257465)
 Date: 10 April 2022
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {

    private Employee employee;
    private Employee employee2;

    @BeforeEach
    public void setUp() {

       employee  = EmployeeFactory.getEmployee("2", "Peter", "Bale", "02-03-88");
       employee2 = EmployeeFactory.getEmployee("4", "Kate", "Derek", "02-03-88");
    }

    @Test
    public void testEquality(){

        //test if the instance variables are as expected
        assertAll("EmployeeFactory",
                ()->assertEquals(2, employee.getEmployeeId()),
                ()->assertEquals("Cole", employee.getEmployeeFirstName()),
                ()->assertEquals("Wayne", employee.getEmployeeLastName()),
                ()->assertEquals("03-03-78", employee.getEmployeeDateOfBirth()));
    }//end of testEquality method

    @Test
    public void testIdentity(){
        assertSame(employee,employee2);//failed test, objects are not the same
    }//end of testIdentity method

    @Test
    public void testNull(){
        assertNotNull(employee, "Object is not null");//object is not null
    }

}