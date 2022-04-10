package za.ac.cput.Impl;
/*
ContactTypeRepository.java
 entity for the ContactTypeRepository
 Author: Kamaludien Sonday (218168128)
 Date: 10 April 2022
 */
import za.ac.cput.entity.ContactType;

import java.util.HashSet;
import java.util.Set;

public class ContactTypeRepository implements IContactTypeRepository{
    private static ContactTypeRepository repository = null;
    private Set<ContactType> contactTypeDB = null;

    private ContactTypeRepository(){
        contactTypeDB = new HashSet<ContactType>();
    }

    private static ContactTypeRepository getRepository(){
        if (repository==null){
            repository = new ContactTypeRepository();
        }
        return repository;
    }

    @Override
    public Set<ContactType> getall() {
        return contactTypeDB;
    }

    @Override
    public ContactType create(ContactType contactType) {
        boolean success = contactTypeDB.add(contactType);
        if (!success){
            return null;
        }
        return contactType;
    }

    @Override
    public ContactType read(String contactTypeID) {
        ContactType contactType = contactTypeDB.stream().filter(e-> e.getContactTypeId().equals(contactTypeID)).findAny().orElse(null);
        return contactType;
    }

    @Override
    public ContactType update(ContactType contactType) {
        ContactType oldContactType = read(contactType.getContactTypeId());
        if (oldContactType != null){
            contactTypeDB.remove(oldContactType);
            contactTypeDB.add(contactType);
            return contactType;
        }
        return null;
    }

    @Override
    public boolean delete(String contactTypeId) {
        ContactType contactTypeToDelete = read(contactTypeId);
        if (contactTypeId == null){
            return false;
        }
        contactTypeDB.remove(contactTypeToDelete);
        return true;
    }
}
