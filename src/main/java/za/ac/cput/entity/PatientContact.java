package za.ac.cput.entity;

public class PatientContact {
    private String contactTypeId;
    private String patientId;

    public PatientContact(String contactTypeId, String patientId) {
        this.contactTypeId = contactTypeId;
        this.patientId = patientId;
        contact();
    }

    public String getContactTypeId() {
        return contactTypeId;
    }

    public String getPatientId() {
        return patientId;
    }

    @Override
    public String toString() {
        return "PatientContact{" +
                "contactTypeId='" + contactTypeId + '\'' +
                ", patientId='" + patientId + '\'' +
                '}';
    }

    public void contact(){
        System.out.println("Patient contact created!");
    }
}
