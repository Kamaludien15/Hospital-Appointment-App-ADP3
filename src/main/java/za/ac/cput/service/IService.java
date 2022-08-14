/* AppointmentFactoryTest.java
 Testing class for AppointmentFactoryTest
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/
package za.ac.cput.service;

import java.util.Optional;

public interface IService<T, ID>{
    public T save(T t);
    public Optional<T> read(ID id);
    public void delete(T t);
}
