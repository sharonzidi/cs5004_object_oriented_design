package problem2;

import java.time.LocalDate;

public class Crafts extends Piece{

  public Crafts(String ID, String name, Name owner, Name[] creators, Float suggestedPrice, LocalDate dateListed, Integer numViews) {
    super(ID, name, owner, creators, suggestedPrice, dateListed, numViews);
  }
}
