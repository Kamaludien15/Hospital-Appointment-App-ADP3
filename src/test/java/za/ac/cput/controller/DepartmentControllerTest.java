package za.ac.cput.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Department;
import za.ac.cput.factory.DepartmentFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class DepartmentControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private static Department department = DepartmentFactory.createDepartment("IT", "23", "10");
    private String baseUrl;

    @BeforeEach
    void setUp() {
        this.baseUrl = "http://localhost:"+ this.port + "/hospital_appointment_management-db/department/";
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void a_save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Department> response = this.restTemplate.postForEntity(url, this.department, Department.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    void b_read() {
        String url = baseUrl+"read/" + this.department.getDepartmentId();
        System.out.println(url);
        ResponseEntity<Department> response = this.restTemplate.getForEntity(url, Department.class);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    void c_getAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Department[]> response = this.restTemplate.getForEntity(url, Department[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertTrue(response.getBody().length == 1)
        );
    }

    @Test
    void d_delete() {
        String url = baseUrl + "delete/" + this.department.getDepartmentId();
        this.restTemplate.delete(url);
    }

}
