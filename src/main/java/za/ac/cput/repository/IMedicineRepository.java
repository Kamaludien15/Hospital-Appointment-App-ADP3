/*
 * IMedicineRepository.java
 * Repository interface for the Medicine
 * Author: Mogamad Githr Parker (220408025)
 * Date: 15 August 2022
 * */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Medicine;

@Repository
public interface IMedicineRepository extends JpaRepository<Medicine, String> {
    //Medicine findMedicineByMedicineName(String name);
}
