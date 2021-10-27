package tictactoe.protocol;


public class Protocol {
    /**
     * Sent from client to server. No additional content expected.
     */
    public static final int START_GAME = 19;

    /**
     * Sent from client to server. Should be followed by the user's move e.g. "0 0"
     */
    public static final int MAKE_MOVE = 20;

    /**
     * Sent from client to server and from server to client. The client does not need to provide any additional data.
     * The server includes a string representation of the board that the client can use to display to the user by
     * passing it to client.view.Board.java's createBoard method.
     */
    public static final int SHOW_BOARD = 21;

    /**
     * Sent from the server to the client. Followed by a string containing the winner, if there is one.
     */
    public static final int GAME_OVER = 22;

    /**
     * Sent from the server to the client if the client's request is not recognized. Followed by an error message.
     */
    public static final int INVALID_REQUEST = 23;

    /**
     * Sent from the server to the client when it is the user's turn to make a move. Followed by an info message.
     */
    public static final int YOUR_TURN = 24;

    /**
     * Sent from the server to the client if it is not possible to make the move the user has requested. Followed by
     * an error message.
     */
    public static final int INVALID_MOVE = 25;

    /**
     * Sent from the client to the server and from the server to the client when the program should quit.
     */
    public static final int QUIT = 26;

    /**
     * Checks if the message type requested by the client is defined in the protocol.
     * @param message An integer representing the message type e.g. 19 (START_GAME)
     * @return True if the message is defined in the protocol, false otherwise.
     */
    public static boolean inProtocol(int message) {
        return message >= START_GAME && message <= QUIT;
    }
}
