package othernetworking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpConnection {

  private static void openHttpConnection(){
    try {
      // Create URL
      String theURL = "https://opentdb.com/api.php?amount=1";
      URL myURL = new URL(theURL);
      // Connect to URL
      HttpURLConnection connection = (HttpURLConnection) myURL.openConnection();
      connection.setRequestMethod("GET");
      connection.setRequestProperty("User-Agent", "App/java app demo");
      connection.setRequestProperty("Content-Type", "application/json");
      connection.connect();
      // Read from/Write to the connection
      BufferedReader in = new BufferedReader(new InputStreamReader(
          connection.getInputStream()));
      String inputLine;
      while ((inputLine = in.readLine()) != null) {
        System.out.println(inputLine);
      }
      in.close();
    } catch (ProtocolException e) {
      e.printStackTrace();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    openHttpConnection();
  }

}
