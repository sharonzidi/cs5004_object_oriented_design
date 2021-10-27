package tictactoe.client;

import tictactoe.client.view.Board;
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

                if (response.getMessage() == Protocol.QUIT) {
                    System.out.println("Quitting...");
                    return;
                }
                /**
                 * YOUR CODE HERE
                 * The client needs to:
                 * - Allow the user to take a turn by entering where they would like to place their piece in e.g. "0 0"
                 * - Keep the user up to date about the status of the game. Consider how/when you will show the board.
                 * You will also need announce the winner at the end of the game.
                 * - Allow the user to quit by entering "quit". This should cause both client and server to quit.
                 * - Allow the user to start a new game
                 *
                 * You should only edit this class. You may only access objects in the client and protocol packages. All
                 * server code is off limits!
                 *
                 * Here are some code snippets help you figure out how to interact with the protocol & server.
                 *
                 * Print the content of the server's message:
                 * System.out.println(response.getContent());
                 *
                 * Get input from the user:
                 * fromUser = stdIn.readLine();
                 *
                 * According to the protocol, a message should begin with an integer, representing the type of request,
                 * optionally followed by a string containing the message content.
                 *
                 * To send a message containing just the request type:
                 * out.println(Protocol.MESSAGE_TYPE)
                 *
                 * To send a message containing request type and content, create a Message object:
                 * out.println(Protocol.MESSAGE_TYPE, "message content")
                 */

            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[])
    {
        Client client = new Client("127.0.0.1", 5000);
        client.startSession();
    }
}
