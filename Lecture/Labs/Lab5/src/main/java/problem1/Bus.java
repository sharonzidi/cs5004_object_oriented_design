package problem1;

public class Bus extends Vehicle{
  public Bus(String ID, Float averageSpeed, Float maxSpeed) {
    super(ID, averageSpeed, maxSpeed);
  }

  public void doSilly(){
    System.out.println("Doing something silly");
  }
}
