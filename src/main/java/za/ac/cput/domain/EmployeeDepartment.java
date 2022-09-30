package za.ac.cput.domain;

/*
 Employee.java
 entity for the Employee
 Author: Benelzane Kholani (218257465)
 Date: 10 April 2022
 */

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class EmployeeDepartment implements Serializable {

    @Id
    @Column(name="employeeDepartmentId")
    private String employeeDepartmentId;

    @ManyToOne
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
    private Employee employee;

    @OneToMany
    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId")
    private Department department;

    private EmployeeDepartment(){}

    public String getEmployeeDepartmentId() {
        return employeeDepartmentId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Department getDepartment() {
        return department;
    }

    public static class EmployeeDepartmentBuilder{

        private String employeeDepartmentId;
        private Employee employee;
        private Department department;



        public EmployeeDepartmentBuilder setEmployeeDepartmentId(String employeeDepartmentId) {
            this.employeeDepartmentId = employeeDepartmentId;
            return this;
        }

        public EmployeeDepartmentBuilder setEmployee(Employee employee) {
            this.employee = employee;
            return this;
        }

        public EmployeeDepartmentBuilder setDepartment(Department department) {
            this.department = department;
            return this;
        }

        public EmployeeDepartment build(){
            EmployeeDepartment employeeDepartment = new EmployeeDepartment();
            employeeDepartment.employeeDepartmentId = this.employeeDepartmentId;
            employeeDepartment.employee   = this.employee;
            employeeDepartment.department = this.department;
            return employeeDepartment;
        }

    }//end of builder class

    @Override
    public String toString() {
        return "EmployeeDepartment{" +
                "employeeDepartmentId='" + employeeDepartmentId + '\'' +
                ", employee=" + employee +
                ", department=" + department +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDepartment that = (EmployeeDepartment) o;
        return Objects.equals(employeeDepartmentId, that.employeeDepartmentId) && Objects.equals(employee, that.employee) && Objects.equals(department, that.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeDepartmentId, employee, department);
    }
}
