/*
 * Procedure.java
 * Entity for the Procedure
 * Author: Mogamad Githr Parker (220408025)
 * Date: 10 April 2022
 * */
package za.ac.cput.domain;

public class Procedure {
    private String procedureID, procedureName, procedureDescription, procedureCost;

    private Procedure(Builder builder) {
        this.procedureID = builder.procedureID;
        this.procedureName = builder.procedureName;
        this.procedureDescription = builder.procedureDescription;
        this.procedureCost = builder.procedureCost;
    }

    public String getProcedureID() {
        return procedureID;
    }

    public void setProcedureID(String procedureID) {
        this.procedureID = procedureID;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public String getProcedureDescription() {
        return procedureDescription;
    }

    public void setProcedureDescription(String procedureDescription) {
        this.procedureDescription = procedureDescription;
    }

    public String getProcedureCost() {
        return procedureCost;
    }

    public void setProcedureCost(String procedureCost) {
        this.procedureCost = procedureCost;
    }

    @Override
    public String toString() {
        return "Procedure{" +
                "procedureID='" + procedureID + '\'' +
                ", procedureName='" + procedureName + '\'' +
                ", procedureDescription='" + procedureDescription + '\'' +
                ", procedureCost='" + procedureCost + '\'' +
                '}';
    }

    public static class Builder {
        private String procedureID, procedureName, procedureDescription, procedureCost;

        public Builder setProcedureID(String procedureID) {
            this.procedureID = procedureID;
            return this;
        }

        public Builder setProcedureName(String procedureName) {
            this.procedureName = procedureName;
            return this;
        }

        public Builder setProcedureDescription(String procedureDescription) {
            this.procedureDescription = procedureDescription;
            return this;
        }

        public Builder setProcedureCost(String procedureCost) {
            this.procedureCost = procedureCost;
            return this;
        }

        public Builder copy(Procedure procedure) {
            this.procedureID = procedure.procedureID;
            this.procedureName = procedure.procedureName;
            this.procedureDescription = procedure.procedureDescription;
            this.procedureCost = procedure.procedureCost;
            return this;
        }

        public Procedure build() {
            return new Procedure(this);
        }
    }
}
