package homework5;

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
        this.mother = mother;
        this.father = father;
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

        for (int i = 0; i <= index; i++) {
            resultArr[i] = children[i];
        }
        for (int i = index + 1; i < children.length; i++) {
            resultArr[i - 1] = children[i];
        }
        setChildren(resultArr);
        return true;
    }
    public boolean deleteChild(Human human) {
        Human[] children = getChildren();
        if(children.length == 0) return false;
        Human[] resultArr = new Human[children.length - 1];

        boolean isContain = false;
        int counter = 0;
        for (int i = 0; i < resultArr.length; i++) {
            if(children[i].equals(human)) {
                isContain = true;
                break;
            }
            resultArr[i] = children[i];
            counter++;
        }
        if(isContain) {
            for (int i = counter + 1; i < children.length; i++) {
                resultArr[i - 1] = children[i];
            }
            setChildren(resultArr);
            return true;
        } else {
            return false;
        }
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
        System.out.printf("В мене є %s, йому %s років, він %s ",
                pet.getSpecies(), pet.getAge(), pet.getTrickLevel());
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize - " + this);
    }
}
