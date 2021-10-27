package countryCodesMVC;

public class Controller {

  public static void main(String[] args) {
    Model model = new Model();
    String lookup = "";

    // As long as we're getting input from the View...
    while (!lookup.equals("quit")) {
      // Ask for user input via the View
      lookup = View.getInput("Enter a country code:");

      // Send feedback to view after querying the model
      View.giveFeedback(lookup + ": " + model.getCountryByCode(lookup));
    }
  }

}
