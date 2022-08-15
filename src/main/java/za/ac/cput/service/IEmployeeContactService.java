package za.ac.cput.service;

import za.ac.cput.domain.EmployeeContact;

import java.util.List;

public interface IEmployeeContactService extends IService<EmployeeContact, String> {
    public List<EmployeeContact> getAll();
}
