package za.ac.cput.factory;

import za.ac.cput.domain.ContactType;
import za.ac.cput.util.Helper;

public class ContactTypeFactory {
    public static ContactType createContactType(String name, boolean urgent, String description){
        String contactTypeId = Helper.generateId();
        ContactType contactType = new ContactType.Builder().setContactTypeId(contactTypeId).setName(name).setUrgent(urgent).setDescription(description).build();
        return contactType;
    }
}