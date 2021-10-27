package problem2;

import java.time.LocalDate;
import java.util.Objects;

public class Sculpture extends Art{

  private Boolean moveable;
  private MaterialType materialType;

  public Sculpture(String ID, String name, Name owner, Name[] creators, Float suggestedPrice, LocalDate dateListed,
                   Integer numViews, Boolean moveable, MaterialType materialType) {
    super(ID, name, owner, creators, suggestedPrice, dateListed, numViews);
    this.moveable = moveable;
    this.materialType = materialType;
  }

  public Boolean getMoveable() {
    return moveable;
  }

  public MaterialType getMaterialType() {
    return materialType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Sculpture)) return false;
    if (!super.equals(o)) return false;
    Sculpture sculpture = (Sculpture) o;
    return Objects.equals(getMoveable(), sculpture.getMoveable()) &&
        getMaterialType() == sculpture.getMaterialType();
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getMoveable(), getMaterialType());
  }

  @Override
  public String toString() {
    return "Sculpture{" +
        "moveable=" + moveable +
        ", materialType=" + materialType +
        '}';
  }
}
