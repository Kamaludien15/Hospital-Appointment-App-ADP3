/*
 * ProcedureRepositoryImpl.java
 * Repository for the Procedure
 * Author: Mogamad Githr Parker (220408025)
 * Date: 10 April 2022
 * */
package za.ac.cput.impl;

import za.ac.cput.domain.Medicine;
import za.ac.cput.domain.Procedure;
import za.ac.cput.repository.IRepository;

import java.util.HashSet;
import java.util.Set;

public class ProcedureRepositoryImpl implements IRepository<Procedure, String> {
    private static ProcedureRepositoryImpl repository = null;
    private Set<Procedure> procedureDB = null;

    private ProcedureRepositoryImpl() {
        procedureDB = new HashSet<Procedure>();
    }

    public static ProcedureRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new ProcedureRepositoryImpl();
        }

        return repository;
    }

    @Override
    public Procedure create(Procedure procedure) {
        boolean success = procedureDB.add(procedure);
        if (!success) {
            return null;
        }

        return procedure;
    }

    @Override
    public Procedure read(String procedureID) {
        for (Procedure proc : procedureDB) {
            if (proc.getProcedureID().equals(procedureID))
                return proc;
        }

        return null;
    }

    @Override
    public Procedure update(Procedure procedure) {
        Procedure oldProcedure = read(procedure.getProcedureID());
        if (oldProcedure != null) {
            procedureDB.remove(oldProcedure);
            procedureDB.add(procedure);
            return procedure;
        }

        return null;
    }

    @Override
    public boolean delete(String procedureID) {
        Procedure procedureToDelete = read(procedureID);
        if (procedureToDelete == null) {
            return false;
        }

        procedureDB.remove(procedureToDelete);
        return true;
    }
}
