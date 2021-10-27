package problem2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class TextileCraft extends Crafts{

  private String[] usedTextile;
  private TextileCraftType textileCraftType;

  public TextileCraft(String ID, String name, Name owner, Name[] creators, Float suggestedPrice, LocalDate dateListed,
                      Integer numViews, String[] usedTextile, TextileCraftType textileCraftType) {
    super(ID, name, owner, creators, suggestedPrice, dateListed, numViews);
    this.usedTextile = usedTextile;
    this.textileCraftType = textileCraftType;
  }

  public String[] getUsedTextile() {
    return usedTextile;
  }

  public TextileCraftType getTextileCraftType() {
    return textileCraftType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof TextileCraft)) return false;
    if (!super.equals(o)) return false;
    TextileCraft that = (TextileCraft) o;
    return Arrays.equals(getUsedTextile(), that.getUsedTextile()) &&
        getTextileCraftType() == that.getTextileCraftType();
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(super.hashCode(), getTextileCraftType());
    result = 31 * result + Arrays.hashCode(getUsedTextile());
    return result;
  }

  @Override
  public String toString() {
    return "TextileCraft{" +
        "usedTextile=" + Arrays.toString(usedTextile) +
        ", textileCraftType=" + textileCraftType +
        '}';
  }
}
