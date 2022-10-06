/*
 * MedicineServiceTest.java
 * Service test for the Medicine
 * Author: Mogamad Githr Parker (220408025)
 * Date: 16 August 2022
 * */
package za.ac.cput.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Medicine;
import za.ac.cput.factory.MedicineFactory;
import za.ac.cput.service.MedicineService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MedicineServiceTest {
    @Autowired
    private MedicineService medicineService;
    private static Medicine medicine = MedicineFactory.createMedicine("Ibuprofen", "100ml",
            "5ml", "R150.00");

    @Test
    void save() {
        Medicine saved = medicineService.save(medicine);
        assertNotNull(saved);
        System.out.println(saved);
    }

    @Test
    void read() {
        Medicine saved = medicineService.save(medicine);
        Optional<Medicine> read = medicineService.read(saved.getMedicineID());
        assertEquals(read.get().getMedicineID(), saved.getMedicineID());
        System.out.println(read);
    }

    @Test
    void delete() {
        Medicine saved = medicineService.save(medicine);
        medicineService.delete(saved);
        List<Medicine> medicines = medicineService.getAll();
        assertEquals(0, medicines.size());
    }

    @Test
    void getAll() {
        medicineService.save(medicine);
        List<Medicine> medicineList = medicineService.getAll();
        assertEquals(1, medicineList.size());
    }

//    @Test
//    void findByName() {
//        Medicine saved = medicineService.save(medicine);
//        Medicine readName = medicineService.findByName(saved.getMedicineName());
//        assertEquals(readName.getMedicineName(), saved.getMedicineName());
//    }
}