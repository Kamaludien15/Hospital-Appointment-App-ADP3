/* HospitalLocationFactory.java
 Factory for the HospitalLocation Class
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/

package za.ac.cput.factory;

import za.ac.cput.domain.Hospital;
import za.ac.cput.domain.HospitalLocation;
import za.ac.cput.domain.Location;
import za.ac.cput.util.Helper;

public class HospitalLocationFactory {

    public static HospitalLocation createHospitalLocation(Hospital hospital, Location location){

        //-----Generating HospitalLocationID-----
        String hospitalLocationID = Helper.generateID();

        HospitalLocation hospitalLocation = new HospitalLocation.Builder()
                .setHospitalLocationId(hospitalLocationID)
                .setHospital(hospital)
                .setLocation(location)
                .build();

        return hospitalLocation;
    }

}
