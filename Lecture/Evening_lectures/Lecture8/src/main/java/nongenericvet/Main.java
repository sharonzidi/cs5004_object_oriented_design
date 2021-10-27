package nongenericvet;

import animals.*;

public class Main {
    public static void main(String[] args) {
        Person doolittle = new Person("Dr.", "Doolittle");
        Cat mittens = new Cat("Mittens", doolittle);
        Dog spot = new Dog("Spot", doolittle);
        Cow milly = new Cow("Milly", doolittle);
        Horse ned = new Horse("Ned", doolittle);
        Canary delia = new Canary("Delia", doolittle);
        Parakeet polly = new Parakeet("Polly", doolittle);

        AbstractVet drDom = new DomesticVet("Dr.", "Domestic");
        AbstractVet drFarm = new FarmVet("Dr.", "Farm");
        AbstractVet drBird = new BirdVet("Dr.", "Bird");

        System.out.println("Dr Domestic can add cat=" + drDom.canAcceptPatient(mittens));
        System.out.println("Dr Domestic can add dog=" + drDom.canAcceptPatient(spot));
        System.out.println("Dr Domestic can add cow=" + drDom.canAcceptPatient(milly));
        System.out.println("Dr Domestic can add horse=" + drDom.canAcceptPatient(ned));
        System.out.println("Dr Domestic can add canary=" + drDom.canAcceptPatient(delia));
        System.out.println("Dr Domestic can add parakeet=" + drDom.canAcceptPatient(polly));

        System.out.println("");

        System.out.println("Dr Farm can add cat=" + drFarm.canAcceptPatient(mittens));
        System.out.println("Dr Farm can add dog=" + drFarm.canAcceptPatient(spot));
        System.out.println("Dr Farm can add cow=" + drFarm.canAcceptPatient(milly));
        System.out.println("Dr Farm can add horse=" + drFarm.canAcceptPatient(ned));
        System.out.println("Dr Farm can add canary=" + drFarm.canAcceptPatient(delia));
        System.out.println("Dr Farm can add parakeet=" + drFarm.canAcceptPatient(polly));

        System.out.println("");

        System.out.println("Dr Bird can add cat=" + drBird.canAcceptPatient(mittens));
        System.out.println("Dr Bird can add dog=" + drBird.canAcceptPatient(spot));
        System.out.println("Dr Bird can add cow=" + drBird.canAcceptPatient(milly));
        System.out.println("Dr Bird can add horse=" + drBird.canAcceptPatient(ned));
        System.out.println("Dr Bird can add canary=" + drBird.canAcceptPatient(delia));
        System.out.println("Dr Bird can add parakeet=" + drBird.canAcceptPatient(polly));
    }
}
