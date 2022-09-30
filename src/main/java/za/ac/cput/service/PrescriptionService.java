/*
 * PrescriptionService.java
 * Prescription service for the Prescription
 * Author: Mogamad Githr Parker (220408025)
 * Date: 15 August 2022
 * */
package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Prescription;
import za.ac.cput.repository.IPrescriptionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionService implements IPrescriptionService {
    private IPrescriptionRepository repository;

    @Autowired
    PrescriptionService(IPrescriptionRepository prescriptionRepository) {
        this.repository = prescriptionRepository;
    }

    @Override
    public Prescription save(Prescription prescription) {
        return this.repository.save(prescription);
    }

    @Override
    public Optional<Prescription> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Prescription prescription) {
        this.repository.delete(prescription);
    }

    @Override
    public List<Prescription> getAll() {
        return this.repository.findAll();
    }
}
