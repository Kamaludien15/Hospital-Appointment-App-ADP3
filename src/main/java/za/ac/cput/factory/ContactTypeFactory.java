package za.ac.cput.factory;

/*
 ContactTypeFactory.java
 entity for the ContactTypeFactory
 Author: Kamaludien Sonday (218168128)
 Date: 10 April 2022
 */

import za.ac.cput.domain.ContactType;
import za.ac.cput.util.Helper;

public class ContactTypeFactory {
    public static ContactType createContactType(String name, boolean urgent, String description){
        String contactTypeId = Helper.generateID();
        ContactType contactType = new ContactType.Builder().setContactTypeId(contactTypeId).setName(name).setUrgent(urgent).setDescription(description).build();
        return contactType;
    }
}