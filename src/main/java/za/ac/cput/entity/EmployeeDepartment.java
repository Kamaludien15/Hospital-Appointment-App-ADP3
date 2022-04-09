package za.ac.cput.entity;

/*
 Employee.java
 Entity for the Employee
 Author: Benelzane Kholani (218257465)
 Date: 10 April 2022
 */

public class EmployeeDepartment {

    //instance variables
    private int departmentId;
    private int employeeId;

    private EmployeeDepartment(){};

    public static class EmployeeDepartmentBuilder
    {
        //instance variables
        private int departmentId;
        private int employeeId;

        public EmployeeDepartmentBuilder buildId(int id)
        {
            this.departmentId = id;
            return this;
        }//end of buildId method

        public EmployeeDepartmentBuilder buildEmployeeId(int id)
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
