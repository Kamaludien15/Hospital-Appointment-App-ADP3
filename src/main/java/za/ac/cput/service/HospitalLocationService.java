/* AppointmentFactoryTest.java
 Testing class for AppointmentFactoryTest
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/
package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.HospitalLocation;
import za.ac.cput.factory.HospitalLocationFactory;
import za.ac.cput.repository.IHospitalLocationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalLocationService implements IHospitalLocationService{

    private static IHospitalLocationRepository repository = null;

    @Autowired
    private HospitalLocationService(IHospitalLocationRepository hospitalLocationRepository){
        this.repository = hospitalLocationRepository;
    }

    @Override
    public HospitalLocation save(HospitalLocation hospitalLocation) {
        HospitalLocation obj = HospitalLocationFactory.createHospitalLocation(hospitalLocation.getHospital(), hospitalLocation.getLocation());
        return this.repository.save(obj);
    }

    @Override
    public Optional<HospitalLocation> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(HospitalLocation hospitalLocation) {
        this.repository.delete(hospitalLocation);
    }

    @Override
    public List<HospitalLocation> getAll() {
        return this.repository.findAll();
    }
}
