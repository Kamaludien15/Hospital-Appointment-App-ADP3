package za.ac.cput.service;

import za.ac.cput.domain.PatientGender;
import java.util.List;

public interface IPatientGenderService extends IService<PatientGender, String>{
    public List<PatientGender> getAll();
}
