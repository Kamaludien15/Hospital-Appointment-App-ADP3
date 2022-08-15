package za.ac.cput.api;

import org.springframework.stereotype.Component;
import za.ac.cput.domain.ContactType;
import za.ac.cput.service.IContactTypeService;

import java.util.List;
import java.util.Optional;

@Component
public class ContactTypeAPI {

    private final IContactTypeService contactTypeService;

    public ContactTypeAPI(IContactTypeService contactTypeService){
        this.contactTypeService = contactTypeService;
    }

    public ContactType save(ContactType contactType){
        return this.contactTypeService.save(contactType);
    }

    public Optional<ContactType> read(String id){
        return this.contactTypeService.read(id);
    }

    public void delete(ContactType contactType){
        this.contactTypeService.delete(contactType);
    }

    public List<ContactType> getAll(){
        return this.contactTypeService.getAll();
    }
}
