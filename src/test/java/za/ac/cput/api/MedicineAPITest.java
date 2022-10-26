package za.ac.cput.api;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Medicine;
import za.ac.cput.factory.MedicineFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class MedicineAPITest {

    @Autowired
    private MedicineAPI medicineAPI;
    private Medicine medicine;

    @BeforeEach
    void setUp() {
        this.medicine = MedicineFactory.createMedicine("Acetaminophen", "15ml", "325mg", "100.00");
    }

    @AfterEach
    void tearDown() {
        this.medicineAPI.delete(this.medicine);
    }

    @Test
    void a_save() {
        Medicine saved = this.medicineAPI.save(this.medicine);
        assertNotNull(saved);
        assertSame(this.medicine.getMedicineID(), saved.getMedicineID());
    }

    @Test
    void b_read() {
        Medicine saved = this.medicineAPI.save(this.medicine);
        Optional<Medicine> read = this.medicineAPI.read(saved.getMedicineID());
        assertNotNull(read);
    }

    @Test
    void c_delete() {
        Medicine saved = this.medicineAPI.save(this.medicine);
        int before = this.medicineAPI.getAll().size();
        this.medicineAPI.delete(saved);
        before = before - 1;
        assertEquals(before, this.medicineAPI.getAll().size());
    }

    @Test
    void d_getAll() {
        this.medicineAPI.save(this.medicine);
        assertNotEquals(0, this.medicineAPI.getAll().size());
    }
}