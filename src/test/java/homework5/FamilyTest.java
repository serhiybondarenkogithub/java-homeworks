package homework5;

import org.junit.jupiter.api.*;

class FamilyTest {
    Family simpleFamily;
    Human childNum1;
    Human childNum2;
    Human childNum3;
    Pet simplePet;
    @BeforeAll
    static void beforeAll() { System.out.println("Testing Family class..."); }
    @BeforeEach
    void setUp() {
        simpleFamily = new Family(
                new Human("", "", (short) 0),
                new Human("", "", (short) 0)
        );
        childNum1 = new Human("", "", (short) 1);
        childNum2 = new Human("", "", (short) 2);
        childNum3 = new Human("", "", (short) 3);
        simplePet = new Pet();
    }
    @Test
    void addChild() {
        Human child = new Human("", "", (short) 1);

        Assertions.assertEquals(0, simpleFamily.getChildren().length);

        simpleFamily.addChild(child);

        Assertions.assertArrayEquals(simpleFamily.getChildren(), new Human[] {child});

        Assertions.assertEquals(1, simpleFamily.getChildren().length);
    }

    @Test
    void deleteChild() {
        Assertions.assertFalse(simpleFamily.deleteChild(-1));
        Assertions.assertFalse(simpleFamily.deleteChild(0));
        Assertions.assertFalse(simpleFamily.deleteChild(100));

        simpleFamily.addChild(childNum1);
        simpleFamily.addChild(childNum2);
        simpleFamily.addChild(childNum3);

        simpleFamily.deleteChild(1);

        Assertions.assertArrayEquals(simpleFamily.getChildren(), new Human[]{childNum1, childNum3});

        simpleFamily.addChild(childNum2);
        Assertions.assertFalse(simpleFamily.deleteChild(3));
        simpleFamily.deleteChild(0);

        Assertions.assertArrayEquals(simpleFamily.getChildren(), new Human[]{childNum3, childNum2});
    }

    @Test
    void testDeleteChild() {
        simpleFamily.deleteChild(childNum3);
        Assertions.assertArrayEquals(new Human[]{}, simpleFamily.getChildren());

        simpleFamily.addChild(childNum1);
        simpleFamily.addChild(childNum2);
        simpleFamily.deleteChild(childNum3);

        Assertions.assertArrayEquals(simpleFamily.getChildren(), new Human[]{childNum1, childNum2});

        Assertions.assertTrue(simpleFamily.deleteChild(new Human("", "", (short) 1)));

        Assertions.assertArrayEquals(simpleFamily.getChildren(), new Human[]{childNum2});
    }

    @Test
    void countFamily() {
        Assertions.assertEquals(2, simpleFamily.countFamily());

        simpleFamily.addChild(childNum1);

        Assertions.assertEquals(3, simpleFamily.countFamily());
    }

    @Test
    void testToString() {
        Assertions.assertEquals(
                "Family{" +
                        "mother=Human{name='', surname='', year=0, iq=0, father=null, mother=null}, " +
                        "father=Human{name='', surname='', year=0, iq=0, father=null, mother=null}, " +
                        "children=[], pet=null}",
                simpleFamily.toString()
        );

        simpleFamily.setPet(simplePet);
        Assertions.assertEquals(
                "Family{" +
                        "mother=Human{name='', surname='', year=0, iq=0, father=null, mother=null}, " +
                        "father=Human{name='', surname='', year=0, iq=0, father=null, mother=null}, " +
                        "children=[], " +
                        "pet=Pet{nickname='doesn't have nickname yet', age=0, trickLevel=unknown, habits=[]}}",
                simpleFamily.toString()
        );
    }

    @AfterEach
    void tearDown() {
        simpleFamily = null;
        childNum1 = null;
        childNum2 = null;
        childNum3 = null;
        simplePet = null;
    }

    @AfterAll
    static void afterAll() { System.out.println("Finish testing Family class!"); }
}