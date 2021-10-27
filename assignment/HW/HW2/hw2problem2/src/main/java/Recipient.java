
public class Recipient {
    private String firstName;
    private String lastName;
    private String email;


    public Recipient(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public boolean equals(Recipient another){
        return this.firstName == another.firstName &&
                this.lastName == another.lastName &&
                this.email == another.email;
    }
}
