/* AddressServicesImplTest.java
 Test class for AddressServices
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.service.HospitalLocationService;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HospitalLocationServiceTest {

    private Hospital hospital;
    private Location location;
    private HospitalLocation hospitalLocation;

    @Autowired private HospitalLocationService service;

    @BeforeEach
    void setUp() {
        this.hospital = HospitalFactory.createHospital("Spring View Hospital", 1000, "Private");
        this.location = LocationFactory.createLocation("Johnson", 90,"Plumstead",7800);
        this.hospitalLocation = HospitalLocationFactory.createHospitalLocation(hospital,location);
    }

    @AfterEach
    void tearDown() {
        this.service.delete(hospitalLocation);
    }

    @Test
    void save() {
        HospitalLocation saved = this.service.save(this.hospitalLocation);
        System.out.println(saved);
        assertNotNull(saved);
        assertSame(this.hospitalLocation, saved);
    }

    @Test
    void read() {
        HospitalLocation saved = this.service.save(this.hospitalLocation);
        Optional<HospitalLocation> read = this.service.read(hospitalLocation.getHospitalLocationId());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved, read.get())
        );
    }

    @Test
    void delete() {
        HospitalLocation saved = this.service.save(this.hospitalLocation);
        this.service.delete(saved);
        List<HospitalLocation> addressSet = this.service.getAll();
        assertEquals(0,addressSet.size());
    }

    @Test
    void getAll() {
        this.service.save(this.hospitalLocation);
        List<HospitalLocation> addressSet = this.service.getAll();
        assertEquals(1,addressSet.size());
    }
}