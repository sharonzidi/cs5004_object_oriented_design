package animals;

public class Main {

    private static boolean isOdd(int i) {
        return i % 2 == 1;
    }

    private static AbstractPet createPet(String species, String name) {
        String speciesLower = species.toLowerCase();
        if (speciesLower.equals("dog"))
            return new Dog(name);
        return new Cat(name);
    }

    public static void main(String[] args) {
        if (!Main.isOdd(args.length))
            System.out.println("Invalid arguments");
        else {
            PetOwner owner = new PetOwner(args[0]);
            for (int i = 1; i < args.length; i += 2) {
                owner.adoptPet(Main.createPet(args[i], args[i + 1]));
            }

            System.out.println("Hello, " + owner.getName());
            for (AbstractPet p : owner.getPets()) {
                System.out.println(p.getName() + " says " + p.talk());
            }
        }
    }
}
