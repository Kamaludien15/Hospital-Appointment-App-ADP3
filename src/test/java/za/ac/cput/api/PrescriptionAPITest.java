package za.ac.cput.api;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Medicine;
import za.ac.cput.domain.Prescription;
import za.ac.cput.factory.MedicineFactory;
import za.ac.cput.factory.PrescriptionFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class PrescriptionAPITest {

    @Autowired
    private PrescriptionAPI prescriptionAPI;
    @Autowired
    private MedicineAPI medicineAPI;
    private Prescription prescription;
    private Medicine medicine;

    @BeforeEach
    void setUp() {
        this.medicine = MedicineFactory.createMedicine("Acetaminophen", "15ml", "325mg", "100.00");
        this.prescription = PrescriptionFactory.createPrescription(this.medicine, "12/12/2021", "monthly");
        this.medicineAPI.save(this.medicine);
    }

    @AfterEach
    void tearDown() {
        this.prescriptionAPI.delete(this.prescription);
        this.medicineAPI.delete(this.medicine);
    }

    @Test
    void a_save() {
        Prescription saved = this.prescriptionAPI.save(this.prescription);
        assertNotNull(saved);
        assertSame(this.prescription.getScriptRef(), saved.getScriptRef());
    }

    @Test
    void b_read() {
        Prescription saved = this.prescriptionAPI.save(this.prescription);
        Optional<Prescription> read = this.prescriptionAPI.read(saved.getScriptRef());
        assertNotNull(read);
        assertSame(saved.getScriptRef(), read.get().getScriptRef());
    }

    @Test
    void c_delete() {
        Prescription saved = this.prescriptionAPI.save(this.prescription);
        int before = this.prescriptionAPI.getAll().size();
        this.prescriptionAPI.delete(saved);
        before = before - 1;
        List<Prescription> prescriptionList = this.prescriptionAPI.getAll();
        assertEquals(before, prescriptionList.size());
    }

    @Test
    void d_getAll() {
        this.prescriptionAPI.save(this.prescription);
        assertNotEquals(0, this.prescriptionAPI.getAll().size());
    }
}