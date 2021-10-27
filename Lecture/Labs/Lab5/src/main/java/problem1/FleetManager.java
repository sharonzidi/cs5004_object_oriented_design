package problem1;

public class FleetManager {

  TripReport drive(Float distance, Vehicle vehicle){
    Integer duration = Math.round(distance/vehicle.getAverageSpeed());
    return new TripReport(vehicle, vehicle.getAverageSpeed(), distance, duration);
  }

  TripReport drive(Float distance, Vehicle vehicle, Float speed){
    Integer duration = Math.round(distance/speed);
    return new TripReport(vehicle, speed, distance, duration);
  }

  TripReport drive(Float distance, Vehicle vehicle, Float speed, Integer duration){
    return new TripReport(vehicle, speed, distance, duration);
  }

  TripReport drive(Float distance, Float speed, String ID, Float avgSpeed, Float maxSpeed){
    Vehicle myVehicle = new Bus(ID, avgSpeed, maxSpeed);
    Integer duration = Math.round(distance/speed);
    return new TripReport(myVehicle, speed, distance, duration);
  }

  //TripReport drive(Integer distance, Vehicle vehicle){
  //}
  
  public static void main(String[] args){
    FleetManager fManager = new FleetManager();
    Vehicle testVehicle1 = new Bus("57", 25.0f, 60f);
    Train testVehicle2 = new Train("112", 45f, 120f);
    IVehicle testVehicle3 = new Boat("Titanic", 15f, 75f);

    System.out.println(fManager.drive(100f, testVehicle1));
    System.out.println(fManager.drive(100f, testVehicle2));
    System.out.println(fManager.drive(100f, (Vehicle) testVehicle3));

    ((Bus) testVehicle1).doSilly();
  }
}
