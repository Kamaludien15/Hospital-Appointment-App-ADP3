/*
 * MedicineRepositoryImpl.java
 * Repository for the Medicine
 * Author: Mogamad Githr Parker (220408025)
 * Date: 10 April 2022
 * */
package za.ac.cput.impl;

import za.ac.cput.entity.Medicine;
import za.ac.cput.repository.IRepository;

import java.util.HashSet;
import java.util.Set;

public class MedicineRepositoryImpl implements IRepository<Medicine, String> {
    private static MedicineRepositoryImpl repository = null;
    private Set<Medicine> medicineDB = null;

    private MedicineRepositoryImpl() {
        medicineDB = new HashSet<Medicine>();
    }

    public static MedicineRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new MedicineRepositoryImpl();
        }

        return repository;
    }

    @Override
    public Medicine create(Medicine medicine) {
        boolean success = medicineDB.add(medicine);
        if (!success) {
            return null;
        }

        return medicine;
    }

    @Override
    public Medicine read(String medicineID) {
        for (Medicine m : medicineDB) {
            if (m.getMedicineID().equals(medicineID))
                return m;
        }

        return null;
    }

    @Override
    public Medicine update(Medicine medicine) {
        Medicine oldMedicine = read(medicine.getMedicineID());
        if (oldMedicine != null) {
            medicineDB.remove(oldMedicine);
            medicineDB.add(medicine);
            return medicine;
        }

        return null;
    }

    @Override
    public boolean delete(String medicineID) {
        Medicine medicineToDelete = read(medicineID);
        if (medicineToDelete == null) {
            return false;
        }

        medicineDB.remove(medicineToDelete);
        return true;
    }
}
