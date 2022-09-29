/* AddressAPITest.java
 Controller for address entity
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class HospitalLocationAPITest {

    @Autowired private HospitalLocationAPI api;
    private Hospital hospital;
    private Location location;
    private HospitalLocation hospitalLocation;

    @BeforeEach
    void setUp() {
        this.location = LocationFactory.createLocation("Johnson",75,"Deip River",7600);
        this.hospital = HospitalFactory.createHospital("Spring View Hospital", 1000, "Private");
        this.hospitalLocation = HospitalLocationFactory.createHospitalLocation(hospital,location);
    }

    @Test
    void save() {
        HospitalLocation saved = this.api.save(this.hospitalLocation);
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
        Optional<HospitalLocation> saved = this.api.read(this.hospitalLocation.getHospitalLocationId());
        assertEquals(1, this.api.getAll().size());
    }
}