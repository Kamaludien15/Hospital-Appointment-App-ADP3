package za.ac.cput.service;


import za.ac.cput.domain.PatientContact;

import java.util.List;

public interface IPatientContactService extends IService<PatientContact, String> {
    public List<PatientContact> getAll();
}
