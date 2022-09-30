/*
 * IPrescriptionRepository.java
 * Repository interface for the Prescription
 * Author: Mogamad Githr Parker (220408025)
 * Date: 15 August 2022
 * */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Prescription;

@Repository
public interface IPrescriptionRepository extends JpaRepository<Prescription, String> {
    //Prescription findByScriptRef(String id);
}
