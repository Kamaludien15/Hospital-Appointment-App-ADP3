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
import java.util.List;
import java.util.Optional;


@SpringBootTest
class IHospitalLocationRepositoryTest {

    @Autowired private IHospitalLocationRepository hospitalLocationRepository;
    private Hospital hospital;
    private Location location;
    private HospitalLocation hospitalLocation;

    @BeforeEach
    void setUp() {
        this.hospital = HospitalFactory.createHospital("Spring View Hospital", 1000, "Private");
        this.location = LocationFactory.createLocation("Johnson", 90,"Plumstead",7800);
        this.hospitalLocation = HospitalLocationFactory.createHospitalLocation(hospital,location);
    }

    @AfterEach
    void tearDown(){
        this.hospitalLocationRepository.delete(this.hospitalLocation);
    }

    @Test
    void save() {
        HospitalLocation saved = this.hospitalLocationRepository.save(this.hospitalLocation);
        System.out.println(saved);
        assertNotNull(saved);
        assertSame(this.hospitalLocation, saved);
    }

    @Test
    void read() {
        HospitalLocation saved = this.hospitalLocationRepository.save(this.hospitalLocation);
        Optional<HospitalLocation> read = this.hospitalLocationRepository.findById(this.hospitalLocation.getHospitalLocationId());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved, read.get())
        );
    }

    @Test
    void delete() {
        HospitalLocation saved = this.hospitalLocationRepository.save(this.hospitalLocation);
        this.hospitalLocationRepository.delete(saved);
        List<HospitalLocation> hospitalLocationList = this.hospitalLocationRepository.findAll();
        assertEquals(0,hospitalLocationList.size());
    }

    @Test
    void getAll() {
        this.hospitalLocationRepository.save(this.hospitalLocation);
        List<HospitalLocation> hospitalLocationList = this.hospitalLocationRepository.findAll();
        assertEquals(1,hospitalLocationList.size());
    }
}