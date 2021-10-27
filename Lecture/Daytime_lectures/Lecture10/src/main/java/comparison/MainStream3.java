package comparison;

import java.util.*;

public class MainStream3 {

  public static void main(String[] args) {
    List<ComparableRunner> runners = new ArrayList<>();


    List<Double> fiveKTimes = new ArrayList<>();
    fiveKTimes.add(35.00);
    fiveKTimes.add(40.00);
    fiveKTimes.add(38.45);
    fiveKTimes.add(36.00);
    fiveKTimes.add(33.45);

    List<Double> tenKTimes = new ArrayList<>();
    tenKTimes.add(67.50);
    tenKTimes.add(70.00);
    tenKTimes.add(80.50);

    ComparableRunner runnerA = new ComparableRunner("Jane Smith", fiveKTimes, tenKTimes);

    fiveKTimes = new ArrayList<>();
    fiveKTimes.add(33.00);
    fiveKTimes.add(41.00);
    fiveKTimes.add(42.45);
    fiveKTimes.add(43.00);

    tenKTimes = new ArrayList<>();
    tenKTimes.add(71.50);
    tenKTimes.add(75.00);
    tenKTimes.add(72.50);

    ComparableRunner runnerB = new ComparableRunner("Ruth Barr", fiveKTimes, tenKTimes);


    fiveKTimes = new ArrayList<>();
    fiveKTimes.add(35.00);
    fiveKTimes.add(42.00);
    fiveKTimes.add(44.45);

    tenKTimes = new ArrayList<>();
    fiveKTimes.add(71.50);
    fiveKTimes.add(75.00);
    fiveKTimes.add(72.50);

    ComparableRunner runnerC = new ComparableRunner("Ann Mach", fiveKTimes, tenKTimes);

   runners.add(runnerA);
   runners.add(runnerB);
   runners.add(runnerC);

    System.out.println("Runner:" + runners);

    Collections.sort(runners);
    System.out.println("Runners again:" + runners);
  }
}
