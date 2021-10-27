package p3;

import java.util.ArrayList;
import java.util.List;

public class Client {

  private List<String> consideredProperties = new ArrayList<>();
  private List<String> visitedProperties = new ArrayList<>();

  public Client(List<String> consideredProperties, List<String> visitedProperties) {
    this.consideredProperties = consideredProperties;
    this.visitedProperties = visitedProperties;
  }

  public List<String> getConsideredProperties() {
    return consideredProperties;
  }

  public List<String> getVisitedProperties() {
    return visitedProperties;
  }
}
