package comparison;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.*;
import java.util.stream.Collectors;

public class MainStream2 {

  public static void main(String[] args) {
    List<Runner> runners = new ArrayList<>();


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

    Runner runnerA = new Runner("Jane Smith", fiveKTimes, tenKTimes);

    fiveKTimes = new ArrayList<>();
    fiveKTimes.add(33.00);
    fiveKTimes.add(41.00);
    fiveKTimes.add(42.45);
    fiveKTimes.add(43.00);

    tenKTimes = new ArrayList<>();
    tenKTimes.add(71.50);
    tenKTimes.add(75.00);
    tenKTimes.add(72.50);

    Runner runnerB = new Runner("Ruth Barr", fiveKTimes, tenKTimes);


    fiveKTimes = new ArrayList<>();
    fiveKTimes.add(35.00);
    fiveKTimes.add(42.00);
    fiveKTimes.add(44.45);

    tenKTimes = new ArrayList<>();
    fiveKTimes.add(71.50);
    fiveKTimes.add(75.00);
    fiveKTimes.add(72.50);

    Runner runnerC = new Runner("Ann Mach", fiveKTimes, tenKTimes);

   runners.add(runnerA);
   runners.add(runnerB);
   runners.add(runnerC);

    //Comparator<Runner> numRaces = new RunnerComparator();
    Comparator<Runner> numRaces = new Comparator<Runner>() {

      @Override
      public int compare(Runner r1, Runner r2) {
        return r1.getNumRaces() - r2.getNumRaces();
      }
    };

    Comparator<Runner> num5KRaces = new Comparator<Runner>() {

      @Override
      public int compare(Runner r1, Runner r2) {
        return r1.getFiveKRaceTimes().size()- r2.getFiveKRaceTimes().size();
      }
    };

    System.out.println("Runner:" + runners);

    runners.sort(numRaces);
    Collections.sort(runners, numRaces);
    System.out.println("Runners again:" + runners);

    Collections.sort(runners, num5KRaces);
    System.out.println("Runners again again:" + runners);
  }
}
