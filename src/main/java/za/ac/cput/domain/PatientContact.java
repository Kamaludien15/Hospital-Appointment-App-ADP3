package za.ac.cput.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PatientContact implements Serializable {

    @Id
    @Column(name = "patientContact_id")
    private String patientContactId;

    @OneToOne
    @JoinColumn(name = "contact_type_id", referencedColumnName = "contact_type_id")
    private ContactType contactType;

    @OneToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    private Patient patient;


    public PatientContact(PatientContact.Builder builder) {
        this.patientContactId = builder.patientContactId;
        this.contactType = builder.contactType;
        this.patient = builder.patient;
    }

    protected PatientContact(){}

    public String getPatientContactId() {
        return patientContactId;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public Patient getPatient() {
        return patient;
    }

    public static class Builder{

        private String patientContactId;

        private ContactType contactType;

        private Patient patient;

        public PatientContact.Builder setPatientContactId(String patientContactId){
            this.patientContactId = patientContactId;
            return this;
        }

        public PatientContact.Builder setContactType(ContactType contactType){
            this.contactType = contactType;
            return this;
        }

        public PatientContact.Builder setPatient(Patient patient){
            this.patient = patient;
            return this;
        }

        public PatientContact.Builder copy(PatientContact PatientContact){
            this.patientContactId = PatientContact.patientContactId;
            this.contactType = PatientContact.contactType;
            this.patient = PatientContact.patient;
            return this;
        }

        public PatientContact build(){ return new PatientContact(this); }

    }

    @Override
    public String toString() {
        return "PatientContact{" +
                "patientContactId='" + patientContactId + '\'' +
                ", contactType=" + contactType +
                ", patient=" + patient +
                '}';
    }

    public void contact(){
        System.out.println("Patient contact created!");
    }
}
