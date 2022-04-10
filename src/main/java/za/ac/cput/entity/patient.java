package za.ac.cput.entity;

/**
 *
 * Rhegan Albert Fortuin
 * 219273693
 * Patient entity
 * 07 April 2022
 *
 */

public class patient {
    int patientID;
    String patientFirstName;
    String patientLastName;
    String patientDateOfBirth;

    public patient(patientBuilder builder){
        this.patientID = builder.patientID;
        this.patientFirstName = builder.patientFirstName;
        this.patientLastName = builder.patientLastName;
        this.patientDateOfBirth = builder.patientDateOfBirth;
    }

    public int setPatientID(int patientID) {
        this.patientID = patientID;
        return patientID;
    }

    public String setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
        return patientFirstName;
    }

    public String setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
        return patientLastName;
    }

    public String setPatientDateOfBirth(String patientDateOfBirth) {
        this.patientDateOfBirth = patientDateOfBirth;
        return patientDateOfBirth;
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

    public static class patientBuilder {
        private int patientID;
        private String patientFirstName;
        private String patientLastName;
        private String patientDateOfBirth;

        public patientBuilder setPatientID(int patientID) {
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

        public patient Builder(){
            return new patient(this);
        }
    }

}
