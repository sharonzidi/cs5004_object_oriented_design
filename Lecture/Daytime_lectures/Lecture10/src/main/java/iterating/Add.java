package iterating;

/**
 * Created by therapon on 7/6/16.
 */
public class Add implements Function<Integer, Integer> {

  private Integer val;

  public Add(Integer val){
    this.val = val;
  }

  public Add(){
    this.val = 0;
  }

  @Override
  public Integer apply(Integer input) {
    return input + val;
  }

  @Override
  public Integer combine(Integer input, Integer acc) {
    return apply(input) + acc;
  }
}
