/* Appointment.java
 Entity for the Appointment
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/

package za.ac.cput.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Appointment implements Serializable {

    //-----Variables-----
    @Id
    @Column(name ="appointment_id")
    private String appointmentID;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "hospital_id", referencedColumnName = "hospital_id")
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    @OneToMany
    @JoinColumn(name = "prescription_id", referencedColumnName = "prescription_id")
    private Prescription prescription;

    @ManyToOne
    @JoinColumn(name = "procedure_id", referencedColumnName = "procedure_id")
    private Procedure procedure;

    private String appointmentDate;

    //-----Constructor-----
    private Appointment(Appointment.Builder builder) {
        this.appointmentID = builder.appointmentID;
        this.patient = builder.patient;
        this.hospital = builder.hospital;
        this.employee = builder.employee;
        this.prescription = builder.prescription;
        this.procedure = builder.procedure;
        this.appointmentDate = builder.appointmentDate;
    }

    protected Appointment() {}

    //-----Getters-----
    public String getAppointmentID() {
        return appointmentID;
    }

    public Patient getPatient() {
        return patient;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public Procedure getProcedure() {
        return procedure;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    //-----Builder-----
    public static class Builder{

        private String appointmentID;
        private Patient patient;
        private Hospital hospital;
        private Employee employee;
        private Prescription prescription;
        private Procedure procedure;
        private String appointmentDate;

        public Appointment.Builder setAppointmentID(String appointmentID) {
            this.appointmentID = appointmentID;
            return this;
        }

        public Appointment.Builder setPatient(Patient patient) {
            this.patient = patient;
            return this;
        }

        public Appointment.Builder setHospital(Hospital hospital) {
            this.hospital = hospital;
            return this;
        }

        public Appointment.Builder setEmployee(Employee employee) {
            this.employee = employee;
            return this;
        }

        public Appointment.Builder setPrescription(Prescription prescription) {
            this.prescription = prescription;
            return this;
        }

        public Appointment.Builder setProcedure(Procedure procedure) {
            this.procedure = procedure;
            return this;
        }

        public Appointment.Builder setAppointmentDate(String appointmentDate) {
            this.appointmentDate = appointmentDate;
            return this;
        }

        public Appointment.Builder copy(Appointment Appointment){
            this.appointmentID = Appointment.appointmentID;
            this.patient = Appointment.patient;
            this.hospital = Appointment.hospital;
            this.employee = Appointment.employee;
            this.prescription = Appointment.prescription;
            this.procedure = Appointment.procedure;
            this.appointmentDate = Appointment.appointmentDate;

            return this;
        }

        public Appointment build(){

            return new Appointment(this);

        }

    }

    //-----ToString-----
    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentID='" + appointmentID + '\'' +
                ", patient=" + patient +
                ", hospital=" + hospital +
                ", employee=" + employee +
                ", prescription=" + prescription +
                ", procedure=" + procedure +
                ", appointmentDate='" + appointmentDate + '\'' +
                '}';
    }

    //-----Equals----
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return appointmentID.equals(that.appointmentID) && Objects.equals(patient, that.patient) && Objects.equals(hospital, that.hospital) && Objects.equals(employee, that.employee) && Objects.equals(prescription, that.prescription) && Objects.equals(procedure, that.procedure) && Objects.equals(appointmentDate, that.appointmentDate);
    }

    //-----Hashcode----
    @Override
    public int hashCode() {
        return Objects.hash(appointmentID, patient, hospital, employee, prescription, procedure, appointmentDate);
    }
}
