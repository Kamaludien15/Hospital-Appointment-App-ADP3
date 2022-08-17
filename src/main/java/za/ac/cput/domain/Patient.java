package za.ac.cput.domain;

/**
 *
 * Rhegan Albert Fortuin
 * 219273693
 * Patient entity
 * 07 April 2022
 *
 */

public class Patient {
    private String patientID;
    private String patientFirstName;
    private String patientLastName;
    private String patientDateOfBirth;

    //builder constructor
    public Patient(patientBuilder builder){
        this.patientID = builder.patientID;
        this.patientFirstName = builder.patientFirstName;
        this.patientLastName = builder.patientLastName;
        this.patientDateOfBirth = builder.patientDateOfBirth;
    }

    //setters and getters
    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public String getPatientDateOfBirth() {
        return patientDateOfBirth;
    }

    public void setPatientDateOfBirth(String patientDateOfBirth) {
        this.patientDateOfBirth = patientDateOfBirth;
    }

    @Override
    public String toString() {
        return "patient{" +
                "patientID=" + patientID +
                ", patientFirstName=" + patientFirstName +
                ", patientLastName=" + patientLastName +
                ", patientDateOfBirth=" + patientDateOfBirth +
                '}';
    }

    //builder class
    public static class patientBuilder {
        private String patientID;
        private String patientFirstName;
        private String patientLastName;
        private String patientDateOfBirth;

        public patientBuilder setPatientID(String patientID) {
            this.patientID = patientID;
            return this;
        }

        public patientBuilder setPatientFirstName(String patientFirstName) {
            this.patientFirstName = patientFirstName;
            return this;
        }

        public patientBuilder setPatientLastName(String patientLastName) {
            this.patientLastName = patientLastName;
            return this;
        }

        public patientBuilder setPatientDateOfBirth(String patientDateOfBirth) {
            this.patientDateOfBirth = patientDateOfBirth;
            return this;
        }

        public Patient.patientBuilder copy(Patient patient){
            this.patientID = patient.patientID;
            this.patientFirstName = patient.patientFirstName;
            this.patientLastName = patient.patientLastName;
            this.patientDateOfBirth = patient.patientDateOfBirth;

            return this;
        }

        public Patient Builder(){
            return new Patient(this);
        }
    }

}
