/**
 * Rhegan Albert Fortuin
 * 219273693
 * IPatientRepository
 * 15 August 2022
 */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Patient;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, String> {
    public Patient findByPatientID(String id);
}
