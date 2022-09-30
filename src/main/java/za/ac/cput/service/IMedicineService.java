/*
 * IMedicineService.java
 * Medicine service interface for the Medicine
 * Author: Mogamad Githr Parker (220408025)
 * Date: 15 August 2022
 * */
package za.ac.cput.service;

import za.ac.cput.domain.Medicine;

import java.util.List;

public interface IMedicineService extends IService<Medicine, String> {
    List<Medicine> getAll();
    Medicine findByName(String name);
}
