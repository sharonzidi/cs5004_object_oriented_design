package basicclasses;

/**
 * This class represents a person The person has a first name, last name and
 * year of birth.
 */
class Person {
    private String firstName;
    private String lastName;
    private int yearOfBirth;
    private static final int MIN_YEAR = 1800;


    /**
     * Constructs a Person object and initializes it
     * with the given first name, last name and year of birth
     * @param firstName the first name of this person
     * @param lastName the last name of this person
     * @param yearOfBirth the year of birth of this person, which must be greater than or equal to 1800
     */
    public Person(String firstName, String lastName, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = this.validYear(yearOfBirth);
    }

    /**
     * Helper method that ensures the year of birth is valid. If the year is invalid , the minimum allowable year is
     * returned.
     * @param year
     * @return
     */
    private int validYear(int year) {
        if (year >= MIN_YEAR) {
            return year;
        } else {
            return MIN_YEAR;
        }
    }

    /**
     * Get the first name of this person
     * @return the first name of this person
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Return the last name of this person
     * @return the last name of this person
     */

    public String getLastName() {
        return this.lastName;
    }

    /**
     * Return the year of birth of this person
     * @return the year of birth of this person
     */
    public int getYearOfBirth() {
        return this.yearOfBirth;
    }


    /**
     * Sets this person's first name
     * @param firstName the new first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    /**
     * Sets this person's last name
     * @param lastName the new last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
