package iostreams;

import java.io.*;

public class MainTryWithResources {
    public static void main(String[] args) {

        System.out.println(System.getProperty("user.dir"));

        try (BufferedReader inputFile = new BufferedReader(new FileReader("country_codes.csv"))) {
            String line;
            while ((line = inputFile.readLine()) != null) {
                System.out.println("Read : " + line);
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("*** OOPS! A file was not found : " + fnfe.getMessage());
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            System.out.println("Something went wrong! : " + ioe.getMessage());
            ioe.printStackTrace();
        }
    }
}
