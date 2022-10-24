package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)

public class EmployeeControllerTest {

    @LocalServerPort
    private int port;
    private String SECURITY_USERNAME = "Admin";
    private String SECURITY_PASSWORD = "passwordAdmin";

    @Autowired
    private TestRestTemplate restTemplate;

    private static Employee employee = EmployeeFactory.createEmployee("Jackson", "Mayne", "1976-20-04", "MyPass");
    private String baseUrl;

    @BeforeEach
    void setUp() {
        this.baseUrl = "http://localhost:"+ this.port + "/hospital_appointment_management-db/employee/";
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void a_save() {
        String url = this.baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Employee> response = this.restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, this.employee, Employee.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    void b_read() {
        String url = baseUrl+"read/" + this.employee.getEmployeeId();
        System.out.println(url);
        ResponseEntity<Employee> response = this.restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Employee.class);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    void c_getAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Employee[]> response = this.restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Employee[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertTrue(response.getBody().length != 0)
        );
    }

    @Test
    void d_delete() {
        String url = baseUrl + "delete/" + this.employee.getEmployeeId();
        this.restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).delete(url);
    }

}
