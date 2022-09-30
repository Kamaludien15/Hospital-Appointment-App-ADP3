/*
 * IProcedureRepository.java
 * Repository interface for the Procedure
 * Author: Mogamad Githr Parker (220408025)
 * Date: 15 August 2022
 * */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Procedure;

@Repository
public interface IProcedureRepository extends JpaRepository<Procedure, String> {
    //Procedure findByProcedureID(String id);
}
