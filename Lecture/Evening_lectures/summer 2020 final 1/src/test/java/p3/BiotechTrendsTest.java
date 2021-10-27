package p3;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

/**
 * Note: These are not the "official" solutions! Testing could probably be more thorough!
 */
public class BiotechTrendsTest {
  Investor i1;
  Investor i2;
  Investor i3;
  BiotechTrends trends;

  @Before
  public void setUp() throws Exception {
    i1 = new Investor(Arrays.asList("A", "B", "C"));
    i2 = new Investor(Arrays.asList("D"));
    i3 = new Investor(Arrays.asList("A", "C", "D"));
    trends = new BiotechTrends();
  }

  @Test
  public void trackEngagements() {
    Map<String, Integer> companies = new HashMap<>();
    companies.put("A", 2);
    companies.put("B", 1);
    companies.put("C", 2);
    companies.put("D", 2);
    assertEquals(companies, trends.trackEngagements(Arrays.asList(i1, i2, i3)));
  }
}