package airlinerbad;

/**
 * A bad example...
 */
public class Airplane {
  private static final int SEATS_PER_ROW = 4;
  private static final double ECONOMY_PRICE = 100;
  private static final double PLUS_PRICE = 150;
  private static final double BUSINESS_PRICE = 300;
  private static final double ELITE_DISCOUNT = 0.1;
  private final int numSeats;
  private int numBusiness, numPreferred;
  private int numRows;
  private Seat[] seats;


  public Airplane(int numSeats, int numBusiness, int numPreferred) {
    this.numSeats = numSeats;
    this.numBusiness = numBusiness;
    this.numPreferred = numPreferred;
    this.numRows = Math.round(numSeats/SEATS_PER_ROW);

    this.seats = new Seat[numSeats];

    // Create all the seats
    // Start with business class, then plus, then economy
    int currRow = -1;
    int businessCounter = numBusiness;
    int preferredCounter = numPreferred;
    for (int i = 0; i < numSeats; i++) {
      int remainder = i % SEATS_PER_ROW;
      if (remainder == 0) {
        currRow++;
      }
      Seat s;
      if (businessCounter > 0) {
        s = new Seat(SeatClass.BUSINESS, currRow, remainder);
        this.seats[i] = s;
        businessCounter--;
      } else if (preferredCounter > 0) {
        s = new Seat(SeatClass.ECONOMY_PLUS, currRow, remainder);
        this.seats[i] = s;
        preferredCounter--;
      }
      else {
        s = new Seat(SeatClass.ECONOMY, currRow, remainder);
        this.seats[i] = s;
      }
    }
  }

  public double calculateSeatPrice(int row, int seat, Passenger passenger) {
    int findSeat = row * SEATS_PER_ROW + seat;
    double startPrice = 0;
    switch (this.seats[findSeat].getSeatClass()) {
      case ECONOMY:
        startPrice = ECONOMY_PRICE;
        break;
      case ECONOMY_PLUS:
        startPrice = PLUS_PRICE;
        break;
      case BUSINESS:
        startPrice = BUSINESS_PRICE;
        break;
    }
    if (passenger.getStatus() == PassengerStatus.ELITE) {
      return startPrice;
    }
    else {
      return startPrice * (1 - ELITE_DISCOUNT);
    }
  }
}
