package enumerations.bookShop;

import java.time.LocalTime;

public class OpeningHours {
  private final LocalTime open;
  private final LocalTime close;

  public OpeningHours(LocalTime open, LocalTime close) throws IllegalArgumentException {
    if (close.isAfter((open))) {
      this.open = open;
      this.close = close;
    }
    else {
      throw new IllegalArgumentException("Closing time must be later than opening time!");
    }
  }

  public String toString() {
    return this.open.toString() + "-" + this.close.toString();
  }



}
