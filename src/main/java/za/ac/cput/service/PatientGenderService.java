package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.factory.LocationFactory;
import za.ac.cput.repository.ILocationRepository;
import za.ac.cput.repository.IPatientGenderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PatientGenderService implements IPatientGender{

    private static IPatientGenderRepository repository = null;

    @Autowired
    private LocationService(ILocationRepository locationRepository){
        this.repository = locationRepository;
    }

    @Override
    public Location save(Location location) {
        Location obj = LocationFactory.createLocation(location.getStreetName(), location.getStreetNum(), location.getSuburb(), location.getPostalCode());
        return this.repository.save(obj);
    }

    @Override
    public Optional<Location> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Location location) {
        this.repository.delete(location);
    }

    @Override
    public List<Location> getAll() {
        return this.repository.findAll();
    }
}
