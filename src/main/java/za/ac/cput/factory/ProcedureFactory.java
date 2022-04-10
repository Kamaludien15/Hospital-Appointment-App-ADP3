/*
 * ProcedureFactory.java
 * Factory for the Procedure
 * Author: Mogamad Githr Parker (220408025)
 * Date: 10 April 2022
 * */
package za.ac.cput.factory;

import za.ac.cput.entity.Procedure;

public class ProcedureFactory {
    public static Procedure createProcedure(String procedureID, String procedureName, String procedureDescription, String procedureCost) {
        return new Procedure.Builder().setProcedureID(procedureID).setProcedureName(procedureName).setProcedureDescription(procedureDescription).setProcedureCost(procedureCost).build();
    }
}
