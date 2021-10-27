package animals;

public class Pet {
  private String name;
  private Animal species;

  public Pet(String name, Animal species) {
    this.name = name;
    this.species = species;
  }

  public String sayHello() {
    return this.name + " say " + this.species.talk();
  }

  public static void main(String[] args) {
    Pet mittens = new Pet("Mittens", new Cat());
    Pet fido = new Pet("Fido", new Dog());

    System.out.println(mittens.sayHello());
    System.out.println(fido.sayHello());
  }
}
