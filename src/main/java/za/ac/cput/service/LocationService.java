/* AppointmentFactoryTest.java
 Testing class for AppointmentFactoryTest
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/
package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Location;
import za.ac.cput.factory.LocationFactory;
import za.ac.cput.repository.ILocationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService implements ILocationService{

    private static ILocationRepository repository = null;

    @Autowired
    private LocationService(ILocationRepository locationRepository){
        this.repository = locationRepository;
    }

    @Override
    public Location save(Location location) {
        return this.repository.save(location);
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
