/*
 * IPrescriptionService.java
 * Prescription service interface for the Prescription
 * Author: Mogamad Githr Parker (220408025)
 * Date: 15 August 2022
 * */
package za.ac.cput.service;

import za.ac.cput.domain.Prescription;

import java.util.List;

public interface IPrescriptionService extends IService<Prescription, String> {
    List<Prescription> getAll();
}
