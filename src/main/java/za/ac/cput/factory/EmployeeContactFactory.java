package za.ac.cput.factory;

import za.ac.cput.domain.ContactType;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.EmployeeContact;
import za.ac.cput.util.Helper;

public class EmployeeContactFactory {

    public static EmployeeContact createEmployeeContact(ContactType contactType, Employee employee){
        String employeeContactId = Helper.generateID();

        EmployeeContact employeeContact = new EmployeeContact.Builder().setEmployeeContactId(employeeContactId).setContactType(contactType).setEmployee(employee).build();

        return employeeContact;
    }


}

