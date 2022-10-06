package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.PatientGender;

@Repository
public interface IPatientGenderRepository extends JpaRepository<PatientGender, String> {
    //public PatientGender findPatientGenderByPatientGenderID(String id);
}
