package homework5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {
    Human simpleHuman;
    Human humanAndParents;
    Human humanAllDataInit;
    Human humanAllDataVarName;
    Human humanAllDataVarSurname;
    Human humanAllDataVarYear;
    Human humanAllDataVarIq;
    Human humanAllDataVarSchedule;
    Human humanAllDataVarFamily;
    Human humanAllDataVarPet;
    Human humanAllDataVarMother;
    Human humanAllDataVarFather;
    @BeforeAll
    static void beforeAll() { System.out.println("Testing Human class..."); }

    @BeforeEach
    void setUp() {
        simpleHuman = new Human("", "", (short) 0);
        humanAndParents = new Human("", "", (short) 0, simpleHuman, simpleHuman);
        humanAllDataInit = new Human("", "", (short) 0, (byte) 0, new String[][]{},
                new Family(simpleHuman, simpleHuman), new Pet(), simpleHuman, simpleHuman);
        humanAllDataVarName = new Human("1", "", (short) 0, (byte) 0, new String[][]{},
                new Family(simpleHuman, simpleHuman), new Pet(), simpleHuman, simpleHuman);
        humanAllDataVarSurname = new Human("", "1", (short) 0, (byte) 0, new String[][]{},
                new Family(simpleHuman, simpleHuman), new Pet(), simpleHuman, simpleHuman);
        humanAllDataVarYear = new Human("", "", (short) 1, (byte) 0, new String[][]{},
                new Family(simpleHuman, simpleHuman), new Pet(), simpleHuman, simpleHuman);
        humanAllDataVarIq = new Human("", "", (short) 0, (byte) 1, new String[][]{},
                new Family(simpleHuman, simpleHuman), new Pet(), simpleHuman, simpleHuman);
        humanAllDataVarSchedule = new Human("", "", (short) 0, (byte) 0, new String[][]{{"1"}, {"1"}},
                new Family(simpleHuman, simpleHuman), new Pet(), simpleHuman, simpleHuman);
        humanAllDataVarFamily = new Human("", "", (short) 0, (byte) 0, new String[][]{},
                new Family(humanAllDataVarSurname, humanAllDataVarSurname), new Pet(), simpleHuman, simpleHuman);
        humanAllDataVarPet = new Human("", "", (short) 0, (byte) 0, new String[][]{},
                new Family(simpleHuman, simpleHuman), new Pet(Species.DOG, ""), simpleHuman, simpleHuman);
        humanAllDataVarMother = new Human("", "", (short) 0, (byte) 0, new String[][]{},
                new Family(simpleHuman, simpleHuman), new Pet(), humanAllDataVarSurname, simpleHuman);
        humanAllDataVarFather = new Human("", "", (short) 0, (byte) 0, new String[][]{},
                new Family(simpleHuman, simpleHuman), new Pet(), simpleHuman, humanAllDataVarSurname);
    }

    @Test
    void testToString() {
        assertEquals("Human{name='', surname='', year=0, iq=0, father=null, mother=null}",
                simpleHuman.toString());

        assertEquals("Human{name='', surname='', year=0, iq=0, father= , mother= }",
                humanAndParents.toString());

        assertEquals("Human{name='', surname='', year=0, iq=0, father= , mother= }",
                humanAllDataInit.toString());
    }

    @Test
    void testEquals() {
        assertNotEquals(humanAllDataInit, humanAllDataVarName);
        assertEquals(humanAllDataInit, humanAllDataVarSurname);
        assertNotEquals(humanAllDataInit, humanAllDataVarYear);
        assertEquals(humanAllDataInit, humanAllDataVarIq);
        assertEquals(humanAllDataInit, humanAllDataVarSchedule);
        assertEquals(humanAllDataInit, humanAllDataVarFamily);
        assertEquals(humanAllDataInit, humanAllDataVarPet);
        assertEquals(humanAllDataInit, humanAllDataVarMother);
        assertEquals(humanAllDataInit, humanAllDataVarFather);
    }

    @Test
    void testHashCode() {
        assertNotEquals(humanAllDataInit, humanAllDataVarName);
        assertEquals(humanAllDataInit, humanAllDataVarSurname);
        assertNotEquals(humanAllDataInit, humanAllDataVarYear);
        assertEquals(humanAllDataInit, humanAllDataVarIq);
        assertEquals(humanAllDataInit, humanAllDataVarSchedule);
        assertEquals(humanAllDataInit, humanAllDataVarFamily);
        assertEquals(humanAllDataInit, humanAllDataVarPet);
        assertEquals(humanAllDataInit, humanAllDataVarMother);
        assertEquals(humanAllDataInit, humanAllDataVarFather);
    }

    @AfterEach
    void tearDown() {
        simpleHuman = null;
        humanAndParents = null;
        humanAllDataInit = null;
        humanAllDataVarName = null;
        humanAllDataVarSurname = null;
        humanAllDataVarYear = null;
        humanAllDataVarIq = null;
        humanAllDataVarSchedule = null;
        humanAllDataVarFamily = null;
        humanAllDataVarPet = null;
        humanAllDataVarMother = null;
        humanAllDataVarFather = null;
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Finish testing Human class!");
    }
}