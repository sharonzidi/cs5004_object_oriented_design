package pair;

   public class Posn extends GenericPair<Integer,Integer>{

      public Posn(Integer x, Integer y) {
        super(x, y);
    }
  /**
   * Getter for property 'x'.
   *
   * @return Value for property 'x'.
   */
  public Integer getX() {
    return getFirst();
      }
  /**
   * Setter for property 'x'.
   *
   * @param x Value to set for property 'x'.
   */
  public void setX(Integer x) {
    setFirst(x);
  }

  /**
   * Getter for property 'y'.
   *
   * @return Value for property 'y'.
   */
  public Integer getY() {
    return getSecond();
  }

  /**
   * Setter for property 'y'.
   *
   * @param y Value to set for property 'y'.
   */
  public void setY(Integer y) {
    setSecond(y);
  }

  public Double distanceTo(Posn other) {
      return Math.sqrt(Math.pow(this.getX() - other.getX(), 2) +
      Math.pow(this.getY() - other.getY(), 2));
    }

  @Override
  public String toString() {
      return "Posn{" + this.getX() + ", " + this.getY() + "}" ;
      }
   }