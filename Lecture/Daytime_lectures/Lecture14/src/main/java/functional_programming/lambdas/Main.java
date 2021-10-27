package functional_programming.lambdas;

import java.util.Iterator;

public class Main {

    private static final String SEPARATOR = ", ";

    public static void main(String[] args) {
        // empty lines for more visible output in IntelliJ's Console
        System.out.println();
        System.out.println();
        System.out.println();
        List<Integer> intList = List.createEmpty();
        intList = intList.add(1).add(10).add(100);

        System.out.println("\tPrint list as is: " + intList);
        System.out.println("\tPrint list joined with \",\": " + intList.join(SEPARATOR));

        System.out.println("\nUsing for-loop");
        for (int i = 0; i < intList.size(); i++) {
            System.out.println("\tFor-loop element at: " + i + " is: " + intList.elementAt(i));
        }

        System.out.println("\nUsing iterator interface");
        Iterator<Integer> it = intList.iterator();
        while (it.hasNext()) {
            System.out.println("\tIterator element: " + it.next());
        }

        System.out.println("\nUsing iterable interface");
        for (Integer element : intList) {
            System.out.println("\tList element: " + element);

        }

//
//    System.out.println("\nUsing iterator incorrectly");
//    Iterator<Integer> it2 = intList.iterator();
//    while(!intList.isEmpty()){
//      System.out.println("\tUsing iterator incorrectly, element: " + it2.next());
//    }


        // ADD 1 to each element
        List<Integer> add1List = List.createEmpty();
        for (Integer element : intList) {
            add1List = add1List.add(element + 1);
        }

        System.out.println("\nIntlist add1: " + add1List.join(SEPARATOR));

        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
                "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        // MAP to character
        List<String> alpha = List.createEmpty();
        for (Integer element : intList) {
            int alphaIndex = (element % alphabet.length) - 1;
            alpha = alpha.add(alphabet[alphaIndex]);
        }
        System.out.println("\nIntlist mapped to Alphabet: " + alpha.join(SEPARATOR));


        System.out.println("\nFunctional Objects: Add1: " + intList.applyToEach(new Add1()).join(SEPARATOR));
        System.out.println("\nFunctional Objects: MapToAlphabet: "
                + intList.applyToEach(new MapToAlphabet()).join(SEPARATOR));


        System.out.println("\nfold over intList: Sum: " + intList.foldOver(new Add(), 0));
        System.out.println("\nfold over intList: MapToAlphabet: " + intList.foldOver(new
                MapToAlphabet(), ""));

        MapToAlphabetList mToAList = new MapToAlphabetList();

        System.out.println("\nmap over intList: MapToAlphabetList: "
                + intList.applyToEach(mToAList));

        System.out.println("\nmap over intList: MapToAlphabetList: "
                + intList.applyToEach(mToAList).join(SEPARATOR));

        System.out.println("\nfold over intList: MapToAlphabetList: "
                + intList.foldOver(mToAList, List.createEmpty()).join(SEPARATOR));

        Add adder = new Add(0);
        System.out.println("\nfold over inList: Sum: " + intList.foldOver(adder,0));

        Multiply mul = new Multiply();
        System.out.println("\nfold over inList: Product: " + intList.foldOver(mul,1));


        Integer ans = intList.applyToEach(new Add(10))
                .applyToEach(new Multiply(5))
                .foldOver(new Multiply(), 1);

        System.out.println("\nand the answer is ... : " + ans);
    }

}
