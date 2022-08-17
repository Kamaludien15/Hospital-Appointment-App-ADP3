/* AppointmentFactoryTest.java
 Testing class for AppointmentFactoryTest
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/
package za.ac.cput.service;

import za.ac.cput.domain.HospitalLocation;

import java.util.List;

public interface IHospitalLocationService extends IService<HospitalLocation, String>{

    public List<HospitalLocation> getAll();

}
