package za.ac.cput.domain;

public class EmployeeContact {
    private String contactTypeID;
    private String employeeID;

    public EmployeeContact(String contactTypeID, String employeeID) {
        this.contactTypeID = contactTypeID;
        this.employeeID = employeeID;
    }

    public String getContactTypeID() {
        return contactTypeID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    @Override
    public String toString() {
        return "EmployeeContact{" +
                "contactTypeID='" + contactTypeID + '\'' +
                ", employeeID='" + employeeID + '\'' +
                '}';
    }

    public void contact(){
        System.out.println("Employee contact created!");
    }
}
