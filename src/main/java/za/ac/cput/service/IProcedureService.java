/*
 * IProcedureService.java
 * Procedure service interface for the Procedure
 * Author: Mogamad Githr Parker (220408025)
 * Date: 15 August 2022
 * */
package za.ac.cput.service;

import za.ac.cput.domain.Procedure;

import java.util.List;

public interface IProcedureService extends IService<Procedure, String> {
    List<Procedure> getAll();
}
