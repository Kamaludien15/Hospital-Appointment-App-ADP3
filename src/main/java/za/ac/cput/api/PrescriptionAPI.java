package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Prescription;
import za.ac.cput.service.PrescriptionService;

import java.util.List;
import java.util.Optional;

@Component
public class PrescriptionAPI {
    private final PrescriptionService prescriptionService;

    @Autowired
    public PrescriptionAPI(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    public Prescription save(Prescription prescription) {
        this.prescriptionService.read(prescription.getScriptRef()).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Prescription Not Found"));

        return this.prescriptionService.save(prescription);
    }

    public Optional<Prescription> read(String id) {
        return this.prescriptionService.read(id);
    }

    public void delete(Prescription prescription) {
        this.prescriptionService.delete(prescription);
    }

    public List<Prescription> getAll() {
        return this.prescriptionService.getAll();
    }
}
