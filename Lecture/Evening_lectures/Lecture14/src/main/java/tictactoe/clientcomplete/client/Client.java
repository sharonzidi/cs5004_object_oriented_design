package tictactoe.clientcomplete.client;

import tictactoe.clientcomplete.client.view.Board;
import tictactoe.protocol.Message;
import tictactoe.protocol.MessageParser;
import tictactoe.protocol.Protocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private String address;
    private int port;
    private static final String QUIT = "quit";
    private static final String YES = "y";

    // constructor to put ip address and port
    public Client(String address, int port)
    {
        this.address = address;
        this.port = port;

    }

    public void startSession() {
        try (
                Socket socket = new Socket(address, port);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        ) {
            String fromServer, fromUser;

            out.println(Protocol.START_GAME);

            while ((fromServer = in.readLine()) != null) {
                Message response = MessageParser.parse(fromServer);
                // If quit, quit
                // If your move or invalid move, print message
                //      //request board, show board
                //      //take input
                // If game over, print message, start over?
                if (response.getMessage() == Protocol.QUIT) {
                    System.out.println("Quitting...");
                    return;
                }
                out.println(Protocol.SHOW_BOARD);
                fromServer = in.readLine();
                Message board = MessageParser.parse(fromServer);
                System.out.println(Board.createBoard(board.getContent()));
                System.out.println(response.getContent());

                if (response.getMessage() == Protocol.YOUR_TURN || response.getMessage() == Protocol.INVALID_MOVE) {
                    fromUser = stdIn.readLine().toLowerCase();
                    if (fromUser.equals(QUIT))
                        out.println(Protocol.QUIT);
                    else
                        out.println(new Message(Protocol.MAKE_MOVE, fromUser));
                }
                else if (response.getMessage() == Protocol.GAME_OVER) {
                    System.out.println("Would you like to play again? Enter y to continue or quit to end the session");
                    fromUser = stdIn.readLine().toLowerCase();
                    while (!fromUser.equals(YES) && !fromUser.equals(QUIT)) {
                        System.out.println("I'm sorry, I don't understand. Enter y to start another game or quit to end the session");
                        fromUser = stdIn.readLine().toLowerCase();
                    }
                    out.println(this.handleGameOver(fromUser));
                }
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int handleGameOver(String in) {
        if (in.equals(YES))
            return Protocol.START_GAME;
        else return Protocol.QUIT;
    }

    public static void main(String args[])
    {
        Client client = new Client("127.0.0.1", 5000);
        client.startSession();
    }
}
