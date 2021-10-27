package networking;

// A Java program for a Server
import java.net.*;
import java.io.*;

public class Server
{

  public Server(int port)
  {
    try (
        ServerSocket serverSocket = new ServerSocket(port);
        Socket clientSocket = serverSocket.accept();
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    ) {

      String inputLine, outputLine;

      Protocol protocol = new Protocol();
      outputLine = protocol.processInput(null);
      out.println(outputLine);

      while((inputLine = in.readLine()) != null) {
        outputLine = protocol.processInput(inputLine);
        out.println(outputLine);
        if (outputLine.equals("BYE")) {

          break;
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String args[])
  {
    Server server = new Server(5000);
  }
}
