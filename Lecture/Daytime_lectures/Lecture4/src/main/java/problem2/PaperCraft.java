package problem2;

import java.time.LocalDate;
import java.util.Objects;

public class PaperCraft extends Crafts{

  private PaperCraftType paperCraftType;

  public PaperCraft(String ID, String name, Name owner, Name[] creators, Float suggestedPrice, LocalDate dateListed,
                    Integer numViews, PaperCraftType paperCraftType) {
    super(ID, name, owner, creators, suggestedPrice, dateListed, numViews);
    this.paperCraftType = paperCraftType;
  }

  public PaperCraftType getPaperCraftType() {
    return paperCraftType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof PaperCraft)) return false;
    if (!super.equals(o)) return false;
    PaperCraft that = (PaperCraft) o;
    return getPaperCraftType() == that.getPaperCraftType();
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getPaperCraftType());
  }

  @Override
  public String toString() {
    return "PaperCraft{" +
        "paperCraftType=" + paperCraftType +
        '}';
  }
}
