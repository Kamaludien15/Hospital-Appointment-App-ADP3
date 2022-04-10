/* HospitalLocationFactory.java
 Factory for the HospitalLocation Class
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/

package za.ac.cput.factory;

import za.ac.cput.entity.HospitalLocation;
import za.ac.cput.util.Helper;

public class HospitalLocationFactory {

    public static HospitalLocation createHospitalLocation(String hospitalID, String locationID){

        HospitalLocation hospitalLocation = new HospitalLocation.Builder()
                .setHospitalID(hospitalID)
                .setLocationID(locationID)
                .build();

        return hospitalLocation;
    }

}
