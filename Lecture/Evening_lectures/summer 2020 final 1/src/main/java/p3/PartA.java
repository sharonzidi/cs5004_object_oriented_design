package p3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartA {
  public static Map<Integer, FrequencyInfo> frequencyCounter(List<Integer> consideredInts) {
    Map<Integer, FrequencyInfo> frequency = new HashMap<>();
    for (Integer i: consideredInts) {
      if (!frequency.containsKey(i)) {
        frequency.put(i, new FrequencyInfo(
            consideredInts.stream().filter(item -> item.equals(i)).count(),
            i.toString().length()
        ));
      }
    }
    return frequency;
  }

  public static void main(String[] args) {
    List<Integer> test = Arrays.asList(12345, 5678, 67, 525, 5678, 12345, 5678);
    System.out.println(PartA.frequencyCounter(test));
  }
}
