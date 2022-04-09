package za.ac.cput.Impl;

import za.ac.cput.domain.ContactType;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IContactTypeRepository extends IRepository <ContactType, String> {
    public Set<ContactType> getall();
}
