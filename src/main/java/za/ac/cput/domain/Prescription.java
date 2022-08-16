/*
 * Prescription.java
 * Entity for the Prescription
 * Author: Mogamad Githr Parker (220408025)
 * Date: 10 April 2022
 * */
package za.ac.cput.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Prescription {
    @Id
    private String scriptRef;
    private String scriptIssueDate;
    private String scriptRecurrence;
    @ManyToOne
    private Medicine medicineID;

    protected Prescription() {}

    private Prescription(Builder builder) {
        this.scriptRef = builder.scriptRef;
        this.medicineID = builder.medicineID;
        this.scriptIssueDate = builder.scriptIssueDate;
        this.scriptRecurrence = builder.scriptRecurrence;
    }

    public String getScriptRef() {
        return scriptRef;
    }

    public String getScriptIssueDate() {
        return scriptIssueDate;
    }

    public String getScriptRecurrence() {
        return scriptRecurrence;
    }

    public Medicine getMedicineID() {
        return medicineID;
    }

    public static class Builder {
        private String scriptRef, scriptIssueDate, scriptRecurrence;
        private Medicine medicineID;

        public Builder setScriptRef(String scriptRef) {
            this.scriptRef = scriptRef;
            return this;
        }

        public Builder setMedicineID(Medicine medicineID) {
            this.medicineID = medicineID;
            return this;
        }

        public Builder setScriptIssueDate(String scriptIssueDate) {
            this.scriptIssueDate = scriptIssueDate;
            return this;
        }

        public Builder setScriptRecurrence(String scriptRecurrence) {
            this.scriptRecurrence = scriptRecurrence;
            return this;
        }

        public Builder copy(Prescription prescription) {
            this.scriptRef = prescription.scriptRef;
            this.medicineID = prescription.medicineID;
            this.scriptIssueDate = prescription.scriptIssueDate;
            this.scriptRecurrence = prescription.scriptRecurrence;
            return this;
        }

        public Prescription build() {
            return new Prescription(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prescription that = (Prescription) o;
        return scriptRef.equals(that.scriptRef) && scriptIssueDate.equals(that.scriptIssueDate) && scriptRecurrence.equals(that.scriptRecurrence) && medicineID.equals(that.medicineID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scriptRef, scriptIssueDate, scriptRecurrence, medicineID);
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "scriptRef='" + scriptRef + '\'' +
                ", scriptIssueDate='" + scriptIssueDate + '\'' +
                ", scriptRecurrence='" + scriptRecurrence + '\'' +
                ", medicineID=" + medicineID +
                '}';
    }
}
