package streams;

import java.util.Objects;

/**
 * Created by therapon on 7/11/16.
 */
public class Author {

    private String first;
    private String last;
    private Integer age;

    public Author(String first, String last, Integer age) {
        this.first = first;
        this.last = last;
        this.age = age;
    }


    /**
     * Getter for property 'first'.
     *
     * @return Value for property 'first'.
     */
    public String getFirst() {
        return first;
    }

    /**
     * Setter for property 'first'.
     *
     * @param first Value to set for property 'first'.
     */
    public void setFirst(String first) {
        this.first = first;
    }

    /**
     * Getter for property 'last'.
     *
     * @return Value for property 'last'.
     */
    public String getLast() {
        return last;
    }

    /**
     * Setter for property 'last'.
     *
     * @param last Value to set for property 'last'.
     */
    public void setLast(String last) {
        this.last = last;
    }

    /**
     * Getter for property 'age'.
     *
     * @return Value for property 'age'.
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Setter for property 'age'.
     *
     * @param age Value to set for property 'age'.
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Author author = (Author) other;
        return Objects.equals(first, author.first)
                && Objects.equals(last, author.last)
                && Objects.equals(age, author.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last, age);
    }

    @Override
    public String toString() {
        return "Author{"
                + "first='" + first + '\''
                + ", last='" + last + '\''
                + ", age=" + age
                + '}';
    }
}
