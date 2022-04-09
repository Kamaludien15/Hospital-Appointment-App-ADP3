/* Appointment.java
 Entity for the Appointment
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/

package za.ac.cput.entity;


public class Appointment {

    //-----Variables-----
    private String appointmentID;
    private String patientID;
    private String hospitalID;
    private String employeeID;
    private String scriptRef;
    private String procedureID;
    private String appointmentDate;

    //-----Constructor-----
    public Appointment(Appointment.Builder builder) {
        this.appointmentID = builder.appointmentID;
        this.patientID = builder.patientID;
        this.hospitalID = builder.hospitalID;
        this.employeeID = builder.employeeID;
        this.scriptRef = builder.scriptRef;
        this.procedureID = builder.procedureID;
        this.appointmentDate = builder.appointmentDate;
    }

    //-----Getters and Setters-----
    public String getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getHospitalID() {
        return hospitalID;
    }

    public void setHospitalID(String hospitalID) {
        this.hospitalID = hospitalID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getScriptRef() {
        return scriptRef;
    }

    public void setScriptRef(String scriptRef) {
        this.scriptRef = scriptRef;
    }

    public String getProcedureID() {
        return procedureID;
    }

    public void setProcedureID(String procedureID) {
        this.procedureID = procedureID;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    //-----ToString-----
    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentID='" + appointmentID + '\'' +
                ", patientID='" + patientID + '\'' +
                ", hospitalID='" + hospitalID + '\'' +
                ", employeeID='" + employeeID + '\'' +
                ", scriptRef='" + scriptRef + '\'' +
                ", procedureID='" + procedureID + '\'' +
                ", appointmentDate='" + appointmentDate + '\'' +
                '}';
    }

    //-----Builder-----
    public static class Builder{

        private String appointmentID;
        private String patientID;
        private String hospitalID;
        private String employeeID;
        private String scriptRef;
        private String procedureID;
        private String appointmentDate;

        public Appointment.Builder setAppointmentID(String appointmentID) {
            this.appointmentID = appointmentID;
            return this;
        }

        public Appointment.Builder setPatientID(String patientID) {
            this.patientID = patientID;
            return this;
        }

        public Appointment.Builder setHospitalID(String hospitalID) {
            this.hospitalID = hospitalID;
            return this;
        }

        public Appointment.Builder setEmployeeID(String employeeID) {
            this.employeeID = employeeID;
            return this;
        }

        public Appointment.Builder setScriptRef(String scriptRef) {
            this.scriptRef = scriptRef;
            return this;
        }

        public Appointment.Builder setProcedureID(String procedureID) {
            this.procedureID = procedureID;
            return this;
        }

        public Appointment.Builder setAppointmentDate(String appointmentDate) {
            this.appointmentDate = appointmentDate;
            return this;
        }

        public Appointment.Builder copy(Appointment Appointment){
            this.appointmentID = Appointment.appointmentID;
            this.patientID = Appointment.patientID;
            this.hospitalID = Appointment.hospitalID;
            this.employeeID = Appointment.employeeID;
            this.scriptRef = Appointment.scriptRef;
            this.procedureID = Appointment.procedureID;
            this.appointmentDate = Appointment.appointmentDate;

            return this;
        }

        public Appointment build(){

            return new Appointment(this);

        }

    }

}
