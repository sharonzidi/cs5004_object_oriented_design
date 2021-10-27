package docsandvets;

import animals.*;

public class Main {
    public static void main(String[] args) {
        Person human = new Person("John", "Doe");
        Cat mittens = new Cat("Mittens", human);
        Horse neddy = new Horse("Neddy", human);
        Canary delia = new Canary("Delia", human);

        Doctor docHuman = new Doctor("Doc", "Human", 10);
        Vet<AbstractDomestic> vetPets = new Vet<>("Doc", "Pets", 10);
        Vet<AbstractFarm> vetFarm = new Vet<>("Doc", "MacDonald", 10);

        // The doctor can only accept human patients
        docHuman.addPatient(human);
        //docHuman.addPatient(mittens);
        //docHuman.addPatient(neddy);
        //docHuman.addPatient(delia);

        // The domestic animal vet can only accept domestic animals
        vetPets.addPatient(mittens);
        //vetPets.addPatient(human);
        //vetPets.addPatient(neddy);
        //vetPets.addPatient(delia);

        // The farm animal vet can only accept farm animals
        vetFarm.addPatient(neddy);
        //vetFarm.addPatient(mittens);
        //vetFarm.addPatient(human);
        //vetFarm.addPatient(delia);
    }
}
