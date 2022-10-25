/* AddressAPITest.java
 Controller for address entity
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.api;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class LocationAPITest {

    @Autowired private LocationAPI api;
    private Location location;

    @BeforeEach
    void setUp() {
        this.location = LocationFactory.createLocation("Johnson",75,"Deip River",7600);
    }

    @AfterEach
    void tearDown(){
        this.api.delete(this.location);
    }

    @Test
    void a_save() {
        Location saved = this.api.save(this.location);
        assertNotNull(saved);
        assertSame(this.location.getLocationID(), saved.getLocationID());
    }

    @Test
    void b_read() {
        Optional<Location> saved = this.api.read(this.location.getLocationID());
        assertNotNull(saved);
    }

    @Test
    void c_delete() {
        this.api.save(this.location);
        int before = this.api.getAll().size();
        this.api.delete(this.location);
        before = before - 1;
        assertEquals(before, this.api.getAll().size());
    }

    @Test
    void d_getAll() {
        Location saved = this.api.save(this.location);
        assertNotNull( this.api.getAll().size());
    }
}