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
    private String password;
    private String username;

    //builder constructor
    public Patient(patientBuilder builder){
        this.patientID = builder.patientID;
        this.patientFirstName = builder.patientFirstName;
        this.patientLastName = builder.patientLastName;
        this.patientDateOfBirth = builder.patientDateOfBirth;
        this.password = builder.password;
        this.username = builder.username;
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

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    //toString
    @Override
    public String toString() {
        return "patient{" +
                "patientID=" + patientID +
                ", patientFirstName=" + patientFirstName +
                ", patientLastName=" + patientLastName +
                ", patientDateOfBirth=" + patientDateOfBirth +
                ", password=" + password +
                ", username=" + username +
                '}';
    }

    //Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient that = (Patient) o;
        return patientID.equals(that.patientID) && Objects.equals(patientFirstName, that.patientFirstName) && Objects.equals(patientLastName, that.patientLastName) && Objects.equals(patientDateOfBirth, that.patientDateOfBirth) && Objects.equals(password, that.password)&& Objects.equals(username, that.username);
    }

    //Hashcode
    @Override
    public int hashCode() {
        return Objects.hash(patientID, patientFirstName, patientLastName, patientDateOfBirth, password, username);
    }

    //builder class
    public static class patientBuilder {
        private String patientID;
        private String patientFirstName;
        private String patientLastName;
        private String patientDateOfBirth;
        private String password;
        private String username;

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

        public patientBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public patientBuilder setUsername(String username) {
            this.username = username;
            return this;
        }
        public patientBuilder copy(Patient patient){
            this.patientID = patient.patientID;
            this.patientFirstName = patient.patientFirstName;
            this.patientLastName = patient.patientLastName;
            this.patientDateOfBirth = patient.patientDateOfBirth;
            this.password = patient.password;
            this.username = patient.username;

            return this;
        }

        public Patient build(){
            return new Patient(this);
        }
    }
}
