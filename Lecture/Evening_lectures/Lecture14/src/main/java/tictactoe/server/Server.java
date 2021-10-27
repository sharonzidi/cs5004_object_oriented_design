package tictactoe.server;

import tictactoe.protocol.MessageParser;
import tictactoe.server.controller.GameController;
import tictactoe.protocol.Protocol;
import tictactoe.protocol.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    int port;
    public Server(int port)
    {
        this.port = port;
    }

    public void listen() {
        try (
                ServerSocket serverSocket = new ServerSocket(port);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {

            String inputLine;
            GameController controller = new GameController();

            while((inputLine = in.readLine()) != null) {
                Message request = MessageParser.parse(inputLine);
                if (request.getMessage() == Protocol.QUIT) {
                    out.println(new Message(Protocol.QUIT, "BYE"));
                    break;
                }
                Message response = controller.processRequest(request);
                out.println(response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[])
    {
        Server server = new Server(5000);
        server.listen();
    }
}
