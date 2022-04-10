package za.ac.cput.entity;

/**
 *
 * Rhegan Albert Fortuin
 * 219273693
 * Patient entity
 * 07 April 2022
 *
 */

import za.ac.cput.entity.patient;
import za.ac.cput.entity.gender;

public class patientGender {
    int patientID;
    int genderID;

    public patientGender(patientGenderBuilder builder){
        this.patientID = builder.patientID;
        this.genderID = builder.genderID;
    }

    public int setPatientID(int patientID) {
        this.patientID = patientID;
        return patientID;
    }

    public int setGenderID(int genderID) {
        this.genderID = genderID;
        return genderID;
    }

    @Override
    public String toString() {
        return "patientGender{" +
                "patientID=" + patientID +
                ", genderID=" + genderID +
                '}';
    }

    public static class patientGenderBuilder{
        private int patientID;
        private int genderID;

        public patientGenderBuilder setPatientID(int patientID) {
            this.patientID = patientID;
            return this;
        }

        public patientGenderBuilder setGenderID(int genderID) {
            this.genderID = genderID;
            return this;
        }

        public patientGender Builder(){
            return new patientGender(this);
        }
    }

}
