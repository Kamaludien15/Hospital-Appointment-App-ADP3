/*
 * PrescriptionRepositoryImpl.java
 * Repository for the Prescription
 * Author: Mogamad Githr Parker (220408025)
 * Date: 10 April 2022
 * */
package za.ac.cput.impl;

import za.ac.cput.entity.Prescription;
import za.ac.cput.repository.IPrescriptionRepository;

import java.util.HashSet;
import java.util.Set;

public class PrescriptionRepositoryImpl implements IPrescriptionRepository {
    private static PrescriptionRepositoryImpl repository = null;
    private Set<Prescription> prescriptionDB = null;

    private PrescriptionRepositoryImpl() {
        prescriptionDB = new HashSet<Prescription>();
    }

    public static PrescriptionRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new PrescriptionRepositoryImpl();
        }

        return repository;
    }

    @Override
    public Prescription create(Prescription prescription) {
        boolean success = prescriptionDB.add(prescription);
        if (!success)
            return null;
        return prescription;
    }

    @Override
    public Prescription read(String scriptRef) {
        for (Prescription pres : prescriptionDB) {
            if (pres.getScriptRef().equals(scriptRef))
                return pres;
        }

        return null;
    }

    @Override
    public Prescription update(Prescription prescription) {
        Prescription oldPrescription = read(prescription.getScriptRef());
        if (oldPrescription != null) {
            prescriptionDB.remove(oldPrescription);
            prescriptionDB.add(prescription);
            return prescription;
        }

        return null;
    }

    @Override
    public boolean delete(String scriptRef) {
        Prescription prescriptionToDelete = read(scriptRef);
        if (prescriptionToDelete == null) {
            return false;
        }

        prescriptionDB.remove(prescriptionToDelete);
        return true;
    }

    @Override
    public Set<Prescription> getAll() {
        return prescriptionDB;
    }
}
