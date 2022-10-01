package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.domain.Gender;
import za.ac.cput.service.IGenderService;

import java.util.List;
import java.util.Optional;

@Component
public class GenderAPI {

    private final IGenderService genderService;

    @Autowired
    public GenderAPI(IGenderService genderService) {
        this.genderService = genderService;
    }

    public Gender save(Gender gender) {
        return this.genderService.save(gender);
    }

    public Optional<Gender> read(String id) {
        return this.genderService.read(id);
    }

    public void delete(Gender gender) {
        this.genderService.delete(gender);
    }


    public List<Gender> getAll() {
        return this.genderService.getAll();
    }
}
