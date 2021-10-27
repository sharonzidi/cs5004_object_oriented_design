package problem2;

import java.util.Objects;

public class Size {

  private Float height;
  private Float length;
  private Float width;

  public Size(Float height, Float length, Float width) {
    this.height = height;
    this.length = length;
    this.width = width;
  }

  public Float getHeight() {
    return height;
  }

  public Float getLength() {
    return length;
  }

  public Float getWidth() {
    return width;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Size)) return false;
    Size size = (Size) o;
    return Objects.equals(getHeight(), size.getHeight()) &&
        Objects.equals(getLength(), size.getLength()) &&
        Objects.equals(getWidth(), size.getWidth());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getHeight(), getLength(), getWidth());
  }

  @Override
  public String toString() {
    return "Size{" +
        "height=" + height +
        ", length=" + length +
        ", width=" + width +
        '}';
  }
}
