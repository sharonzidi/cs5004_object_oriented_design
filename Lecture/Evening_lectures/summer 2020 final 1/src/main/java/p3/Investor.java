package p3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Investor {
  private List<String> engagedCompanies = new ArrayList<>();
  public Investor(List<String> engagedComapnies) {
    this.engagedCompanies = engagedComapnies;
  }
  public List<String> getEngagedComapnies() {
    return engagedCompanies;
  }
}
