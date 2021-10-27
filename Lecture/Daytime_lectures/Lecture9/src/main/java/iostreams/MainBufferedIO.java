package iostreams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by therapon on 7/11/16.
 */
public class MainBufferedIO {

  public static void main(String[] args) {
    BufferedReader inputFile = null;
    BufferedWriter outputFile = null;
    String errString = new String("Failed to close input stream in finally block");


    System.out.println(System.getProperty("user.dir"));

    try {

      inputFile = new BufferedReader(new FileReader("roster.csv"));
      outputFile = new BufferedWriter(new FileWriter("roster.out.csv"));
      String line;

      while ((line = inputFile.readLine()) != null) {
        System.out.println("Read : " + line);
        outputFile.write(line);
      }
    } catch (FileNotFoundException fnfe) {
      System.out.println("*** OUPS! A file was not found : " + fnfe.getMessage());
      fnfe.printStackTrace();
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    } finally {
      if (inputFile != null) {
        try {
          inputFile.close();
        } catch (IOException e) {
          System.out.println(errString);
          e.printStackTrace();
        }
      }
      if (outputFile != null) {
        try {
          outputFile.close();
        } catch (IOException e) {
          System.out.println(errString);
          e.printStackTrace();
        }
      }
    }
  }
}
