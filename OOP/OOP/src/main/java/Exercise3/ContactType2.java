package Exercise3;


public class ContactType2 extends Contact {
    private String phoneNumber;

    public ContactType2(String firstName, String lastName, String phoneNumber) {
        super(firstName, lastName);
        this.phoneNumber = phoneNumber;
    }

    // Getter and Setter for phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return super.toString() + ", Phone Number: " + phoneNumber;
    }
}