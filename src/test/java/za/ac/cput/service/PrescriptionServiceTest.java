/*
 * PrescriptionServiceTest.java
 * Service test for the Prescription
 * Author: Mogamad Githr Parker (220408025)
 * Date: 16 August 2022
 * */
package za.ac.cput.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Medicine;
import za.ac.cput.domain.Prescription;
import za.ac.cput.factory.MedicineFactory;
import za.ac.cput.factory.PrescriptionFactory;
import za.ac.cput.service.PrescriptionService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PrescriptionServiceTest {
    @Autowired private PrescriptionService prescriptionService;
    @Autowired private MedicineService medicineService;
    private static Medicine medicine = MedicineFactory.createMedicine("Ibuprofen", "100ml",
            "5ml", "R150.00");
    private static Prescription prescription = PrescriptionFactory.createPrescription(medicine,
            "10/08/2022", "1 monthly");

    @Test
    void save() {
        Medicine savedMedicine = medicineService.save(medicine);
        Prescription saved = prescriptionService.save(prescription);
        assertNotNull(saved);
        System.out.println(saved);
    }

    @Test
    void read() {
        Medicine savedMedicine = medicineService.save(medicine);
        Prescription saved = prescriptionService.save(prescription);
        Optional<Prescription> read = prescriptionService.read(saved.getScriptRef());
        assertEquals(read.get().getScriptRef(), saved.getScriptRef());
        System.out.println(read);
    }

    @Test
    void delete() {
        Medicine savedMedicine = medicineService.save(medicine);
        Prescription saved = prescriptionService.save(prescription);
        prescriptionService.delete(saved);
        List<Prescription> prescriptions = prescriptionService.getAll();
        assertEquals(0, prescriptions.size());
    }

    @Test
    void getAll() {
        Medicine savedMedicine = medicineService.save(medicine);
        Prescription saved = prescriptionService.save(prescription);
        List<Prescription> prescriptionList = prescriptionService.getAll();
        assertEquals(1, prescriptionList.size());
    }
}