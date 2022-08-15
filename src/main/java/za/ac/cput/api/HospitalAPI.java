/* AddressAPI.java
 API for address controller
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.domain.Hospital;
import za.ac.cput.service.IHospitalService;

import java.util.List;
import java.util.Optional;

@Component
public class HospitalAPI {

    private final IHospitalService hospitalService;

    @Autowired
    public HospitalAPI(IHospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    public Hospital save(Hospital hospital) {
        return this.hospitalService.save(hospital);
    }

    public Optional<Hospital> read(String id) {
        return this.hospitalService.read(id);
    }

    public void delete(Hospital hospital) {
        this.hospitalService.delete(hospital);
    }


    public List<Hospital> getAll() {
        return this.hospitalService.getAll();
    }
}
