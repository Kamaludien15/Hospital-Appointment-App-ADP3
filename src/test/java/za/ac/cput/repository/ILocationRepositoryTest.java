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
import za.ac.cput.repository.ILocationRepository;

import java.util.List;
import java.util.Optional;


@SpringBootTest
class ILocationRepositoryTest {

    @Autowired private ILocationRepository locationRepository;
    private Location location;


    @BeforeEach
    void setUp() {
        this.location = LocationFactory.createLocation("Johnson",75,"Deip River",7600);
    }

    @AfterEach
    void tearDown(){
        this.locationRepository.delete(this.location);
    }

    @Test
    void save() {
        Location saved = this.locationRepository.save(this.location);
        System.out.println(saved);
        assertNotNull(saved);
        assertSame(this.location.getLocationID(), saved.getLocationID());
    }

    @Test
    void read() {
        Location saved = this.locationRepository.save(this.location);
        Optional<Location> read = this.locationRepository.findById(this.location.getLocationID());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved.getLocationID(), read.get().getLocationID())
        );
    }

    @Test
    void delete() {
        Location saved = this.locationRepository.save(this.location);
        this.locationRepository.delete(saved);
        List<Location> hospitalLocationList = this.locationRepository.findAll();
        assertEquals(0,hospitalLocationList.size());
    }

    @Test
    void getAll() {
        this.locationRepository.save(this.location);
        List<Location> hospitalList = this.locationRepository.findAll();
        assertEquals(1,hospitalList.size());
    }
}