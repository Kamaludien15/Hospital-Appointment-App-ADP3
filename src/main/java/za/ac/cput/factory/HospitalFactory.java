/* AppointmentFactory.java
 Factory for the Hospital Class
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/

package za.ac.cput.factory;

import za.ac.cput.domain.Hospital;
import za.ac.cput.util.Helper;

public class HospitalFactory {

    public static Hospital createHospital(String hospitalName, int hospitalCapacity, String hospitalSector){

        //-----Checking for empty or null variables------
        if(Helper.isEmptyOrNull(hospitalName) || Helper.isEmptyOrNull(hospitalSector))
            return null;

        //-----Generating AppointmentID-----
        String hospitalID = Helper.generateID();

        Hospital hospital = new Hospital.Builder()
                .setHospitalID(hospitalID)
                .setHospitalName(hospitalName)
                .setHospitalCapacity(hospitalCapacity)
                .setHospitalSector(hospitalSector)
                .build();

        return hospital;
    }

}
