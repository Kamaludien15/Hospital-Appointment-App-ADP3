/* AppointmentRepositoryImpl.java
 Repository for the Appointment class
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/

package za.ac.cput.impl;

import za.ac.cput.entity.Appointment;
import za.ac.cput.repository.IAppointmentRepository;

import java.util.HashSet;
import java.util.Set;

public class AppointmentRepositoryImpl implements IAppointmentRepository {

    private static AppointmentRepositoryImpl repository = null;
    private Set<Appointment> appointmentDB = null;

    private AppointmentRepositoryImpl(){
        appointmentDB = new HashSet<Appointment>();
    }

    public static AppointmentRepositoryImpl getRepository(){
        if(repository == null){
            repository = new AppointmentRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Appointment create(Appointment appointment) {
        boolean success = appointmentDB.add(appointment);
        if(!success){
            return null;
        }
        return appointment;
    }

    @Override
    public Appointment read(String ID) {
        Appointment appointment = appointmentDB.stream()
                .filter(e -> e.getAppointmentID().equals(ID))
                .findAny()
                .orElse(null);
        return appointment;
    }

    @Override
    public Appointment update(Appointment appointment) {
        Appointment oldAppointment = read(appointment.getAppointmentID());
        if(oldAppointment != null){
            appointmentDB.remove(oldAppointment);
            appointmentDB.add(appointment);
            return appointment;
        }
        return null;
    }

    @Override
    public boolean delete(String ID) {
        Appointment appointmentToDelete = read(ID);
        if (appointmentToDelete == null){
            return false;
        }

        appointmentDB.remove(appointmentToDelete);
        return true;
    }

    @Override
    public Set<Appointment> getAll() {
        return appointmentDB;
    }

}
