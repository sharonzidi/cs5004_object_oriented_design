package Model;

import static Controller.Commands.INDEX_SEVEN;
import static Controller.Commands.INDEX_TWO;

import Controller.Commands;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.util.Objects;

/**
 * A class representing the data structure of todo
 */
public class ToDo {
  private Map<String, String> parameters;
  private Builder builder;
  private String text;
  private Boolean completed;
  private LocalDate due;
  private Integer priority;
  private String category;
  private Integer id;

  /**
   * The constructor of ToDo class.
   * @param builder the builder class.
   * @param parameters the input hashMap contains the information about a ToDo.
   */
  public ToDo(Builder builder, Map<String, String> parameters){
    this.text = builder.text;
    this.completed =  builder.completed;
    this.due = builder.due;
    this.priority = builder.priority;
    this.category = builder.category;
  }

  /**
   * The method to set the ID.
   * @param id
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * The method to set the completed to be true.
   */
  public void setCompleted() {
    this.completed = true;
  }

  /**
   * Getter for the ID.
   * @return the id.
   */
  public Integer getID() {
    return this.id;
  }

  /**
   * A method to get the situation of completion.
   * @return the situation of completion.
   */
  public boolean isCompleted() {
    return this.completed;
  }

  /**
   * Getter of the Text
   * @return the Text
   */
  public String getText() {
    return this.text;
  }

  /**
   * Getter of the due
   * @return the due
   */
  public LocalDate getDue() {
    return this.due;
  }

  /**
   * Getter of the priority
   * @return the priority
   */
  public Integer getPriority() {
    return this.priority;
  }

  /**
   * Getter of the category
   * @return the category
   */
  public String getCategory() {
    return this.category;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    ToDo toDo = (ToDo) o;
    return Objects.equals(this.getText(), toDo.getText()) && Objects
        .equals(this.isCompleted(), toDo.isCompleted()) && Objects
        .equals(this.getDue(), toDo.getDue()) && Objects
        .equals(this.getPriority(), toDo.getPriority()) && Objects
        .equals(this.getCategory(), toDo.getCategory());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getText(), this.isCompleted(), this.getDue(), this.getPriority(),
        this.getCategory());
  }

  @Override
  public String toString() {
    return "ToDo{" +
        "id=" + this.id +
        ", text='" + this.text + '\'' +
        ", completed=" + this.completed +
        ", due=" + this.due +
        ", priority=" + this.priority +
        ", category='" + this.category + '\'' +
        '}';
  }

  /**
   * A class representing the fields and methods of the Builder.
   */
  public static class Builder{
    private Map<String, String> parameters;
    private String text;
    private Boolean completed;
    private LocalDate due;
    private Integer priority;
    private String category;

    /**
     * The constructor of the Builder class.
     * @param parameters the input hashMap contains the information about a ToDo.
     */
    public Builder(Map<String, String> parameters){
      this.parameters = parameters;
      this.text=parameters.get(Commands.TODO_TEXT.substring(INDEX_SEVEN));
      this.completed =false;   //Defaulted

      completed(parameters);
      due(parameters);
      priority(parameters);
      category(parameters);
      Build();

    }

    /**
     * A method to a analyse and extract the completed from a input hashMap
     * @param parameters a input hashMap
     * @return a Builder
     */
    public  Builder completed(Map<String, String> parameters){
      if (parameters.containsKey(Commands.COMPLETED.substring(INDEX_TWO))
          && parameters.get(Commands.COMPLETED.substring(INDEX_TWO)) != null)
        this.completed = Boolean.parseBoolean(parameters.get(Commands.COMPLETED.substring(INDEX_TWO)));
      else{
      this.completed = false;}
      return this;
    }
    /**
     * A method to a analyse and extract the due from a input hashMap
     * @param parameters a input hashMap
     * @return a Builder
     */
    public  Builder due(Map<String, String> parameters){
      if (parameters.containsKey(Commands.DUE.substring(INDEX_TWO)) &&
          parameters.get(Commands.DUE.substring(INDEX_TWO)) != null) {
        String input = parameters.get(Commands.DUE.substring(INDEX_TWO));
        DateTimeFormatter pattern1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter pattern2 = DateTimeFormatter.ofPattern("M/dd/yyyy");
        DateTimeFormatter pattern3 = DateTimeFormatter.ofPattern("MM/d/yyyy");
        try {
          LocalDate ld = LocalDate.parse(input, pattern1);
          this.due = ld;
        } catch (DateTimeParseException exp) {
          System.err.println("Failed to parse input using first pattern");
          try {
            LocalDate ld = LocalDate.parse(input, pattern2);
            this.due = ld;
          } catch (DateTimeParseException exp2) {
            System.err.println("Failed to parse input using second pattern");
          }
          try {
            LocalDate ld = LocalDate.parse(input, pattern3);
            this.due = ld;
          } catch (DateTimeParseException exp3) {
            System.err.println("Failed to parse input using third pattern");
          }
        }
      }else{
      this.due = null;}
      return this;
    }

    /**
     * A method to a analyse and extract the priority from a input hashMap
     * @param parameters a input hashMap
     * @return a Builder
     */
    public  Builder priority( Map<String, String> parameters){
      final Integer DEFAULT_PRIORITY = 3;
      if (parameters.containsKey(Commands.PRIORITY.substring(INDEX_TWO)) &&
          parameters.get(Commands.PRIORITY.substring(INDEX_TWO)) != null) {
        this.priority = Integer.parseInt(parameters.get(Commands.PRIORITY.substring(INDEX_TWO)));
      } else if ( parameters.get(Commands.PRIORITY.substring(INDEX_TWO)) == null){
        this.priority = null;
      }
        else{
        this.priority = DEFAULT_PRIORITY;
      }
      return this;
    }
    /**
     * A method to a analyse and extract the category from a input hashMap
     * @param parameters a input hashMap
     * @return a Builder
     */
    public  Builder category(Map<String, String> parameters){
      if (parameters.containsKey(Commands.CATEGORY.substring(INDEX_TWO))) {
        this.category = parameters.get(Commands.CATEGORY.substring(INDEX_TWO));
      }else{
      this.category = null;}
      return this;
    }
    /**
     * A method to generate a ToDo in the Builder class.
     * @return a ToDo generated inside the Builder class.
     */
    public ToDo Build(){
      return new ToDo(this, this.parameters);
    }
  }
}
