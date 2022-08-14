package za.ac.cput.impl;

/**
 *
 * Rhegan Albert Fortuin
 * 219273693
 * Patient entity
 * 07 April 2022
 *
 */

import za.ac.cput.entity.patientGender;
import za.ac.cput.repository.IRepository;

import java.util.HashSet;
import java.util.Set;

public class patientGenderRepositoryImpl implements IRepository<patientGender, String>{
    private static patientGenderRepositoryImpl repository = null;
    private Set<patientGender> patientGenderDB = null;

    private patientGenderRepositoryImpl(){
        patientGenderDB = new HashSet<patientGender>();
    }

    public static patientGenderRepositoryImpl getRepository(){
        if(repository == null){
            repository = new patientGenderRepositoryImpl();
        }
        return repository;
    }

    @Override
    public patientGender create(patientGender patientGender) {
        boolean success = patientGenderDB.add(patientGender);
        if(!success){
            return null;
        }
        return patientGender;
    }

    @Override
    public patientGender read(String s) {
        patientGender patientGender = patientGenderDB.stream()
                .filter(e -> e.getPatientID().equals(s))
                .findAny()
                .orElse(null);
        return patientGender;
    }

    @Override
    public patientGender update(patientGender patientGender) {
        patientGender oldPatientGender = read(patientGender.getPatientID());
        if(oldPatientGender != null){
            patientGenderDB.remove(oldPatientGender);
            patientGenderDB.add(patientGender);
            return patientGender;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        patientGender patientGenderToDelete = read(s);
        if (patientGenderToDelete == null) {
            return false;
        }

        patientGenderDB.remove(patientGenderToDelete);
        return true;
    }
}
