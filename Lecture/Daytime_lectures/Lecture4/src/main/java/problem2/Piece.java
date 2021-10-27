package problem2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public abstract class Piece implements IPiece {

  protected String ID;
  protected String name;
  protected Name owner;
  protected Name[] creators;
  protected Float suggestedPrice;
  protected LocalDate dateListed;
  protected Integer numViews;

  public Piece(String ID, String name, Name owner, Name[] creators, Float suggestedPrice,
               LocalDate dateListed, Integer numViews) {
    this.ID = ID;
    this.name = name;
    this.owner = owner;
    this.creators = creators;
    this.suggestedPrice = suggestedPrice;
    this.dateListed = dateListed;
    this.numViews = numViews;
  }

  public String getID() {
    return ID;
  }

  public String getName() {
    return name;
  }

  public Name getOwner() {
    return owner;
  }

  public Name[] getCreators() {
    return creators;
  }

  public Float getSuggestedPrice() {
    return suggestedPrice;
  }

  public LocalDate getDateListed() {
    return dateListed;
  }

  public Integer getNumViews() {
    return numViews;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Piece)) return false;
    Piece piece = (Piece) o;
    return Objects.equals(getID(), piece.getID()) &&
        Objects.equals(getName(), piece.getName()) &&
        Objects.equals(getOwner(), piece.getOwner()) &&
        Arrays.equals(getCreators(), piece.getCreators()) &&
        Objects.equals(getSuggestedPrice(), piece.getSuggestedPrice()) &&
        Objects.equals(getDateListed(), piece.getDateListed()) &&
        Objects.equals(getNumViews(), piece.getNumViews());
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(getID(), getName(), getOwner(), getSuggestedPrice(), getDateListed(), getNumViews());
    result = 31 * result + Arrays.hashCode(getCreators());
    return result;
  }

  @Override
  public String toString() {
    return "Piece{" +
        "ID='" + ID + '\'' +
        ", name='" + name + '\'' +
        ", owner=" + owner +
        ", creators=" + Arrays.toString(creators) +
        ", suggestedPrice=" + suggestedPrice +
        ", dateListed=" + dateListed +
        ", numViews=" + numViews +
        '}';
  }
}
