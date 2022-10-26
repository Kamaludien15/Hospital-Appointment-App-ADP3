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
import za.ac.cput.service.IAppointmentService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class AppointmentAPITest {

    @Autowired private AppointmentAPI api;
    @Autowired private PatientAPI patientAPI;
    @Autowired private HospitalAPI hospitalAPI;
    @Autowired private EmployeeAPI employeeAPI;
    @Autowired private MedicineAPI medicineAPI;
    @Autowired private PrescriptionAPI prescriptionAPI;
    @Autowired private ProcedureAPI procedureAPI;
    private Patient patient;
    private Hospital hospital;
    private Employee employee;
    private Medicine medicine;
    private Prescription prescription;
    private Procedure procedure;
    private Appointment appointment;

    @BeforeEach
    void setUp() {
        this.patient = PatientFactory.createPatient("Rick", "Rock", "01-Janurary-1999", "123456789", "gg");
        this.hospital = HospitalFactory.createHospital("Spring View Hospital", 1000, "Private");
        this.employee = EmployeeFactory.createEmployee("James", "Johnson", "01-Janurary-1997", "123456789", "gg");
        this.medicine = MedicineFactory.createMedicine("Panado", "500ml", "Twice a day", "R500.00");
        this.prescription = PrescriptionFactory.createPrescription(medicine, "01-Janurary-2022", "Twice a year");
        this.procedure = ProcedureFactory.createProcedure("Eye Sight Test", "Test patients eyesight strength", "R1000.00");
        this.appointment = AppointmentFactory.createAppointment(patient,hospital,employee,prescription,procedure,"01-January-2022");
    }

    @AfterEach
    void tearDown(){
        this.api.delete(this.appointment);
        this.patientAPI.delete(this.patient);
        this.hospitalAPI.delete(this.hospital);
        this.employeeAPI.delete(this.employee);
        this.prescriptionAPI.delete(this.prescription);
        this.medicineAPI.delete(this.medicine);
        this.procedureAPI.delete(this.procedure);
    }

    @Test
    void a_save() {
        Patient savedPatient = this.patientAPI.save(this.patient);
        Hospital savedHospital = this.hospitalAPI.save(this.hospital);
        Employee savedEmployee = this.employeeAPI.save(this.employee);
        Medicine savedMedicine = this.medicineAPI.save(this.medicine);
        Prescription savedPrescription = this.prescriptionAPI.save(this.prescription);
        Procedure savedProcedure = this.procedureAPI.save(this.procedure);
        Appointment saved = this.api.save(this.appointment);

        assertNotNull(saved);
        assertSame(this.appointment.getAppointmentID(), saved.getAppointmentID());
    }

    @Test
    void b_read() {
        Patient savedPatient = this.patientAPI.save(this.patient);
        Hospital savedHospital = this.hospitalAPI.save(this.hospital);
        Employee savedEmployee = this.employeeAPI.save(this.employee);
        Medicine savedMedicine = this.medicineAPI.save(this.medicine);
        Prescription savedPrescription = this.prescriptionAPI.save(this.prescription);
        Procedure savedProcedure = this.procedureAPI.save(this.procedure);
        Appointment saved = this.api.save(this.appointment);

        Optional<Appointment> read = this.api.read(this.appointment.getAppointmentID());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved.getAppointmentID(), read.get().getAppointmentID())
        );
    }

    @Test
    void c_delete() {
        Patient savedPatient = this.patientAPI.save(this.patient);
        Hospital savedHospital = this.hospitalAPI.save(this.hospital);
        Employee savedEmployee = this.employeeAPI.save(this.employee);
        Medicine savedMedicine = this.medicineAPI.save(this.medicine);
        Prescription savedPrescription = this.prescriptionAPI.save(this.prescription);
        Procedure savedProcedure = this.procedureAPI.save(this.procedure);
        Appointment saved = this.api.save(this.appointment);
        int before = this.api.getAll().size();
        this.api.delete(saved);
        before = before - 1;
        List<Appointment> appointmentListSet = this.api.getAll();
        assertEquals(before,appointmentListSet.size());
    }

    @Test
    void d_getAll() {
        Patient savedPatient = this.patientAPI.save(this.patient);
        Hospital savedHospital = this.hospitalAPI.save(this.hospital);
        Employee savedEmployee = this.employeeAPI.save(this.employee);
        Medicine savedMedicine = this.medicineAPI.save(this.medicine);
        Prescription savedPrescription = this.prescriptionAPI.save(this.prescription);
        Procedure savedProcedure = this.procedureAPI.save(this.procedure);
        Appointment saved = this.api.save(this.appointment);

        List<Appointment> appointmentList = this.api.getAll();
        assertNotNull(appointmentList.size());
    }
}