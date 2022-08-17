/* LocationFactory.java
 Factory for the Location Class
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/

package za.ac.cput.factory;


import za.ac.cput.domain.Location;
import za.ac.cput.util.Helper;

public class LocationFactory {

    public static Location createLocation(String streetName, int streetNun, String suburb, int postalCode){

        //-----Checking for empty or null variables------
        if(Helper.isEmptyOrNull(streetName) || Helper.isEmptyOrNull(suburb))
            return null;

        //-----Generating AppointmentID-----
        String locationID = Helper.generateID();


        Location location = new Location.Builder()
                .setLocationID(locationID)
                .setStreetName(streetName)
                .setStreetNum(streetNun)
                .setSuburb(suburb)
                .setPostalCode(postalCode)
                .build();

        return location;
    }

}
