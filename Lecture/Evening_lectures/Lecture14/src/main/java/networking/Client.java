package networking;

// A Java program for a Client
import java.net.*;
import java.io.*;
import java.util.stream.Stream;

public class Client
{
  private static final String INSTRUCTIONS = "Enter the number of quotes you would like or enter 'bye' to quit.";
  private static final String[] responses = new String[]{"No quotes for you...", "Waiting..."};

  // constructor to put ip address and port
  public Client(String address, int port)
  {
    try (
        Socket socket = new Socket(address, port);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    ) {
      String fromServer, fromUser;

      while ((fromServer = in.readLine()) != null) {
        System.out.println(fromServer);

        if (fromServer.equals(Protocol.QUITTING_MESSAGE)) {
          System.out.println("Quitting...");
          return;
        }

        if (fromServer.equals(Protocol.STARTING_MESSAGE)
            || fromServer.equals(Protocol.WAITING_MESSAGE)
            || fromServer.equals(Protocol.QUOTES_SENT)) {

          System.out.println(INSTRUCTIONS);

          fromUser = stdIn.readLine();
          if (!fromUser.isEmpty()) {
            out.println(fromUser);
          }
        }
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
  }
}