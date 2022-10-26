package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.ContactType;
import za.ac.cput.domain.Location;
import za.ac.cput.factory.ContactTypeFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class ContactTypeControllerTest {

    @LocalServerPort
    private int port;

    private String SECURITY_USERNAME = "admin";
    private String SECURITY_PASSWORD = "passwordAdmin";

    @Autowired private TestRestTemplate restTemplate;

    private static ContactType contactType = ContactTypeFactory.createContactType("Mark", true, "I am the doctor");

    private String baseUrl;

    @BeforeEach
    void setUp() {this.baseUrl = "http://localhost:"+ this.port + "/hospital_appointment_management-db/contactType/";}

    @AfterEach
    void tearDown() {

    }

    @Test
    void a_save()
    {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<ContactType> response = this.restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(url, this.contactType, ContactType.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    void b_read()
    {
        String url = baseUrl + "read/" + this.contactType.getContactTypeId();
        System.out.println(url);
        ResponseEntity<ContactType> response = this.restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).getForEntity(url, ContactType.class);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    void c_getAll()
    {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<ContactType[]> response = this.restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).getForEntity(url, ContactType[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertTrue(response.getBody().length == 1)
        );
    }

    @Test
    void d_delete()
    {
        String url = baseUrl + "delete/" + this.contactType.getContactTypeId();
        this.restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).delete(url);
        System.out.println(url);
    }


}