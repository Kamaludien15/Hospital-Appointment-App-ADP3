package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.EmployeeContact;
import za.ac.cput.factory.EmployeeContactFactory;
import za.ac.cput.repository.IEmployeeContactRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeContactService implements IEmployeeContactService{

    private static IEmployeeContactRepository repository = null;

    @Autowired
    private EmployeeContactService(IEmployeeContactRepository employeeContactRepository){
        this.repository = employeeContactRepository;
    }

    @Override
    public EmployeeContact save(EmployeeContact employeeContact) {
        EmployeeContact obj = EmployeeContactFactory.createEmployeeContact(employeeContact.getContactType(), employeeContact.getEmployee());
        return this.repository.save(obj);
    }

    @Override
    public Optional<EmployeeContact> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(EmployeeContact employeeContact) {
        this.repository.delete(employeeContact);
    }

    @Override
    public List<EmployeeContact> getAll() {
        return this.repository.findAll();
    }
}
