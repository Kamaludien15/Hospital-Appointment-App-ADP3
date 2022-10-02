package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Procedure;
import za.ac.cput.service.ProcedureService;

import java.util.List;
import java.util.Optional;

@Component
public class ProcedureAPI {
    private final ProcedureService procedureService;

    @Autowired
    public ProcedureAPI(ProcedureService procedureService) {
        this.procedureService = procedureService;
    }

    public Procedure save(Procedure procedure) {
        this.procedureService.read(procedure.getProcedureID()).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Procedure Not Found"));

        return this.procedureService.save(procedure);
    }

    public Optional<Procedure> read(String id) {
        return this.procedureService.read(id);
    }

    public void delete(Procedure procedure) {
        this.procedureService.delete(procedure);
    }

    public List<Procedure> getAll() {
        return this.procedureService.getAll();
    }
}
