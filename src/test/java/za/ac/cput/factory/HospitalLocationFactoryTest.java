/* HospitalLocationFactoryTest.java
 Testing class for HospitalLocationFactory
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Hospital;
import za.ac.cput.domain.HospitalLocation;
import za.ac.cput.domain.Location;

import static org.junit.jupiter.api.Assertions.*;

class HospitalLocationFactoryTest {

    Hospital hospital = HospitalFactory.createHospital("Spring View Hospital", 1000, "Public");
    Location location = LocationFactory.createLocation("Johnson", 9, "Wynberg", 4500);

    //Testing Builder class for HospitalLocation entity
    @Test
    public void HospitalLocationTest(){
        HospitalLocation hospitalLocation = new HospitalLocation.Builder()
                .setHospital(hospital)
                .setLocation(location)
                .build();
        assertNotNull(hospitalLocation);
    }

    //Testing creation of HospitalLocation entity with HospitalLocationFactory
    @Test
    public void HospitalLocationFactoryTest(){

        HospitalLocation hospitalLocation = HospitalLocationFactory.createHospitalLocation(hospital,location);
        assertNotNull(hospitalLocation);
    }

}