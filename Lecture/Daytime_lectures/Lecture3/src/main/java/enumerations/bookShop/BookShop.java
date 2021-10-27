package enumerations.bookShop;

import java.time.LocalTime;
import enumerations.DayOfWeek;

public class BookShop {
  private final String name;

  public BookShop(String name) {
    this.name = name;
  }

  public static OpeningHours getHours(DayOfWeek day) {
    LocalTime NINE_AM = LocalTime.of(9,0,0);
    LocalTime ELEVEN_AM = LocalTime.of(11,0,0);
    LocalTime EIGHT_PM = LocalTime.of(20,0,0);
    LocalTime SIX_PM = LocalTime.of(18,0,0);
    LocalTime FOUR_PM = LocalTime.of(16,0,0);

    OpeningHours hours;

    switch(day) {
      case SATURDAY:
        hours = new OpeningHours(ELEVEN_AM, SIX_PM);
        break;
      case SUNDAY:
        hours = new OpeningHours(ELEVEN_AM, FOUR_PM);
        break;
      default:
        hours = new OpeningHours(NINE_AM, EIGHT_PM);
    }
    return hours;
  }

}
