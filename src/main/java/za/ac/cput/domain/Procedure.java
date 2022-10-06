/*
 * Procedure.java
 * Entity for the Procedure
 * Author: Mogamad Githr Parker (220408025)
 * Date: 10 April 2022
 * */
package za.ac.cput.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;


@Entity
@Table(name = "MEDICALPRO")
public class Procedure {
    @Id
    @Column(name = "procedure_id")
    private String procedureID;
    private String procedureName;
    private String procedureDescription;
    private String procedureCost;

    protected Procedure() {}

    private Procedure(Builder builder) {
        this.procedureID = builder.procedureID;
        this.procedureName = builder.procedureName;
        this.procedureDescription = builder.procedureDescription;
        this.procedureCost = builder.procedureCost;
    }

    public String getProcedureID() {
        return procedureID;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public String getProcedureDescription() {
        return procedureDescription;
    }

    public String getProcedureCost() {
        return procedureCost;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Procedure procedure = (Procedure) o;
        return procedureID.equals(procedure.procedureID) && procedureName.equals(procedure.procedureName) && procedureDescription.equals(procedure.procedureDescription) && procedureCost.equals(procedure.procedureCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(procedureID, procedureName, procedureDescription, procedureCost);
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
}
