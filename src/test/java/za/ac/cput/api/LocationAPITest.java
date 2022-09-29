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
class LocationAPITest {

    @Autowired private LocationAPI api;
    private Location location;

    @BeforeEach
    void setUp() {
        this.location = LocationFactory.createLocation("Johnson",75,"Deip River",7600);
    }

    @Test
    void save() {
        Location saved = this.api.save(this.location);
    }

    @Test
    void read() {
        Optional<Location> saved = this.api.read(this.location.getLocationID());
        assertNotNull(saved);
    }

    @Test
    void delete() {
        this.api.delete(this.location);
        assertEquals(0, this.api.getAll().size());
    }

    @Test
    void getAll() {
        Optional<Location> saved = this.api.read(this.location.getLocationID());
        assertEquals(1, this.api.getAll().size());
    }
}