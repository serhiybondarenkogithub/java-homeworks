package homework7.entities.family;

import homework7.entities.human.Human;
import homework7.entities.pet.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Family {
//    {
//        System.out.printf("%s instance is loading...%n", this.getClass().getSimpleName());
//    }
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pets;

    static {
        System.out.printf("%s class is loading...%n", Family.class.getSimpleName());
    }
    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
        this.mother.setFamily(this);
        this.father.setFamily(this);
        this.mother.setSurname(this.father != null ? this.father.getSurname() : null);
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
        if (mother != null) {
            mother.setFamily(this);
            mother.setPets(pets);
            mother.setSurname(father != null ? father.getSurname() : mother.getSurname());
        }
    }
    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
        if (father != null) {
            father.setFamily(this);
            father.setPets(pets);
        }
    }

    public List<Human> getChildren() {
        return new ArrayList<>(children);
    }

    public Human getChild(int index) {
        if (index < 0 || index >= children.size()) return null;
        return children.get(index);
    }

    public Set<Pet> getPets() {
        return pets;
    }
    public void setPets(Set<Pet> pets) {

        this.pets = pets;
        for (Human child: getChildren()) {
            child.setPets(pets);
        }
        if (mother != null) mother.setPets(pets);
        if (father != null) father.setPets(pets);
    }

    public void addChild(Human child) {
        if (child == null) return;
        child.setMother(mother);
        child.setFather(father);
        child.setPets(pets);
        children.add(child);
    }

    public boolean deleteChild(int index) {
        if(index < 0 || index > children.size() - 1) return false;

        children.remove(index);
        return true;
    }

    public boolean deleteChild(Human human) {
        return children.remove(human);
    }

    public int countFamily() {
        return 2 + getChildren().size();
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + getMother() +
                ", father=" + getFather() +
                ", children=" + children.toString() +
                ", pet=" + (getPets() == null ? null : getPets().toString()) +
                '}';
    }
    public void greetPet(Pet pet) {
        if (pet != null) {
            System.out.printf("Hello, %s%n", pet.getNickname());
        }
    }
    public void printPetDescription(Pet pet) {
        if (pet != null) {
            System.out.printf("В мене є %s, йому %s років, він %s%n",
                    pet.getSpecies(), pet.getAge(), pet.getTrick());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) &&
                Objects.equals(father, family.father) &&
                Objects.equals(children, family.children) &&
                Objects.equals(pets, family.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, children, pets);
    }

//    @Override
//    protected void finalize() throws Throwable {
//        System.out.println("finalize - " + this);
//    }
}
