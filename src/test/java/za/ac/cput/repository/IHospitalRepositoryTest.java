/* AppointmentFactoryTest.java
 Testing class for AppointmentFactoryTest
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/
package za.ac.cput.repository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.repository.IHospitalRepository;

import java.util.List;
import java.util.Optional;


@SpringBootTest
class IHospitalRepositoryTest {

    @Autowired private IHospitalRepository hospitalLRepository;
    private Hospital hospital;


    @BeforeEach
    void setUp() {
        this.hospital = HospitalFactory.createHospital("Spring View Hospital", 1000, "Private");
    }

    @AfterEach
    void tearDown(){
        this.hospitalLRepository.delete(this.hospital);
    }

    @Test
    void save() {
        Hospital saved = this.hospitalLRepository.save(this.hospital);
        System.out.println(saved);
        assertNotNull(saved);
        assertSame(this.hospital.getHospitalID(), saved.getHospitalID());
    }

    @Test
    void read() {
        Hospital saved = this.hospitalLRepository.save(this.hospital);
        Optional<Hospital> read = this.hospitalLRepository.findById(this.hospital.getHospitalID());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved.getHospitalID(), read.get().getHospitalID())
        );
    }

    @Test
    void delete() {
        List<Hospital> hospitalLocationListBefore = this.hospitalLRepository.findAll();
        int valueBefore = hospitalLocationListBefore.size();

        Hospital saved = this.hospitalLRepository.save(this.hospital);
        this.hospitalLRepository.delete(saved);
        List<Hospital> hospitalLocationList = this.hospitalLRepository.findAll();
        assertEquals(valueBefore,hospitalLocationList.size());
    }

    @Test
    void getAll() {
        this.hospitalLRepository.save(this.hospital);
        List<Hospital> hospitalList = this.hospitalLRepository.findAll();
        assertNotNull(hospitalList.size());
    }
}