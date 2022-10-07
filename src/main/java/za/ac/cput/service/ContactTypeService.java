package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.ContactType;
import za.ac.cput.factory.ContactTypeFactory;
import za.ac.cput.repository.IContactTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContactTypeService implements IContactTypeService{

    private static IContactTypeRepository repository = null;

    @Autowired
    private ContactTypeService(IContactTypeRepository contactTypeRepository){
        this.repository = contactTypeRepository;
    }

    @Override
    public ContactType save(ContactType contactType) {
        return this.repository.save(contactType);
    }

    @Override
    public Optional<ContactType> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(ContactType contactType) {
        this.repository.delete(contactType);
    }

    @Override
    public List<ContactType> getAll() {
        return this.repository.findAll();
    }
}
