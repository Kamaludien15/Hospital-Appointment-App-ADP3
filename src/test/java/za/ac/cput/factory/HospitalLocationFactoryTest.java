/* HospitalLocationFactoryTest.java
 Testing class for HospitalLocationFactory
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.HospitalLocation;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

class HospitalLocationFactoryTest {

    //Testing Builder class for HospitalLocation entity
    @Test
    public void HospitalLocationTest(){
        HospitalLocation hospitalLocation = new HospitalLocation.Builder()
                .setHospitalID(Helper.generateID())
                .setLocationID(Helper.generateID())
                .build();
        assertNotNull(hospitalLocation);
    }

    //Testing creation of HospitalLocation entity with HospitalLocationFactory
    @Test
    public void HospitalLocationFactoryTest(){

        HospitalLocation hospitalLocation = HospitalLocationFactory.createHospitalLocation(Helper.generateID(), Helper.generateID());
        assertNotNull(hospitalLocation);
    }

}