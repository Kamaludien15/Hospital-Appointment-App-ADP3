package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Medicine;
import za.ac.cput.service.MedicineService;

import java.util.List;
import java.util.Optional;

@Component
public class MedicineAPI {
    private final MedicineService medicineService;

    @Autowired
    public MedicineAPI(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    public Medicine save(Medicine medicine) {
        return this.medicineService.save(medicine);
    }

    public Optional<Medicine> read(String id) {
        return this.medicineService.read(id);
    }

    public void delete(Medicine medicine) {
        this.medicineService.delete(medicine);
    }

    public List<Medicine> getAll() {
        return this.medicineService.getAll();
    }
}
