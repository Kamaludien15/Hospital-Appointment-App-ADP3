/* AddressControllerTest.java
 Test class for AddressController
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class HospitalLocationControllerTest {

    @LocalServerPort
    private int port;
    private String SECURITY_USERNAME = "admin";
    private String SECURITY_PASSWORD = "passwordAdmin";

    @Autowired private TestRestTemplate restTemplate;

    private static Hospital hospital = HospitalFactory.createHospital("Spring View Hospital", 1000, "Private");
    private static Location location = LocationFactory.createLocation("Johnson",75,"Deip River",7600);
    private static HospitalLocation hospitalLocation = HospitalLocationFactory.createHospitalLocation(hospital, location);
    private String baseUrl;



    @BeforeEach
    void setUp() {
        String urlHospital = "http://localhost:"+ this.port + "/hospital_appointment_management-db/hospital/save";
        ResponseEntity<Hospital> responseHospital = this.restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(urlHospital, this.hospital, Hospital.class);
        String urlLocation = "http://localhost:"+ this.port + "/hospital_appointment_management-db/location/save";
        ResponseEntity<Location> responseLocation = this.restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(urlLocation, this.location, Location.class);
        this.baseUrl = "http://localhost:"+ this.port + "/hospital_appointment_management-db/hospitalLocation/";
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void a_save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<HospitalLocation> response = this.restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(url, this.hospitalLocation, HospitalLocation.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    void b_read() {
        String url = baseUrl+"read/" + this.hospitalLocation.getHospitalLocationId();
        System.out.println(url);
        ResponseEntity<HospitalLocation> response = this.restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).getForEntity(url, HospitalLocation.class);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    void c_getAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<HospitalLocation[]> response = this.restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).getForEntity(url, HospitalLocation[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertTrue(response.getBody().length == 1)
        );
    }

    @Test
    void d_delete() {
        String url = baseUrl + "delete/" + this.hospitalLocation.getHospitalLocationId();
        this.restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).delete(url);
    }


}