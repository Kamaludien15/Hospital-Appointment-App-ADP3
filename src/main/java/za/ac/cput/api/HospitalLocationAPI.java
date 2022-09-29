/* AddressAPI.java
 API for address controller
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Appointment;
import za.ac.cput.domain.HospitalLocation;
import za.ac.cput.service.IAppointmentService;
import za.ac.cput.service.IHospitalLocationService;
import za.ac.cput.service.IHospitalService;
import za.ac.cput.service.ILocationService;

import java.util.List;
import java.util.Optional;

@Component
public class HospitalLocationAPI {

    private final IHospitalLocationService hospitalLocationService;
    private final ILocationService locationService;
    private final IHospitalService hospitalService;

    @Autowired
    public HospitalLocationAPI(IHospitalLocationService hospitalLocationService, IHospitalService hospitalService, ILocationService locationService) {
        this.hospitalLocationService = hospitalLocationService;
        this.locationService = locationService;
        this.hospitalService = hospitalService;
    }


    public HospitalLocation save(HospitalLocation hospitalLocation) {
        this.locationService.read(hospitalLocation.getLocation().getLocationID()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Location not found"));
        this.hospitalService.read(hospitalLocation.getHospital().getHospitalID()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hospital not found"));
        return this.hospitalLocationService.save(hospitalLocation);
    }

    public Optional<HospitalLocation> read(String id) {
        return this.hospitalLocationService.read(id);
    }

    public void delete(HospitalLocation hospitalLocation) {
        this.hospitalLocationService.delete(hospitalLocation);
    }


    public List<HospitalLocation> getAll() {
        return this.hospitalLocationService.getAll();
    }
}
