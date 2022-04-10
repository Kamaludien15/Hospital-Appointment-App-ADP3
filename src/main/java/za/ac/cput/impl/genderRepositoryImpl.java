package za.ac.cput.impl;

/**
 *
 * Rhegan Albert Fortuin
 * 219273693
 * Patient entity
 * 07 April 2022
 *
 */

import za.ac.cput.entity.Appointment;
import za.ac.cput.entity.gender;
import za.ac.cput.entity.patient;
import za.ac.cput.entity.patientGender;
import za.ac.cput.repository.IRepository;

import java.util.HashSet;
import java.util.Set;

public class genderRepositoryImpl implements IRepository<gender, String>{
    private static genderRepositoryImpl repository = null;
    private Set<gender> genderDB = null;

    private genderRepositoryImpl(){
        genderDB = new HashSet<gender>();
    }

    public static genderRepositoryImpl getRepository(){
        if(repository == null){
            repository = new genderRepositoryImpl();
        }
        return repository;
    }

    @Override
    public gender create(gender gender) {
        boolean success = genderDB.add(gender);
        if(!success){
            return null;
        }
        return gender;
    }

    @Override
    public gender read(String s) {
        gender gender = genderDB.stream()
                .filter(e -> e.getGenderID().equals(s))
                .findAny()
                .orElse(null);
        return gender;
    }

    @Override
    public gender update(gender gender) {
        gender oldGender = read(gender.getGenderID());
        if(oldGender != null){
            genderDB.remove(oldGender);
            genderDB.add(gender);
            return gender;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        gender genderDBToDelete = read(s);
        if (genderDBToDelete == null){
            return false;
        }

        genderDB.remove(genderDBToDelete);
        return true;
    }
}
