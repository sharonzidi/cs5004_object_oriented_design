package tictactoe.view;
import java.util.Scanner;

public class Main {

    /**
     * Sample helper method for generating an empty board. This doesn't belong in the "View" portion of an MVC
     * architecture so you'll want to move it somewhere else.
     * @return A 2D String array representing an empty board.
     */
    public static String[][] createEmptyBoard() {
        int SIZE = 3;
        String EMPTY = " ";
        String[][] boardState = new String[SIZE][SIZE];
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                boardState[r][c] = EMPTY;
            }
        }

        return boardState;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // STARTER CODE TO DEMO BOARD USAGE - REPLACE WITH YOUR OWN LOGIC
        String[][] boardState = Main.createEmptyBoard();
        System.out.println("An empty board:");
        System.out.println(Board.createBoard(boardState));

        boardState[2][1] = "X";
        System.out.println("Updated board:");
        System.out.println(Board.createBoard(boardState));

    }
}
