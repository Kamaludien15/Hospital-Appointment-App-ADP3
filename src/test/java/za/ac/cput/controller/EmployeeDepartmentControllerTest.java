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
public class EmployeeDepartmentControllerTest {

    @LocalServerPort
    private int port;

    private String SECURITY_USERNAME = "Admin";
    private String SECURITY_PASSWORD = "passwordAdmin";
    @Autowired
    private TestRestTemplate restTemplate;

    private static Employee employee = EmployeeFactory.createEmployee("John", "Woods", "1987-20-03", "MyPassword");
    private static Department department = DepartmentFactory.createDepartment("IT","25","09");
    private static EmployeeDepartment employeeDepartment = EmployeeDepartmentFactory.createEmployeeDepartment(employee, department);
    private String baseUrl;

    @BeforeEach
    void setUp() {
        String urlEmployee = "http://localhost:"+ this.port + "/hospital_appointment_management-db/employee/save";
        ResponseEntity<Employee> employeeResponseEntity = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(urlEmployee, this.employee, Employee.class);
        String urlDepartment = "http://localhost:"+ this.port + "/hospital_appointment_management-db/department/save";
        ResponseEntity<Department> responseLocation = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(urlDepartment, this.department, Department.class);
        this.baseUrl = "http://localhost:"+ this.port + "/hospital_appointment_management-db/employeeDepartment/";
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void a_save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<EmployeeDepartment> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, this.employeeDepartment, EmployeeDepartment.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    void b_read() {
        String url = baseUrl+"read/" + this.employeeDepartment.getEmployeeDepartmentId();
        System.out.println(url);
        ResponseEntity<EmployeeDepartment> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, EmployeeDepartment.class);
        assertAll(
                ()-> assertNotEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    void c_getAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<EmployeeDepartment[]> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, EmployeeDepartment[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertTrue(response.getBody().length == 1)
        );
    }

    @Test
    void d_delete() {
        String url = baseUrl + "delete/" + this.employeeDepartment.getEmployeeDepartmentId();
        this.restTemplate
        .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .delete(url);
    }

}
