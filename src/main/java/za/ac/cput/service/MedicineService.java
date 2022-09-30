/*
 * MedicineService.java
 * Medicine service for the Medicine
 * Author: Mogamad Githr Parker (220408025)
 * Date: 15 August 2022
 * */
package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Medicine;
import za.ac.cput.repository.IMedicineRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineService implements IMedicineService {
    private IMedicineRepository repository;

    @Autowired
    MedicineService(IMedicineRepository medicineRepository) {
        this.repository = medicineRepository;
    }

    @Override
    public Medicine save(Medicine medicine) {
        return this.repository.save(medicine);
    }

    @Override
    public Optional<Medicine> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Medicine medicine) {
        this.repository.delete(medicine);
    }

    @Override
    public List<Medicine> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Medicine findByName(String name) {
        return this.repository.findByMedicineName(name);
    }
}
