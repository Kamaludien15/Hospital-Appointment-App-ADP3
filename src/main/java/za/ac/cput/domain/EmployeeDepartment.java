package za.ac.cput.domain;

/*
 Employee.java
 entity for the Employee
 Author: Benelzane Kholani (218257465)
 Date: 10 April 2022
 */

public class EmployeeDepartment {

    //instance variables
    private String departmentId;
    private String employeeId;

    public String getDepartmentId() {
        return departmentId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    private EmployeeDepartment(){};

    public static class EmployeeDepartmentBuilder
    {
        //instance variables
        private String departmentId;
        private String employeeId;

        public EmployeeDepartmentBuilder buildId(String id)
        {
            this.departmentId = id;
            return this;
        }//end of buildId method

        public EmployeeDepartmentBuilder buildEmployeeId(String id)
        {
            this.employeeId = id;
            return this;
        }//end of buildEmployeeId method

        public EmployeeDepartment getEmployeeDepartment()
        {
            EmployeeDepartment employeeDepartment = new EmployeeDepartment();
            employeeDepartment.departmentId       = this.departmentId;
            employeeDepartment.employeeId         = this.employeeId;

            return employeeDepartment;
        }//end of getEmployeeDepartment method

    }//end of EmployeeDepartmentBuilder class

}
