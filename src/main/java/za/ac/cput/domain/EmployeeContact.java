package za.ac.cput.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class EmployeeContact implements Serializable {

    @Id
    @Column(name = "employeeContact_id")
    private String employeeContactId;

    @OneToOne
    @JoinColumn(name = "contact_type_id", referencedColumnName = "contact_type_id")
    private ContactType contactType;

    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    public EmployeeContact(EmployeeContact.Builder builder) {
        this.employeeContactId = builder.employeeContactId;
        this.contactType = builder.contactType;
        this.employee = builder.employee;
    }

    protected EmployeeContact() {}


    public String getEmployeeContactId() {
        return employeeContactId;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public static class Builder{

        private String employeeContactId;
        private ContactType contactType;
        private Employee employee;

        public EmployeeContact.Builder setEmployeeContactId(String employeeContactId){
            this.employeeContactId = employeeContactId;
            return this;
        }

        public EmployeeContact.Builder setContactType(ContactType contactType){
            this.contactType = contactType;
            return this;
        }

        public EmployeeContact.Builder setEmployee(Employee employee){
            this.employee = employee;
            return this;
        }

        public EmployeeContact.Builder copy(EmployeeContact EmployeeContact){
            this.employeeContactId = EmployeeContact.employeeContactId;
            this.contactType = EmployeeContact.contactType;
            this.employee = EmployeeContact.employee;
            return this;
        }

        public EmployeeContact build(){ return new EmployeeContact(this); }

    }

    @Override
    public String toString() {
        return "EmployeeContact{" +
                "employeeContactId='" + employeeContactId + '\'' +
                ", contactType=" + contactType +
                ", employee=" + employee +
                '}';
    }

    public void contact(){
        System.out.println("Employee contact created!");
    }
}
