/* AddressAPI.java
 API for address controller
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.domain.Location;
import za.ac.cput.service.ILocationService;

import java.util.List;
import java.util.Optional;

@Component
public class LocationAPI {

    private final ILocationService locationService;

    @Autowired
    public LocationAPI(ILocationService locationService) {
        this.locationService = locationService;
    }

    public Location save(Location location) {
        return this.locationService.save(location);
    }

    public Optional<Location> read(String id) {
        return this.locationService.read(id);
    }

    public void delete(Location location) {
        this.locationService.delete(location);
    }


    public List<Location> getAll() {
        return this.locationService.getAll();
    }
}
