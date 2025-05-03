package homework4;

import java.util.Arrays;

public class Family {
    {
        System.out.printf("%s instance is loading...%n", this.getClass().getSimpleName());
    }
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    static {
        System.out.printf("%s class is loading...%n", Family.class.getSimpleName());
    }

    public Family(Human mother, Human father) {
        this.mother   = mother;
        this.father   = father;
        this.children = new Human[0];

        this.mother.setFamily(this);
        this.father.setFamily(this);
        this.mother.setSurname(this.father.getSurname());
    }

    public Human getMother() {
        return mother;
    }
    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }
    public void setFather(Human father) {
        this.father = father;
    }

    public Human[] getChildren() {
        return children;
    }
    public void setChildren(Human[] children) {
        this.children = children;
    }

    public Pet getPet() {
        return pet;
    }
    public void setPet(Pet pet) {
        this.pet = pet;
        for (Human child: getChildren()) {
            child.setPet(pet);
        }
        mother.setPet(pet);
        father.setPet(pet);
    }

    public void addChild(Human child) {
        Human[] children = getChildren();

        child.setMother(getMother());
        child.setFather(getFather());
        child.setPet(getPet());
        children = Arrays.copyOf(children, children.length + 1);
        children[children.length - 1] = child;

        setChildren(children);
    }
    public boolean deleteChild(int index) {
        Human[] children = getChildren();

        if(index < 0 || index > children.length - 1) return false;

        Human[] resultArr = new Human[children.length - 1];

        System.arraycopy(children, 0, resultArr, 0, index);
        System.arraycopy(children, index + 1, resultArr, index, children.length - index - 1);

        setChildren(resultArr);
        return true;
    }
    public boolean deleteChild(Human human) {
        Human[] children = getChildren();
        boolean found = false;

        for (int i = 0; i < children.length; i++) {
            if (children[i].equals(human)) {
                found = true;
                Human[] result = new Human[children.length - 1];
                System.arraycopy(children, 0, result, 0, i);
                System.arraycopy(children, i + 1, result, i, children.length - i - 1);
                setChildren(result);
                break;
            }
        }
        return found;
    }
    public int countFamily() {
        return 2 + getChildren().length;
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + getMother() +
                ", father=" + getFather() +
                ", children=" + Arrays.toString(getChildren()) +
                ", pet=" + getPet() +
                '}';
    }
    public void greetPet(Pet pet) {
        System.out.printf("Hello, %s", pet.getNickname());
    }
    public void describePet(Pet pet) {
        System.out.printf("В мене є %s, йому %d років, він %s ",
                pet.getSpecies(), pet.getAge(), pet.getTrick());
    }
}
