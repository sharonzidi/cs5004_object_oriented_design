package tictactoe.server.controller;

import tictactoe.server.model.GameState;

import java.util.Random;
import java.util.stream.Collectors;

/**
 * Follows the adapter pattern to change the Player interface for the computer player. Uses delegation (rather than
 * subclassing in order to prevent use of the human player's makeMove method
 */
public class ComputerPlayer {
    private static final int MIN_SQ = 0;
    private static final int MAX_SQ = 3;
    Player computer;

    public ComputerPlayer(String character, GameState state) {
        this.computer = new Player(character, state);
    }

    public boolean takeTurn() {
        String move = this.randomSquare();
        while (!this.computer.makeMove(move))
            move = this.randomSquare();
        return true;
    }

    /**
     * Picks a random square on the board and returns it in the format expected by the Player
     * @return
     */
    private String randomSquare() {
        return new Random().ints(MIN_SQ, MAX_SQ).limit(2).mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
