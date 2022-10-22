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
class GenderControllerTest {
    @LocalServerPort
    private int port;
    private String SECURITY_USERNAME = "admin";
    private String SECURITY_PASSWORD = "passwordAdmin";

    @Autowired
    private TestRestTemplate restTemplate;

    private static Gender gender =  GenderFactory.createGender("Rhegan", "Born a male on the 19th of August in the year 2000", "Male");

    private static String baseUrl;

    @BeforeEach
    void setUp() {
        String urlGender = "http://localhost:"+ this.port + "/hospital_appointment_management-db/gender/save";
        ResponseEntity<Gender> responseGender = this.restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(urlGender, this.gender, Gender.class);

        this.baseUrl = "http://localhost:"+ this.port + "/hospital_appointment_management-db/gender/";
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void a_save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Gender> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, this.gender, Gender.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    void b_read() {
        String url = baseUrl+"read/" + this.gender.getGenderID();
        System.out.println(url);
        ResponseEntity<Gender> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Gender.class);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    void c_getAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Gender[]> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Gender[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertTrue(response.getBody().length == 1)
        );
    }

    @Test
    void d_delete() {
        String url = baseUrl + "delete/" + this.gender.getGenderID();
        this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .delete(url);
    }
}