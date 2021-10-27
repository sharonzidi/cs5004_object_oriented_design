package p3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Counter {

  private List<Float> consideredFloats;

  public Counter(List<Float> consideredFloats) {
    this.consideredFloats = consideredFloats;
  }

  public Map<Integer, Integer> frequencyCounter(List<Float> consideredFloats) {
    Map<Integer, Integer> resultMap = new HashMap<>();

    int numDecimals = 0;

    for (Float f : consideredFloats) {
      String[] splitter = f.toString().split("\\.");
      numDecimals= splitter[1].length();

      if (resultMap.containsKey(f)) {
        resultMap.put(resultMap.get(f)+ 1, numDecimals);
      } else {
        resultMap.put(1, numDecimals);
      }
    }
    return resultMap;

  }

}
