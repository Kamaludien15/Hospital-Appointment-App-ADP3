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
import za.ac.cput.repository.IHospitalLocationRepository;
import za.ac.cput.repository.IHospitalRepository;
import za.ac.cput.repository.ILocationRepository;

import java.util.List;
import java.util.Optional;


@SpringBootTest
class IHospitalLocationRepositoryTest {

    @Autowired private IHospitalLocationRepository hospitalLocationRepository;
    @Autowired private ILocationRepository locationRepository;
    @Autowired private IHospitalRepository hospitalRepository;
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
        this.locationRepository.delete(this.location);
        this.hospitalRepository.delete(this.hospital);
    }

    @Test
    void save() {
        Hospital savedHospital = this.hospitalRepository.save(this.hospital);
        Location savedLocation = this.locationRepository.save(this.location);
        HospitalLocation saved = this.hospitalLocationRepository.save(this.hospitalLocation);

        System.out.println(saved);
        assertNotNull(saved);
        assertSame(this.hospitalLocation.getHospital().getHospitalID(), saved.getHospital().getHospitalID());
    }

    @Test
    void read() {
        Hospital savedHospital = this.hospitalRepository.save(this.hospital);
        Location savedLocation = this.locationRepository.save(this.location);
        HospitalLocation saved = this.hospitalLocationRepository.save(this.hospitalLocation);

        Optional<HospitalLocation> read = this.hospitalLocationRepository.findById(this.hospitalLocation.getHospitalLocationId());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved.getHospitalLocationId(), read.get().getHospitalLocationId())
        );
    }

    @Test
    void delete() {
        Hospital savedHospital = this.hospitalRepository.save(this.hospital);
        Location savedLocation = this.locationRepository.save(this.location);
        List<HospitalLocation> hospitalLocationListBefore = this.hospitalLocationRepository.findAll();
        int valueBefore = hospitalLocationListBefore.size();

        HospitalLocation saved = this.hospitalLocationRepository.save(this.hospitalLocation);

        this.hospitalLocationRepository.delete(saved);
        List<HospitalLocation> hospitalLocationList = this.hospitalLocationRepository.findAll();
        assertEquals(valueBefore,hospitalLocationList.size());
    }

    @Test
    void getAll() {
        Hospital savedHospital = this.hospitalRepository.save(this.hospital);
        Location savedLocation = this.locationRepository.save(this.location);
        this.hospitalLocationRepository.save(this.hospitalLocation);

        List<HospitalLocation> hospitalLocationList = this.hospitalLocationRepository.findAll();
        assertNotNull(hospitalLocationList.size());
    }
}