package za.ac.cput.repository;

import za.ac.cput.domain.Prescription;

import java.util.Set;

public interface IPrescriptionRepository extends IRepository<Prescription, String> {
    public Set<Prescription> getAll();
}
