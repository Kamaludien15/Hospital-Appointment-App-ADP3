/* AddressAPI.java
 API for address controller
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Appointment;
import za.ac.cput.service.IAppointmentService;
import za.ac.cput.service.IEmployeeService;
import za.ac.cput.service.IHospitalService;

import java.util.List;
import java.util.Optional;

@Component
public class AppointmentAPI {

    private final IAppointmentService appointmentService;
    private final IPatientService patientService;
    private final IHospitalService hospitalService;
    private final IEmployeeService employeeService;
    private final IPrescriptionService prescriptionService;
    private final IProcedureService procedureService;

    @Autowired
    public AppointmentAPI(IAppointmentService appointmentService, IPatientService patientService, IHospitalService hospitalService, IEmployeeService employeeService,
                          IPrescriptionService prescriptionService, IProcedureService procedureService) {
        this.appointmentService = appointmentService;
        this.patientService = patientService;
        this.hospitalService = hospitalService;
        this.employeeService = employeeService;
        this.prescriptionService = prescriptionService;
        this.procedureService = procedureService;
    }


    public Appointment save(Appointment appointment) {
        this.patientService.read(appointment.getPatient().getPatientID()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found"));
        this.hospitalService.read(appointment.getHospital().getHospitalID()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hospital not found"));
        this.employeeService.read(appointment.getEmployee().getEmployeeId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        this.prescriptionService.read(appointment.getPrescription().getScriptRef()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Prescription not found"));
        this.procedureService.read(appointment.getProcedure().getProcedureID()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Procedure not found"));
        return this.appointmentService.save(appointment);
    }

    public Optional<Appointment> read(String id) {
        return this.appointmentService.read(id);
    }

    public void delete(Appointment appointment) {
        this.appointmentService.delete(appointment);
    }


    public List<Appointment> getAll() {
        return this.appointmentService.getAll();
    }
}
