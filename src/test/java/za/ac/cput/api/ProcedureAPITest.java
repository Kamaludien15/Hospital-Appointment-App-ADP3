package za.ac.cput.api;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Procedure;
import za.ac.cput.factory.ProcedureFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ProcedureAPITest {

    @Autowired
    private ProcedureAPI procedureAPI;
    private Procedure procedure;

    @BeforeEach
    void setUp() {
        this.procedure = ProcedureFactory.createProcedure("Hip Surgery", "Hip Replacement Surgery", "45000.00");
    }

    @AfterEach
    void tearDown() {
        this.procedureAPI.delete(this.procedure);
    }

    @Test
    void a_save() {
        Procedure saved = this.procedureAPI.save(this.procedure);
        assertNotNull(saved);
        assertSame(this.procedure.getProcedureID(), saved.getProcedureID());
    }

    @Test
    void b_read() {
        Procedure saved = this.procedureAPI.save(this.procedure);
        Optional<Procedure> read = this.procedureAPI.read(saved.getProcedureID());
        assertNotNull(read);
    }

    @Test
    void c_delete() {
        Procedure saved = this.procedureAPI.save(this.procedure);
        this.procedureAPI.save(this.procedure);
        int before = this.procedureAPI.getAll().size();
        this.procedureAPI.delete(saved);
        before = before -1;
        assertEquals(before, this.procedureAPI.getAll().size());
    }

    @Test
    void d_getAll() {
        this.procedureAPI.save(this.procedure);
        assertNotEquals(0, this.procedureAPI.getAll().size());
    }
}