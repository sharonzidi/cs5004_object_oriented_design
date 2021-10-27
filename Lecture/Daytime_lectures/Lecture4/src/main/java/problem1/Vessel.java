package problem1;

public abstract class Vessel extends Vehicle{

  public Vessel(String id, Integer manufacturingYear, Float MSRP, MakeModel makeAndModel) {
    super(id, manufacturingYear, MSRP, makeAndModel);
  }
}
