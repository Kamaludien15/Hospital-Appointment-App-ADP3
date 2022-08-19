/* AppointmentFactoryTest.java
 Testing class for AppointmentFactoryTest
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/
package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Appointment;
import za.ac.cput.factory.AppointmentFactory;
import za.ac.cput.repository.IAppointmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService implements IAppointmentService{

    private static IAppointmentRepository repository = null;

    @Autowired
    private AppointmentService(IAppointmentRepository appointmentRepository){
        this.repository = appointmentRepository;
    }

    @Override
    public Appointment save(Appointment appointment) {
        Appointment obj = AppointmentFactory.createAppointment(appointment.getPatient(),appointment.getHospital(),appointment.getEmployee(),appointment.getPrescription(),
                appointment.getProcedure(),appointment.getAppointmentDate());
        return this.repository.save(obj);
    }

    @Override
    public Optional<Appointment> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Appointment appointment) {
        this.repository.delete(appointment);
    }

    @Override
    public List<Appointment> getAll() {
        return this.repository.findAll();
    }
}
