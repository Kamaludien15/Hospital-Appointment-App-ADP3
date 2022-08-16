/*
 * ProcedureService.java
 * Procedure service for the Procedure
 * Author: Mogamad Githr Parker (220408025)
 * Date: 15 August 2022
 * */
package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Procedure;
import za.ac.cput.repository.IProcedureRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProcedureService implements IProcedureService {
    private IProcedureRepository repository;

    @Autowired
    ProcedureService(IProcedureRepository procedureRepository) {
        this.repository = procedureRepository;
    }

    @Override
    public Procedure save(Procedure procedure) {
        return this.repository.save(procedure);
    }

    @Override
    public Optional<Procedure> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Procedure procedure) {
        this.repository.delete(procedure);
    }

    @Override
    public List<Procedure> getAll() {
        return this.repository.findAll();
    }
}
