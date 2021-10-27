package airlinerbad;

public class Passenger {

  private PassengerStatus status;

  public Passenger(PassengerStatus status) {
    this.status = status;
  }

  public PassengerStatus getStatus() {
    return status;
  }

  public void setStatus(PassengerStatus status) {
    this.status = status;
  }
}
