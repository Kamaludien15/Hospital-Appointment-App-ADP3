package za.ac.cput.domain;

<<<<<<< HEAD
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

=======
>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
/**
 *
 * Rhegan Albert Fortuin
 * 219273693
 * Patient entity
<<<<<<< HEAD
 * 14 August 2022
 *
 */

@Entity
public class Patient {
    //variables
    @Id
    @Column(name = "patient_id")
=======
 * 07 April 2022
 *
 */

public class Patient {
>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
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

<<<<<<< HEAD
    //constructor
    protected Patient() {}

    //getters
=======
    //setters and getters
>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
    public String getPatientID() {
        return patientID;
    }

<<<<<<< HEAD
=======
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
    public String getPatientFirstName() {
        return patientFirstName;
    }

<<<<<<< HEAD
=======
    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
    public String getPatientLastName() {
        return patientLastName;
    }

<<<<<<< HEAD
=======
    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
    public String getPatientDateOfBirth() {
        return patientDateOfBirth;
    }

<<<<<<< HEAD
    //toString
=======
    public void setPatientDateOfBirth(String patientDateOfBirth) {
        this.patientDateOfBirth = patientDateOfBirth;
    }

>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
    @Override
    public String toString() {
        return "patient{" +
                "patientID=" + patientID +
                ", patientFirstName=" + patientFirstName +
                ", patientLastName=" + patientLastName +
                ", patientDateOfBirth=" + patientDateOfBirth +
                '}';
    }

<<<<<<< HEAD
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

=======
>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
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

<<<<<<< HEAD
        public patientBuilder copy(Patient patient){
=======
        public Patient.patientBuilder copy(Patient patient){
>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
            this.patientID = patient.patientID;
            this.patientFirstName = patient.patientFirstName;
            this.patientLastName = patient.patientLastName;
            this.patientDateOfBirth = patient.patientDateOfBirth;

            return this;
        }

<<<<<<< HEAD
        public Patient build(){
=======
        public Patient Builder(){
>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
            return new Patient(this);
        }
    }

}
