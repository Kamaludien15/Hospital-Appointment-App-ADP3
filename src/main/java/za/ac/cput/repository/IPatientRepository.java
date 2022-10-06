package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Patient;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, String> {
    //public Patient findPatientByPatientID(String id);
}
