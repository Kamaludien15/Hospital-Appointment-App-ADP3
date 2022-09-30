package za.ac.cput.service;

import za.ac.cput.domain.Gender;
import java.util.List;

public interface IGenderService extends IService<Gender, String>{
    public List<Gender> getAll();
}
