/* AppointmentFactoryTest.java
 Testing class for AppointmentFactoryTest
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/
package za.ac.cput.service;

import za.ac.cput.domain.Location;

import java.util.List;

public interface ILocationService extends IService<Location, String>{

    public List<Location> getAll();

}