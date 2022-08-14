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
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LocationServiceTest {

    private Location location;

    @Autowired private LocationService service;

    @BeforeEach
    void setUp() {
        this.location = LocationFactory.createLocation("Johnson",75,"Deip River",7600);
    }

    @AfterEach
    void tearDown() {
        this.service.delete(location);
    }

    @Test
    void save() {
        Location saved = this.service.save(this.location);
        System.out.println(saved);
        assertNotNull(saved);
        assertSame(this.location, saved);
    }

    @Test
    void read() {
        Location saved = this.service.save(this.location);
        Optional<Location> read = this.service.read(location.getLocationID());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved, read.get())
        );
    }

    @Test
    void delete() {
        Location saved = this.service.save(this.location);
        this.service.delete(saved);
        List<Location> addressSet = this.service.getAll();
        assertEquals(0,addressSet.size());
    }

    @Test
    void getAll() {
        this.service.save(this.location);
        List<Location> addressSet = this.service.getAll();
        assertEquals(1,addressSet.size());
    }
}