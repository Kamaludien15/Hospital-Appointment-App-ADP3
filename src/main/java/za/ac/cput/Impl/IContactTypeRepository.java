package za.ac.cput.Impl;
/*
 IContactTypeRepository.java
 entity for the IContactTypeRepository
 Author: Kamaludien Sonday (218168128)
 Date: 10 April 2022
 */
import za.ac.cput.domain.ContactType;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IContactTypeRepository extends IRepository <ContactType, String> {
    public Set<ContactType> getall();
}
