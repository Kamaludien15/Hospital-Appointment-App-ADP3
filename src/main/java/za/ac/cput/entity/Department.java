package za.ac.cput.entity;

/*
 Employee.java
 entity for the Employee
 Author: Benelzane Kholani (218257465)
 Date: 10 April 2022
 */

public class Department {

    //instance variables
    private String departmentId;
    private String departmentName;
    private String departmentSize;
    private String departmentFloor;

    public String getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDepartmentSize() {
        return departmentSize;
    }

    public String getDepartmentFloor() {
        return departmentFloor;
    }

    private Department(){};

    public static class DepartmentBuilder
    {
        private String departmentId;
        private String departmentName;
        private String departmentSize;
        private String departmentFloorNumber;

        public DepartmentBuilder buildId(String departmentId)
        {
            this.departmentId = departmentId;
            return this;
        }//end of buildId method

        public DepartmentBuilder buildDepartmentName(String departmentName)
        {
            this.departmentName = departmentName;
            return this;
        }//end of buildDepartmentName method

        public DepartmentBuilder buildDepartmentSize(String departmentSize)
        {
            this.departmentSize = departmentSize;
            return this;
        }//end of buildDepartmentSize method


        public DepartmentBuilder buildDepartmentFloor(String floorSize)
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
