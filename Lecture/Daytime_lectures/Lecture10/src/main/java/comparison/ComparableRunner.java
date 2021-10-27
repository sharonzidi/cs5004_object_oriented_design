package comparison;

import java.util.List;

/*
Class implement information about runners and run times for the runners 5K, 10K and half-marathon races.
 */
public class ComparableRunner implements Comparable<ComparableRunner>{

  private String name;
  private List<Double> fiveKRaceTimes;
  private List<Double> tenKRaceTimes;

  /*
  Constructor for class ComparableRunner. It constructs an instance of a Runner, based on provided input arguments:
  @param name - String, representing the first and the last name of a runner
  @param fiveKRaceTimes - List of Doubles, representing races times (in minutes) for a runner's 5K races
  @param tenKRaceTimes - List of Doubles, representing races times (in minutes) for  a runner's 10K races
   */
  public ComparableRunner(String name, List<Double> fiveKRaceTimes, List<Double> tenKRaceTimes) {
    this.name = name;
    this.fiveKRaceTimes = fiveKRaceTimes;
    this.tenKRaceTimes = tenKRaceTimes;
  }

  public String getName() {
    return name;
  }

  public List<Double> getFiveKRaceTimes() {
    return fiveKRaceTimes;
  }

  public List<Double> getTenKRaceTimes() {
    return tenKRaceTimes;
  }

  public Integer getNumRaces() {
    return this.fiveKRaceTimes.size() + this.getTenKRaceTimes().size();
  }

  @Override
  public String toString() {
    return "Runner:" + name;
  }

  /*
   * Method compares two ComparableRunner objects based upon the number of 5K races that the runners have run.
   */
  @Override
  public int compareTo(ComparableRunner o) {
    if (this.fiveKRaceTimes.size() > o.fiveKRaceTimes.size()) {
      return 1;
    }
    else if (this.fiveKRaceTimes.size() < o.fiveKRaceTimes.size())
      return -1;
    else return 0;
  }
}
