package Exercise3;

public class ContactType1 extends Contact {
    private String address;

    public ContactType1(String firstName, String lastName, String address) {
        super(firstName, lastName);
        this.address = address;
    }

    // Getter and Setter for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString() + ", Address: " + address;
    }
}
