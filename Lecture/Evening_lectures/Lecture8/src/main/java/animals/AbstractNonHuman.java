package animals;

public abstract class AbstractNonHuman extends AbstractAnimal {
    protected Person owner;
    public AbstractNonHuman(String firstName, Person owner) {
        super(firstName, owner.getLastName());
        this.owner = owner;
    }

    public Person getOwner() {
        return this.owner;
    }

    public void setOwner(Person newOwner) {
        this.owner = newOwner;
        this.setLastName(this.owner.getLastName());
    }
}
