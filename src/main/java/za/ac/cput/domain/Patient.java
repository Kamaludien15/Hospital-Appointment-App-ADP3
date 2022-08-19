package za.ac.cput.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 *
 * Rhegan Albert Fortuin
 * 219273693
 * Patient entity
 * 14 August 2022
 *
 */

@Entity
public class Patient {
    //variables
    @Id
    @Column(name = "patient_id")
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

    //constructor
    protected Patient() {}

    //getters
    public String getPatientID() {
        return patientID;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public String getPatientDateOfBirth() {
        return patientDateOfBirth;
    }

    //toString
    @Override
    public String toString() {
        return "patient{" +
                "patientID=" + patientID +
                ", patientFirstName=" + patientFirstName +
                ", patientLastName=" + patientLastName +
                ", patientDateOfBirth=" + patientDateOfBirth +
                '}';
    }

    //Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient that = (Patient) o;
        return patientID.equals(that.patientID) && Objects.equals(patientFirstName, that.patientFirstName) && Objects.equals(patientLastName, that.patientLastName) && Objects.equals(patientDateOfBirth, that.patientDateOfBirth);
    }

    //Hashcode
    @Override
    public int hashCode() {
        return Objects.hash(patientID, patientFirstName, patientLastName, patientDateOfBirth);
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

        public patientBuilder copy(Patient patient){
            this.patientID = patient.patientID;
            this.patientFirstName = patient.patientFirstName;
            this.patientLastName = patient.patientLastName;
            this.patientDateOfBirth = patient.patientDateOfBirth;

            return this;
        }

        public Patient build(){
            return new Patient(this);
        }
    }

}
