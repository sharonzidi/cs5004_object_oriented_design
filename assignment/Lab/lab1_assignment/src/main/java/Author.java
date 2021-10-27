public class Author {
    /** * Represents an Author with their details--name, email and physical address *
     *
     * @author therapon *
     *
     */

    //private String name;
    private Person person;
    private String email;
    private String address;

    /**
     * Creates a new author given the author's name, email and address as strings
     * @param person the person's name
     * @param email the author's email address
     * @param address the authors physical address
     */

    public Author(Person person, String email, String address){
        this.person = person;
        this.email = email;
        this.address = address;
    }

    /**
     *
     * @return the first name
     */
    public String getFirst_name() {
        return this.person.getFirst_name();
    }

    /**
     *
     * @return the last name
     */
    public String getLast_name() {
        return this.person.getLast_name();
    }

    /**
     *
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     *
     * @return the address
     */
    public String getAddress() {
        return this.address;
    }
}
