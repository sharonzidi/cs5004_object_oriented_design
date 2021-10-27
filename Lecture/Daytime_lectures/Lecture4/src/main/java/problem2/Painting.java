package problem2;

import java.time.LocalDate;
import java.util.Objects;

public class Painting extends Art{

  private Size size;
  private PaintingType paintingType;

  public Painting(String ID, String name, Name owner, Name[] creators, Float suggestedPrice, LocalDate dateListed,
                  Integer numViews, Size size, PaintingType paintingType) {
    super(ID, name, owner, creators, suggestedPrice, dateListed, numViews);
    this.size = size;
    this.paintingType = paintingType;
  }

  public Size getSize() {
    return size;
  }

  public PaintingType getPaintingType() {
    return paintingType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Painting)) return false;
    if (!super.equals(o)) return false;
    Painting painting = (Painting) o;
    return Objects.equals(getSize(), painting.getSize()) &&
        getPaintingType() == painting.getPaintingType();
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getSize(), getPaintingType());
  }

  @Override
  public String toString() {
    return "Painting{" +
        "size=" + size +
        ", paintingType=" + paintingType +
        '}';
  }
}
