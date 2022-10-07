/* AddressAPITest.java
 Controller for address entity
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HospitalLocationAPITest {

    @Autowired private HospitalLocationAPI api;
    @Autowired private HospitalAPI hospitalAPI;
    @Autowired private LocationAPI locationAPI;
    private Hospital hospital;
    private Location location;
    private HospitalLocation hospitalLocation;

    @BeforeEach
    void setUp() {
        this.location = LocationFactory.createLocation("Johnson",75,"Deip River",7600);
        this.hospital = HospitalFactory.createHospital("Spring View Hospital", 1000, "Private");
        this.hospitalLocation = HospitalLocationFactory.createHospitalLocation(hospital,location);
    }

    @AfterEach
    void tearDown(){
        this.api.delete(this.hospitalLocation);
        this.hospitalAPI.delete(this.hospital);
        this.locationAPI.delete(this.location);
    }

    @Test
    void save() {
        Hospital hospital = this.hospitalAPI.save(this.hospital);
        Location location = this.locationAPI.save(this.location);
        HospitalLocation saved = this.api.save(this.hospitalLocation);
        assertNotNull(saved);
        assertSame(this.hospitalLocation.getHospitalLocationId(), saved.getHospitalLocationId());
    }

    @Test
    void read() {
        Optional<HospitalLocation> saved = this.api.read(this.hospitalLocation.getHospitalLocationId());
        assertNotNull(saved);
    }

    @Test
    void delete() {
        this.api.delete(this.hospitalLocation);
        assertEquals(0, this.api.getAll().size());
    }

    @Test
    void getAll() {
        Hospital hospital = this.hospitalAPI.save(this.hospital);
        Location location = this.locationAPI.save(this.location);
        HospitalLocation saved = this.api.save(this.hospitalLocation);
        assertEquals(1, this.api.getAll().size());
    }
}