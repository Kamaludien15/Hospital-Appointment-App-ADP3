package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Gender;
import za.ac.cput.factory.GenderFactory;
import za.ac.cput.repository.IGenderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GenderService implements IGenderService{

    private static IGenderRepository repository = null;

    @Autowired
    private GenderService(IGenderRepository genderRepository){
        this.repository = genderRepository;
    }

    @Override
    public Gender save(Gender gender) {
        Gender obj = GenderFactory.createGender(gender.getName(), gender.getDescription(), gender.getSex());
        return this.repository.save(obj);
    }

    @Override
    public Optional<Gender> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Gender gender) {
        this.repository.delete(gender);
    }

    @Override
    public List<Gender> getAll() {
        return this.repository.findAll();
    }
}
