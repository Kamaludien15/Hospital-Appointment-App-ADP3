/*
 * ProcedureFactory.java
 * Factory for the Procedure
 * Author: Mogamad Githr Parker (220408025)
 * Date: 10 April 2022
 * */
package za.ac.cput.factory;

import za.ac.cput.domain.Procedure;
import za.ac.cput.util.Helper;

public class ProcedureFactory {
    public static Procedure createProcedure(String procedureName, String procedureDescription, String procedureCost) {
        String procedureID = Helper.generateID();

        if (Helper.isEmptyOrNull(procedureName) || Helper.isEmptyOrNull(procedureDescription) ||
                Helper.isEmptyOrNull(procedureCost))
            throw new IllegalArgumentException();

        return new Procedure.Builder().setProcedureID(procedureID).setProcedureName(procedureName).
                setProcedureDescription(procedureDescription).setProcedureCost(procedureCost).build();
    }
}
