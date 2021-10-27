package p3;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BiotechTrends {

  public Map<String, Integer> trackEngagements(List<Investor> investors) {
    Set<String> companies = investors.stream()
        .flatMap(investor -> investor.getEngagedComapnies().stream())
        .collect(Collectors.toSet());
    return companies.stream()
        .collect(Collectors.toMap(
            s -> s,
            s -> {
              Long count = investors.stream().filter(i -> i.getEngagedComapnies().contains(s)).count();
              return count.intValue();
            }
        ));
  }

}
