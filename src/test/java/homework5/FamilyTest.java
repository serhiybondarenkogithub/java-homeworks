package homework5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Family class tests")
class FamilyTest {
    @Mock
    Human mother;
    @Mock
    Human father;
    @Mock
    Pet mockedPet;

    Human firstChild;
    Human secondChild;
    Human thirdChild;

    Family family;

    @BeforeAll
    static void beforeAll() { System.out.println("Testing Family class..."); }
    @BeforeEach
    void setUp() {
        family = new Family(mother, father);
        firstChild = new Human("", "", (short) 1);
        secondChild = new Human("", "", (short) 2);
        thirdChild = new Human("", "", (short) 3);
    }

    @Test
    @DisplayName("Should correctly add a child to the family")
    void addChild_shouldAddChildToArray_whenCalled() {
        Human child = new Human("", "", (short) 1);

        Assertions.assertEquals(0, family.getChildren().length);

        family.addChild(child);

        Assertions.assertArrayEquals(family.getChildren(), new Human[] {child});

        Assertions.assertEquals(1, family.getChildren().length);
    }

    @Test
    @DisplayName("Should return false when deleting by invalid index")
    void deleteChild_shouldReturnFalse_whenIndexIsInvalid() {
        Assertions.assertFalse(family.deleteChild(-1));
        Assertions.assertFalse(family.deleteChild(0));
        Assertions.assertFalse(family.deleteChild(100));
    }

    @Test
    @DisplayName("Should correctly remove child from the middle of array by index")
    void deleteChild_shouldRemoveMiddleChild_whenIndexIsValid() {
        family.addChild(firstChild);
        family.addChild(secondChild);
        family.addChild(thirdChild);

        family.deleteChild(1);

        Assertions.assertArrayEquals(new Human[]{firstChild, thirdChild}, family.getChildren());
    }

    @Test
    @DisplayName("Should correctly remove multiple children in sequence")
    void deleteChild_shouldRemoveMultipleChildrenCorrectly() {
        family.addChild(firstChild);
        family.addChild(secondChild);
        family.addChild(thirdChild);

        family.deleteChild(0); // remove first
        Assertions.assertArrayEquals(new Human[]{secondChild, thirdChild}, family.getChildren());

        family.deleteChild(1); // remove last
        Assertions.assertArrayEquals(new Human[]{secondChild}, family.getChildren());
    }

    @Test
    @DisplayName("Should correctly delete a child by object reference")
    void deleteChild_shouldRemoveChildByObject_whenChildExists() {
        family.deleteChild(thirdChild);
        Assertions.assertArrayEquals(new Human[]{}, family.getChildren());

        family.addChild(firstChild);
        family.addChild(secondChild);
        family.deleteChild(thirdChild);

        Assertions.assertArrayEquals(family.getChildren(), new Human[]{firstChild, secondChild});

        Assertions.assertTrue(family.deleteChild(new Human("", "", (short) 1)));

        Assertions.assertArrayEquals(family.getChildren(), new Human[]{secondChild});
    }

    @Test
    @DisplayName("Should return correct count of family members")
    void countFamily_shouldReturnCorrectFamilySize() {
        Assertions.assertEquals(2, family.countFamily());

        family.addChild(firstChild);

        Assertions.assertEquals(3, family.countFamily());
    }

    @Test
    @DisplayName("Should return correct string representation of family")
    void toString_shouldReturnExpectedString() {
        when(mother.toString()).thenReturn("mother will be here");
        when(father.toString()).thenReturn("father will be here");

        Assertions.assertEquals(
                "Family{" +
                        "mother=mother will be here, " +
                        "father=father will be here, " +
                        "children=[], pet=null}",
                family.toString()
        );

        family.setPet(mockedPet);
        Assertions.assertEquals(
                "Family{" +
                        "mother=mother will be here, " +
                        "father=father will be here, " +
                        "children=[], " +
                        "pet=mockedPet}",
                family.toString()
        );
    }

    @AfterEach
    void tearDown() {
        family = null;
        firstChild = null;
        secondChild = null;
        thirdChild = null;
    }

    @AfterAll
    static void afterAll() { System.out.println("Finish testing Family class!"); }
}