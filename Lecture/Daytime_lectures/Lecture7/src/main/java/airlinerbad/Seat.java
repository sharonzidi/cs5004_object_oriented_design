package airlinerbad;

public class Seat {
  private SeatClass seatClass;
  private int row;
  private int seatNum;

  public Seat(SeatClass seatClass, int row, int seatNum) {
    this.seatClass = seatClass;
    this.row = row;
    this.seatNum = seatNum;
  }

  public SeatClass getSeatClass() {
    return seatClass;
  }

  public int getRow() {
    return row;
  }

  public int getSeatNum() {
    return seatNum;
  }
}
