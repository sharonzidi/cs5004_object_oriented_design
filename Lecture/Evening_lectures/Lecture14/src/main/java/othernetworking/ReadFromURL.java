package othernetworking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadFromURL {

  private static void readUrl(String url){
    try {
      // Create URL
      URL myURL = new URL(url);
      BufferedReader in = new BufferedReader(
          new InputStreamReader(myURL.openStream()));

      in.lines().forEach(System.out::println);
      // Don't forget to close!
      in.close();
    }
    catch (MalformedURLException e) {
      // Bad URL()
      // ...
      e.printStackTrace();
    }
    catch (IOException e) {
      // openStream() failed
      // ...
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    // Read a webpage
    //readUrl("https://www.northeastern.edu");

    // Read an API endpoint - get data from somewhere else
    readUrl("https://ron-swanson-quotes.herokuapp.com/v2/quotes/");
  }

}
