package Exercise3;

public abstract class Contact {
    private String firstName;
    private String lastName;

    public Contact(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "First Name: " + firstName + ", Last Name: " + lastName;
    }
}