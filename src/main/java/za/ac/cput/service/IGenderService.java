/**
 * Rhegan Albert Fortuin
 * 219273693
 * IGenderService
 * 15 August 2022
 */

package za.ac.cput.service;

import za.ac.cput.domain.Gender;
import java.util.List;

public interface IGenderService extends IService<Gender, String>{

    public List<Gender> getAll();
}
