package basicclasses;

/**
 * This immutable class represents a person The person has a first name, last name and an
 * year of birth
 */
public class ImmutablePerson {
    private String firstName;
    private String lastName;
    private int yearOfBirth;

    /**
     * Constructs an ImmutablePerson object and initializes it
     * with the given first name, last name and year of birth
     * @param firstName the first name of this person
     * @param lastName the last name of this person
     * @param yearOfBirth the year of birth of this person
     */
    public ImmutablePerson(String firstName, String lastName, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
    }


    /**
     * Gets the first name of this ImmutablePerson.
     * @return the first name.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Gets the last name of this ImmutablePerson.
     * @return the last name.
     */
    public String getLastName() {
        return this.lastName;
    }


    /**
     * Gets the year of birth of this ImmutablePerson.
     * @return the year of birth.
     */
    public int getYearOfBirth() {
        return this.yearOfBirth;
    }

    /**
     * Creates a new ImmutablePerson with a different first name but the same last name and year of birth.
     * @param firstName The new first name.
     * @return A new ImmutablePerson object.
     */
    public ImmutablePerson changeFirstName(String firstName) {
        return new ImmutablePerson(firstName, this.lastName, this.yearOfBirth);
    }

    /**
     * Creates a new ImmutablePerson with a different first name but the same last name and year of birth.
     * @param lastName The new first name.
     * @return A new ImmutablePerson object.
     */
    public ImmutablePerson changeLastName(String lastName) {
        return new ImmutablePerson(this.firstName, lastName, this.yearOfBirth);
    }
}
