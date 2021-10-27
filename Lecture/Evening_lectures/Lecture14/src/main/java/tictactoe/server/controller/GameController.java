package tictactoe.server.controller;

import tictactoe.server.model.GameState;
import tictactoe.protocol.Protocol;
import tictactoe.protocol.Message;
import tictactoe.server.model.Play;
import tictactoe.client.view.Board;

public class GameController {
    private GameState gameState;
    private Player human;
    private ComputerPlayer computer;

    public GameController() {
        this.gameState = GameState.startGame();
        this.human = new Player("X", this.gameState);
        this.computer = new ComputerPlayer("O", this.gameState);
    }

    /**
     * A message must be preceded by an integer representing a request in the protocol.
     * @param request The message sent by the client.
     * @return A Message object representing the server's response.
     */
    public Message processRequest(Message request) {
        switch (request.getMessage()) {
            case Protocol.START_GAME:
                this.gameState.restart();
                return new Message(Protocol.YOUR_TURN, "Welcome, Player! Your turn.");
            case Protocol.MAKE_MOVE:
                if (human.makeMove(request.getContent())) {
                    if (this.gameState.getPlayStatus() == Play.O_TURN)
                        computer.takeTurn();
                    return this.getNextStep();
                }
                return new Message(Protocol.INVALID_MOVE, human.getLastError());
            case Protocol.SHOW_BOARD:
                return new Message(Protocol.SHOW_BOARD, this.gameState.boardString());
            default:
                return request;
        }
    }

    private Message getNextStep() {
        Play status = this.gameState.getPlayStatus();
        if (status == Play.NO_WINNER)
            return new Message(Protocol.GAME_OVER, "Game over. It's a tie!");
        else if (status == Play.X_WINS)
            return new Message(Protocol.GAME_OVER, "Game over. You win!");
        else if (status == Play.O_WINS)
            return new Message(Protocol.GAME_OVER, "Game over. Computer wins!");
        System.out.println(status);
        return new Message(Protocol.YOUR_TURN, "Your move.");
    }
}
