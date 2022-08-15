/* AddressControllerTest.java
 Test class for AddressController
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.*;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.factory.*;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.CountryFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AppointmentControllerTest {

    @LocalServerPort
    private int port;

    @Autowired private AppointmentController appointmentController;
    @Autowired private TestRestTemplate restTemplate;

    private Patient patient;
    private Hospital hospital;
    private Employee employee;
    private Medicine medicine;
    private Prescription prescription;
    private Procedure procedure;
    private Appointment appointment;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(appointmentController);
        this.patient = PatientFactory.createPatient("Rick", "Rock", "01-Janurary-1999");
        this.hospital = HospitalFactory.createHospital("Spring View Hospital", 1000, "Private");
        this.employee = EmployeeFactory.createEmployee("James", "Johnson", "01-Janurary-1997");
        this.medicine = MedicineFactory.createMedicine("500ml", "Twice Day", 500);
        this.prescription = PrescriptionFactory.createPrescription(medicine, "01-Janurary-2022", "Twice a year");
        this.procedure = ProcedureFactory.createProcedure("Eye Sight Test", "Test patients eyesight strength", 1000);
        this.appointment = AppointmentFactory.createAppointment(patient,hospital,employee,prescription,procedure,"01-January-2022");

        this.baseUrl = "http://localhost:"+ this.port + "hospital_appointment_management-db/appointment/";
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Appointment> response = this.restTemplate.postForEntity(url, this.appointment, Appointment.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    void read() {
        String url = baseUrl+"read/" + this.appointment.getAppointmentID();
        System.out.println(url);
        ResponseEntity<Appointment> response = this.restTemplate.getForEntity(url, Appointment.class);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    void getAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Appointment[]> response = this.restTemplate.getForEntity(url, Appointment[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertTrue(response.getBody().length == 0)
        );
    }

    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.appointment.getAppointmentID();
        this.restTemplate.delete(url);
    }


}