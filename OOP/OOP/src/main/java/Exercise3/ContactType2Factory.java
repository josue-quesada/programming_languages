package Exercise3;

public class ContactType2Factory implements ContactFactory {
    @Override
    public Contact createContact(String firstName, String lastName) {
        return new ContactType2(firstName, lastName, "Default Phone Number");
    }
}
