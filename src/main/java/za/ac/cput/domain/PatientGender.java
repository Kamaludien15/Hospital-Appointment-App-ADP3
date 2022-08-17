package za.ac.cput.domain;

/**
 *
 * Rhegan Albert Fortuin
 * 219273693
 * Patient entity
 * 07 April 2022
 *
 */

public class PatientGender {
    private String patientID;
    private String genderID;

    //builder constructor
    public PatientGender(patientGenderBuilder builder){
        this.patientID = builder.patientID;
        this.genderID = builder.genderID;
    }

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
    }

    //builder class
    public static class patientGenderBuilder{
        private String patientID;
        private String genderID;

        public patientGenderBuilder setPatientID(String patientID) {
            this.patientID = patientID;
            return this;
        }

        public patientGenderBuilder setGenderID(String genderID) {
            this.genderID = genderID;
            return this;
        }



        public PatientGender.patientGenderBuilder copy(PatientGender patientGender){
            this.patientID = patientGender.patientID;
            this.genderID = patientGender.genderID;

            return this;
        }

        public PatientGender Builder(){
            return new PatientGender(this);
        }
    }

}
