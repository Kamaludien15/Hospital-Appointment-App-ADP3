/* LocationFactoryTest.java
 Testing class for LocationFactory
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Location;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

class LocationFactoryTest {

    //Testing Builder class for Location entity
    @Test
    public void LocationTest(){
        Location location = new Location.Builder()
                .setLocationID(Helper.generateID())
                .setStreetName("Fifth Street")
                .setStreetNum(24)
                .setSuburb("Plumstead")
                .setPostalCode(7800)
                .build();
        assertNotNull(location);
    }

    //Testing creation of Location entity with LocationFactory
    @Test
    public void LocationFactoryTest(){

        Location location = LocationFactory.createLocation("Ninth Street", 60, "Wynberg", 6400);
        assertNotNull(location);
    }

}