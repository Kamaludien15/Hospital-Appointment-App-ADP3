package za.ac.cput.repository;
/*
 IContactTypeRepository.java
 entity for the IContactTypeRepository
 Author: Kamaludien Sonday (218168128)
 Date: 10 April 2022
 */

import za.ac.cput.entity.ContactType;

import java.util.Set;

public interface IContactTypeRepository extends IRepository <ContactType, String> {
    public Set<ContactType> getall();
}
