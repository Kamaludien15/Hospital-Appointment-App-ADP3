package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Gender;

@Repository
public interface IGenderRepository extends JpaRepository<Gender, String> {
    //public Gender findByGenderID(String id);
}
