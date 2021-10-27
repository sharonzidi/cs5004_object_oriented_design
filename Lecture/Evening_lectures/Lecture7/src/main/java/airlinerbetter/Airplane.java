package airlinerbetter;

/**
 * A better version... still not perfect
 */
public class Airplane {
  private static final int SEATS_PER_ROW = 4;
  private final int numSeats;
  private int numBusiness, numPreferred;
  private int numRows;
  private ISeat[] seats;

  public Airplane(int numSeats, int numBusiness, int numPreferred) {
    this.numSeats = numSeats;
    this.numBusiness = numBusiness;
    this.numPreferred = numPreferred;
    this.seats = new AbstractSeat[numSeats];
    this.numRows = Math.round(numSeats/SEATS_PER_ROW);
    this.fillSeats();
  }

  private void fillSeats() {
    int businessCounter = this.numBusiness;
    int preferredCounter = this.numPreferred;
    for (int i = 0; i < this.numSeats; i++) {
      this.seats[i] = this.seatHelper(i);
    }
  }

  private ISeat seatHelper(int i) {
    if (i < this.numBusiness) {
      return new BusinessSeat(getRow(i), getSeatNum(i));
    } else if (i < this.numBusiness + this.numPreferred) {
      return new PlusSeat(getRow(i), getSeatNum(i));
    } else {
      return new EconomySeat(getRow(i), getSeatNum(i));
    }
  }

  public double calculateSeatPrice(int row, int seat, IPassenger passenger) {
    return this.getSeatByRowNum(row, seat).calculateSeatPrice(passenger);
  }

  private ISeat getSeatByRowNum(int row, int seat) {
    int index = row * SEATS_PER_ROW + seat;
    return this.seats[index];
  }

  private int getRow(int i) {
    return (int)Math.floor(i / SEATS_PER_ROW);
  }

  private int getSeatNum(int i) {
    return i % SEATS_PER_ROW;
  }

  public static void main(String[] args) {
    Airplane a = new Airplane(20, 4, 4);
    IPassenger member = new MemberPassenger();
    IPassenger elite = new ElitePassenger();

    System.out.println(a.calculateSeatPrice(0,0, member));
    System.out.println(a.calculateSeatPrice(0,0,elite));

    System.out.println(a.calculateSeatPrice(1,1, member));
    System.out.println(a.calculateSeatPrice(1,1,elite));

    System.out.println(a.calculateSeatPrice(2,2, member));
    System.out.println(a.calculateSeatPrice(2,2,elite));
  }

}
