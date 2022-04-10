/*
 * Prescription.java
 * Entity for the Prescription
 * Author: Mogamad Githr Parker (220408025)
 * Date: 10 April 2022
 * */
package za.ac.cput.domain;

public class Prescription {
    private String scriptRef, medicineID, scriptIssueDate, scriptRecurrence;

    private Prescription(Builder builder) {
        this.scriptRef = builder.scriptRef;
        this.medicineID = builder.medicineID;
        this.scriptIssueDate = builder.scriptIssueDate;
        this.scriptRecurrence = builder.scriptRecurrence;
    }

    public String getScriptRef() {
        return scriptRef;
    }

    public void setScriptRef(String scriptRef) {
        this.scriptRef = scriptRef;
    }

    public String getMedicineID() {
        return medicineID;
    }

    public void setMedicineID(String medicineID) {
        this.medicineID = medicineID;
    }

    public String getScriptIssueDate() {
        return scriptIssueDate;
    }

    public void setScriptIssueDate(String scriptIssueDate) {
        this.scriptIssueDate = scriptIssueDate;
    }

    public String getScriptRecurrence() {
        return scriptRecurrence;
    }

    public void setScriptRecurrence(String scriptRecurrence) {
        this.scriptRecurrence = scriptRecurrence;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "scriptRef='" + scriptRef + '\'' +
                ", medicineID='" + medicineID + '\'' +
                ", scriptIssueDate='" + scriptIssueDate + '\'' +
                ", scriptRecurrence='" + scriptRecurrence + '\'' +
                '}';
    }

    public static class Builder {
        private String scriptRef, medicineID, scriptIssueDate, scriptRecurrence;

        public Builder setScriptRef(String scriptRef) {
            this.scriptRef = scriptRef;
            return this;
        }

        public Builder setMedicineID(String medicineID) {
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
}
