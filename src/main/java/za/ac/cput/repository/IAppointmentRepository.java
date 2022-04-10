/* IAppointmentRepository.java
 Interface for the Appointment Repository Class
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/

package za.ac.cput.repository;

import za.ac.cput.entity.Appointment;

import java.util.Set;

public interface IAppointmentRepository extends IRepository<Appointment, String>{

    public Set<Appointment> getAll();

}
