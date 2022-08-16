package za.ac.cput.service;


import za.ac.cput.domain.ContactType;

import java.util.List;

public interface IContactTypeService extends IService<ContactType, String> {

    public List<ContactType> getAll();
}
