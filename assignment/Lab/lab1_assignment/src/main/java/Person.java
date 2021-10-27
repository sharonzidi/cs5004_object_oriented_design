public class Person {
    private String first_name;
    private String last_name;

    public Person(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String setFirst_name(String first_name) {
        return this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String setLast_name(String last_name) {
        return this.last_name = last_name;
    }

}
