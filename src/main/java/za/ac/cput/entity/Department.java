package za.ac.cput.entity;

/*
 Employee.java
 Entity for the Employee
 Author: Benelzane Kholani (218257465)
 Date: 10 April 2022
 */

public class Department {

    //instance variables
    private int departmentId;
    private String departmentName;
    private int departmentSize;
    private int departmentFloor;

    private Department(){};

    public static class DepartmentBuilder
    {
        private int departmentId;
        private String departmentName;
        private int departmentSize;
        private int departmentFloorNumber;

        public DepartmentBuilder buildId(int departmentId)
        {
            this.departmentId = departmentId;
            return this;
        }//end of buildId method

        public DepartmentBuilder buildDepartmentName(String departmentName)
        {
            this.departmentName = departmentName;
            return this;
        }//end of buildDepartmentName method

        public DepartmentBuilder buildDepartmentSize(int departmentSize)
        {
            this.departmentSize = departmentSize;
            return this;
        }//end of buildDepartmentSize method


        public DepartmentBuilder buildDepartmentFloor(int floorSize)
        {
            this.departmentFloorNumber = floorSize;
            return this;
        }//emd of buildDepartmentFloor method

        public Department getDepartment()
        {
            Department department      = new Department();
            department.departmentId    = this.departmentId;
            department.departmentName  = this.departmentName;
            department.departmentSize  = this.departmentSize;
            department.departmentFloor = this.departmentFloorNumber;

            return department;
        }//end  of getDepartment method


    }//end of DepartmentBuilder

}
