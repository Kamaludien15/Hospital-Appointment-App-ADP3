package za.ac.cput.domain;

/*
 Employee.java
 entity for the Employee
 Author: Benelzane Kholani (218257465)
 Date: 10 April 2022
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Employee {

    //instance variables
    @Id
    @Column(name="employee_id")
    private String employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeDateOfBirth;

    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public String getEmployeeDateOfBirth() {
        return employeeDateOfBirth;
    }

    protected Employee()
    {
    }//end of private constructor

    public static class EmployeeBuilder
    {
        //instance variables
        private String employeeId;
        private String firstName;
        private String lastName;
        private String dateOfBirth;

        public String getEmployeeId() {
            return employeeId;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public EmployeeBuilder buildId(String employeeId)
        {
            this.employeeId = employeeId;
            return this;
        }//end of buildId method

        public EmployeeBuilder buildName(String firstName)
        {
            this.firstName = firstName;
            return this;
        }//end of buildName method

        public EmployeeBuilder buildLastName(String lastName)
        {
            this.lastName = lastName;
            return this;
        }//end of buildLastName method

        public EmployeeBuilder buildDateOfBirth(String dateOfBirth)
        {
            this.dateOfBirth = dateOfBirth;
            return this;
        }//end of buildDateOfBirth method

        public Employee getEmployee()
        {
            Employee employee            = new Employee();
            employee.employeeId          = this.employeeId;
            employee.employeeFirstName   = this.firstName;
            employee.employeeLastName    = this.lastName;
            employee.employeeDateOfBirth = this.dateOfBirth;
            return employee;
        }//end of getEmployee method

    }//end of EmployeeBuilder class

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeFirstName='" + employeeFirstName + '\'' +
                ", employeeLastName='" + employeeLastName + '\'' +
                ", employeeDateOfBirth='" + employeeDateOfBirth + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId) && Objects.equals(employeeFirstName, employee.employeeFirstName) && Objects.equals(employeeLastName, employee.employeeLastName) && Objects.equals(employeeDateOfBirth, employee.employeeDateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, employeeFirstName, employeeLastName, employeeDateOfBirth);
    }
}//end of Employee class
