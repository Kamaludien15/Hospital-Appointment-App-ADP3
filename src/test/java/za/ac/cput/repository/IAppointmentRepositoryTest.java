/* AppointmentFactoryTest.java
 Testing class for AppointmentFactoryTest
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/
package za.ac.cput.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.repository.*;


import java.util.List;
import java.util.Optional;

@SpringBootTest
class IAppointmentRepositoryTest {

    @Autowired private IAppointmentRepository appointmentRepository;
    @Autowired private IPatientRepository patientRepository;
    @Autowired private IHospitalRepository hospitalRepository;
    @Autowired private IEmployeeRepository employeeRepository;
    @Autowired private IMedicineRepository medicineRepository;
    @Autowired private IPrescriptionRepository prescriptionRepository;
    @Autowired private IProcedureRepository procedureRepository;
    private Patient patient;
    private Hospital hospital;
    private Employee employee;
    private Medicine medicine;
    private Prescription prescription;
    private Procedure procedure;
    private Appointment appointment;

    @BeforeEach
    void setUp() {
        this.patient = PatientFactory.createPatient("Rick", "Rock", "01-Janurary-1999");
        this.hospital = HospitalFactory.createHospital("Spring View Hospital", 1000, "Private");
        this.employee = EmployeeFactory.createEmployee("James", "Johnson", "01-Janurary-1997");
        this.medicine = MedicineFactory.createMedicine("Panado", "500ml", "Twice a day", "R500.00");
        this.prescription = PrescriptionFactory.createPrescription(medicine, "01-Janurary-2022", "Twice a year");
        this.procedure = ProcedureFactory.createProcedure("Eye Sight Test", "Test patients eyesight strength", "R1000");
        this.appointment = AppointmentFactory.createAppointment(patient,hospital,employee,prescription,procedure,"01-January-2022");
    }

    @AfterEach
    void tearDown(){
        this.appointmentRepository.delete(this.appointment);
        this.patientRepository.delete(this.patient);
        this.hospitalRepository.delete(this.hospital);
        this.employeeRepository.delete(this.employee);
        this.prescriptionRepository.delete(this.prescription);
        this.medicineRepository.delete(this.medicine);
        this.procedureRepository.delete(this.procedure);
    }

    @Test
    void save() {
        Patient savedPatient = this.patientRepository.save(this.patient);
        Hospital savedHospital = this.hospitalRepository.save(this.hospital);
        Employee savedEmployee = this.employeeRepository.save(this.employee);
        Medicine savedMedicine = this.medicineRepository.save(this.medicine);
        Prescription savedPrescription = this.prescriptionRepository.save(this.prescription);
        Procedure savedProcedure = this.procedureRepository.save(this.procedure);
        Appointment saved = this.appointmentRepository.save(this.appointment);

        assertNotNull(saved);
        assertSame(this.appointment.getAppointmentID(), saved.getAppointmentID());
    }

    @Test
    void read() {
        Patient savedPatient = this.patientRepository.save(this.patient);
        Hospital savedHospital = this.hospitalRepository.save(this.hospital);
        Employee savedEmployee = this.employeeRepository.save(this.employee);
        Medicine savedMedicine = this.medicineRepository.save(this.medicine);
        Prescription savedPrescription = this.prescriptionRepository.save(this.prescription);
        Procedure savedProcedure = this.procedureRepository.save(this.procedure);
        Appointment saved = this.appointmentRepository.save(this.appointment);

        Optional<Appointment> read = this.appointmentRepository.findById(this.appointment.getAppointmentID());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved.getAppointmentID(), read.get().getAppointmentID())
        );
    }

    @Test
    void delete() {
        Patient savedPatient = this.patientRepository.save(this.patient);
        Hospital savedHospital = this.hospitalRepository.save(this.hospital);
        Employee savedEmployee = this.employeeRepository.save(this.employee);
        Medicine savedMedicine = this.medicineRepository.save(this.medicine);
        Prescription savedPrescription = this.prescriptionRepository.save(this.prescription);
        Procedure savedProcedure = this.procedureRepository.save(this.procedure);
        Appointment saved = this.appointmentRepository.save(this.appointment);

        this.appointmentRepository.delete(saved);
        List<Appointment> appointmentListSet = this.appointmentRepository.findAll();
        assertEquals(0,appointmentListSet.size());
    }

    @Test
    void getAll() {
        Patient savedPatient = this.patientRepository.save(this.patient);
        Hospital savedHospital = this.hospitalRepository.save(this.hospital);
        Employee savedEmployee = this.employeeRepository.save(this.employee);
        Medicine savedMedicine = this.medicineRepository.save(this.medicine);
        Prescription savedPrescription = this.prescriptionRepository.save(this.prescription);
        Procedure savedProcedure = this.procedureRepository.save(this.procedure);
        Appointment saved = this.appointmentRepository.save(this.appointment);

        List<Appointment> appointmentList = this.appointmentRepository.findAll();
        assertEquals(1,appointmentList.size());
    }
}