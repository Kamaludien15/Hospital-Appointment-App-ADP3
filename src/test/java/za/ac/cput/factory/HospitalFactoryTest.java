/* HospitalFactoryTest.java
 Testing class for HospitalFactoryTest
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Hospital;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

class HospitalFactoryTest {

    //Testing Builder class for Hospital entity
    @Test
    public void HospitalTest(){
        Hospital hospital = new Hospital.Builder()
                .setHospitalID(Helper.generateID())
                .setHospitalName("Second Street Hospital")
                .setHospitalCapacity(200)
                .setHospitalSector("Public")
                .build();
        assertNotNull(hospital);
    }

    //Testing creation of Hospital entity with HospitalFactory
    @Test
    public void HospitalFactoryTest(){

        Hospital hospital = HospitalFactory.createHospital("Third Street Hospital", 100, "Private");
        assertNotNull(hospital);
    }



}