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
        return Arrays.copyOf(children, children.length);
    }
    public void setChildren(Human[] children) {
        this.children = children;
    }

    public Pet getPet() {
        return pet;
    }
    public void setPet(Pet pet) {
        this.pet = pet;
        if (mother != null) mother.setPet(pet);
        if (father != null) father.setPet(pet);
        for (Human child : getChildren()) {
            if (child != null) child.setPet(pet);
        }
    }

    public void addChild(Human child) {
        if (child == null) return;

        Human[] current = getChildren();
        Human[] updated = new Human[current.length + 1];
        System.arraycopy(current, 0, updated, 0, current.length);
        updated[current.length] = child;

        child.setMother(getMother());
        child.setFather(getFather());
        child.setPet(getPet());

        setChildren(updated);
    }
    public boolean deleteChild(int index) {
        Human[] children = getChildren();

        if (index < 0 || index >= children.length) return false;

        Human[] resultArr = new Human[children.length - 1];

        for (int i = 0, j = 0; i < children.length; i++) {
            if (i == index) continue;
            resultArr[j++] = children[i];
        }

        setChildren(resultArr);
        return true;
    }
    public boolean deleteChild(Human human) {
        Human[] children = getChildren();
        for (int i = 0; i < children.length; i++) {
            if (children[i].equals(human)) {
                Human[] updated = new Human[children.length - 1];
                System.arraycopy(children, 0, updated, 0, i);
                System.arraycopy(children, i + 1, updated, i, children.length - i - 1);
                setChildren(updated);
                return true;
            }
        }
        return false;
    }
    public int countFamily() {
        return 2 + getChildren().length;
    }

    public void greetPet(Pet pet) {
        if (pet != null) {
            System.out.printf("Hello, %s%n", pet.getNickname());
        }
    }
    public void describePet(Pet pet) {
        if (pet != null) {
            System.out.printf("В мене є %s, йому %s років, він %s%n",
                    pet.getSpecies(), pet.getAge(), pet.getTrickLevel());
        }
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
}
