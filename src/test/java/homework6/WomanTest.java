package homework6;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WomanTest {
    Man simpleFather;
    Woman simpleMother;
    Family simpleFamily;
    Woman karen;
    Man hank;
    Family moodies;


    @BeforeEach
    void setUp() {
        simpleFather = new Man("", "", (short) 0);
        simpleMother = new Woman("", "", (short) 0);
        simpleFamily = new Family(simpleMother, simpleFather);
        karen = new Woman("Karen", "Van der Beek",
                (short) 1981, (byte) 127,
                new String[][] {}, simpleFamily, new Dog(""), simpleMother, simpleFather);
        hank = new Man("Hank", "Moody", (short) 1980, (byte) 27,
                new String[][] {}, simpleFamily, new Dog(""), simpleMother, simpleFather);
        moodies = new Family(karen, hank);
    }

    @AfterEach
    void tearDown() {
        simpleFather = null;
        simpleMother = null;
        simpleFamily = null;
        karen = null;
        hank = null;
        moodies = null;
    }

    @DisplayName("bornChild() should return non-null child of correct type")
    @Test
    void bornChildReturnsManOrWoman() {
        Human child = karen.bornChild();
        assertNotNull(child);
        assertTrue(child instanceof Man || child instanceof Woman);
    }

    @Test
    void bornChildHasCorrectSurnameAndIq() {
        Human child = karen.bornChild();

        assertNotNull(child);
        assertEquals(hank.getSurname(), child.getSurname());
        assertEquals((byte) ((karen.getIq() + hank.getIq()) / 2), child.getIq());
    }
}
