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
import za.ac.cput.service.IHospitalService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class HospitalAPITest {

    @Autowired private HospitalAPI api;
    private Hospital hospital;


    @BeforeEach
    void setUp() {
        this.hospital = HospitalFactory.createHospital("Spring View Hospital", 1000, "Private");
    }

    @AfterEach
    void tearDown(){
        this.api.delete(this.hospital);
    }

    @Test
    void a_save() {
        Hospital saved = this.api.save(this.hospital);
        assertNotNull(saved);
        assertSame(this.hospital.getHospitalID(), saved.getHospitalID());
    }

    @Test
    void b_read() {
        Optional<Hospital> saved = this.api.read(this.hospital.getHospitalID());
        assertNotNull(saved);
    }

    @Test
    void c_delete() {
        this.api.save(this.hospital);
        int before = this.api.getAll().size();
        this.api.delete(this.hospital);
        before = before - 1;
        assertEquals(before, this.api.getAll().size());
    }

    @Test
    void d_getAll() {
        Hospital saved = this.api.save(this.hospital);
        assertNotNull( this.api.getAll().size());
    }
}