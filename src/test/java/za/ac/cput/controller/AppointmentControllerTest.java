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
class AppointmentControllerTest {

    @LocalServerPort
    private int port;
    private String SECURITY_USERNAME = "admin";
    private String SECURITY_PASSWORD = "passwordAdmin";

    @Autowired private TestRestTemplate restTemplate;

    private static Patient patient= PatientFactory.createPatient("Rick", "Rock", "01-Janurary-1999", "123456789" , "gg");
    private static Hospital hospital = HospitalFactory.createHospital("Spring View Hospital", 1000, "Private");
    private static Employee employee = EmployeeFactory.createEmployee("James", "Johnson", "01-Janurary-1997", "123456789" , "gg");
    private static Medicine medicine = MedicineFactory.createMedicine("Panado", "500ml", "Twice a day", "R500.00");
    private static Prescription prescription = PrescriptionFactory.createPrescription(medicine, "01-Janurary-2022", "Twice a year");
    private static Procedure procedure = ProcedureFactory.createProcedure("Eye Sight Test", "Test patients eyesight strength", "R1000");
    private static Appointment appointment = AppointmentFactory.createAppointment(patient,hospital,employee,prescription,procedure,"01-January-2022");
    private static String baseUrl;

    @BeforeEach
    void setUp() {
        String urlPatient = "http://localhost:"+ this.port + "/hospital_appointment_management-db/patient/save";
        ResponseEntity<Patient> responsePatient = this.restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(urlPatient, this.patient, Patient.class);
        String urlHospital = "http://localhost:"+ this.port + "/hospital_appointment_management-db/hospital/save";
        ResponseEntity<Hospital> responseHospital = this.restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(urlHospital, this.hospital, Hospital.class);
        String urlEmployee = "http://localhost:"+ this.port + "/hospital_appointment_management-db/employee/save";
        ResponseEntity<Employee> responseEmployee = this.restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(urlEmployee, this.employee, Employee.class);
        String urlMedicine = "http://localhost:"+ this.port + "/hospital_appointment_management-db/medicine/save";
        ResponseEntity<Medicine> responseMedicine = this.restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(urlMedicine, this.medicine, Medicine.class);
        String urlPrescription = "http://localhost:"+ this.port + "/hospital_appointment_management-db/prescription/save";
        ResponseEntity<Prescription> responsePrescription = this.restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(urlPrescription, this.prescription, Prescription.class);
        String urlProcedure = "http://localhost:"+ this.port + "/hospital_appointment_management-db/procedure/save";
        ResponseEntity<Procedure> responseProcedure = this.restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(urlProcedure, this.procedure, Procedure.class);

        this.baseUrl = "http://localhost:"+ this.port + "/hospital_appointment_management-db/appointment/";
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void a_save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Appointment> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, this.appointment, Appointment.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    void b_read() {
        String url = baseUrl+"read/" + this.appointment.getAppointmentID();
        System.out.println(url);
        ResponseEntity<Appointment> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Appointment.class);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    void c_getAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Appointment[]> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Appointment[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode())
        );
    }

    @Test
    void d_delete() {
        String url = baseUrl + "delete/" + this.appointment.getAppointmentID();
        this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .delete(url);
    }


}