package za.ac.cput.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * Rhegan Albert Fortuin
 * 219273693
 * PatientGender entity
 * 15 August 2022
 *
 */

@Entity
public class PatientGender implements Serializable {
    @Id
    @Column(name = "patientGender_id")
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
        this.patientID = builder.patientID;
        this.genderID = builder.genderID;
    }

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
    }

    //builder class
    public static class patientGenderBuilder{
        private String patientGenderID;
        private Patient patientID;
        private Gender genderID;

        public patientGenderBuilder setPatientGenderID(String patientGenderID) {
            this.patientGenderID = patientGenderID;
            return this;
        }

        public patientGenderBuilder setPatientID(Patient patientID) {
            this.patientID = patientID;
            return this;
        }

        public patientGenderBuilder setGenderID(Gender genderID) {
            this.genderID = genderID;
            return this;
        }

        public PatientGender.patientGenderBuilder copy(PatientGender patientGender){
            this.patientID = patientGender.patientID;
            this.genderID = patientGender.genderID;

            return this;
        }

        public PatientGender build(){
            return new PatientGender(this);
        }
    }
}
