package za.ac.cput.impl;

/**
 *
 * Rhegan Albert Fortuin
 * 219273693
 * Patient entity
 * 07 April 2022
 *
 */

import za.ac.cput.entity.patient;
import za.ac.cput.repository.IRepository;

import java.util.HashSet;
import java.util.Set;

public class patientRepositoryImpl implements IRepository<patient, String>{
    private static patientRepositoryImpl repository = null;
    private Set<patient> patientDB = null;

    private patientRepositoryImpl(){
        patientDB = new HashSet<patient>();
    }

    public static patientRepositoryImpl getRepository(){
        if(repository == null){
            repository = new patientRepositoryImpl();
        }
        return repository;
    }

    @Override
    public patient create(patient patient) {
        boolean success = patientDB.add(patient);
        if(!success){
            return null;
        }
        return patient;
    }

    @Override
    public patient read(String s) {
        patient patient = patientDB.stream()
                .filter(e -> e.getPatientID().equals(s))
                .findAny()
                .orElse(null);
        return patient;
    }

    @Override
    public patient update(patient patient) {
        patient oldPatient = read(patient.getPatientID());
        if(oldPatient != null){
            patientDB.remove(oldPatient);
            patientDB.add(patient);
            return patient;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        patient patientToDelete = read(s);
        if (patientToDelete == null){
            return false;
        }

        patientDB.remove(patientToDelete);
        return true;
    }
}
