package za.ac.cput.domain;

<<<<<<< HEAD
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

=======
>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
/**
 *
 * Rhegan Albert Fortuin
 * 219273693
<<<<<<< HEAD
 * PatientGender entity
 * 15 August 2022
 *
 */

@Entity
public class PatientGender implements Serializable {
    @Id
    @Column (name = "patientGender_id")
    private String patientGenderID;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    private Patient patientID;

    @ManyToOne
    @JoinColumn(name = "gender_id", referencedColumnName = "gender_id")
    private Gender genderID;

    //builder constructor
    public PatientGender(patientGenderBuilder builder){
        this.patientGenderID = builder.patientGenderID;
=======
 * Patient entity
 * 07 April 2022
 *
 */

public class PatientGender {
    private String patientID;
    private String genderID;

    //builder constructor
    public PatientGender(patientGenderBuilder builder){
>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
        this.patientID = builder.patientID;
        this.genderID = builder.genderID;
    }

<<<<<<< HEAD
    //constructor
    protected PatientGender() {}

    //getters
    public String getPatientGenderID() {
        return patientGenderID;
    }
    public Patient getPatientID() {
        return patientID;
    }

    public Gender getGenderID() {
        return genderID;
    }

    //toString
    @Override
    public String toString() {
        return "PatientGender{" +
                "patientGenderID='" + patientGenderID + '\'' +
                ", patientID=" + patientID +
                ", genderID=" + genderID +
                '}';
    }

    //Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientGender that = (PatientGender) o;
        return patientID.equals(that.patientID) && Objects.equals(genderID, that.genderID);
    }

    //Hashcode
    @Override
    public int hashCode() {
        return Objects.hash(patientID, genderID);
=======
    //setters and getters
    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getGenderID() {
        return genderID;
    }

    public void setGenderID(String genderID) {
        this.genderID = genderID;
    }

    @Override
    public String toString() {
        return "patientGender{" +
                "patientID=" + patientID +
                ", genderID=" + genderID +
                '}';
>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
    }

    //builder class
    public static class patientGenderBuilder{
<<<<<<< HEAD
        private String patientGenderID;
        private Patient patientID;
        private Gender genderID;

        public patientGenderBuilder setPatientGenderID(String patientGenderID) {
            this.patientGenderID = patientGenderID;
            return this;
        }

        public patientGenderBuilder setPatientID(Patient patientID) {
=======
        private String patientID;
        private String genderID;

        public patientGenderBuilder setPatientID(String patientID) {
>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
            this.patientID = patientID;
            return this;
        }

<<<<<<< HEAD
        public patientGenderBuilder setGenderID(Gender genderID) {
=======
        public patientGenderBuilder setGenderID(String genderID) {
>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
            this.genderID = genderID;
            return this;
        }



        public PatientGender.patientGenderBuilder copy(PatientGender patientGender){
            this.patientID = patientGender.patientID;
            this.genderID = patientGender.genderID;

            return this;
        }

<<<<<<< HEAD
        public PatientGender build(){
=======
        public PatientGender Builder(){
>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
            return new PatientGender(this);
        }
    }

}
