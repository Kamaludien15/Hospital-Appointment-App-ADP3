package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.EmployeeContact;
import za.ac.cput.service.IContactTypeService;
import za.ac.cput.service.IEmployeeContactService;
import za.ac.cput.service.IEmployeeService;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeContactAPI {
    private final IEmployeeContactService employeeContactService;
    private final IContactTypeService contactTypeService;
    private final IEmployeeService employeeService;

    @Autowired
    public EmployeeContactAPI(IEmployeeContactService employeeContactService, IContactTypeService contactTypeService, IEmployeeService employeeService){
        this.employeeContactService = employeeContactService;
        this.contactTypeService = contactTypeService;
        this.employeeService = employeeService;
    }

    public EmployeeContact save(EmployeeContact employeeContact){
        this.contactTypeService.read(employeeContact.getContactType().getContactTypeId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found"));
        this.employeeService.read(employeeContact.getEmployee().getEmployeeId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found"));
        return this.employeeContactService.save(employeeContact);
    }

    public Optional<EmployeeContact> read(String id){
        return this.employeeContactService.read(id);
    }

    public void delete(EmployeeContact employeeContact){
        this.employeeContactService.delete(employeeContact);
    }

    public List<EmployeeContact> getAll(){
        return this.employeeContactService.getAll();
    }
}
