package Exercise3;

public class ContactType1Factory implements ContactFactory {
    @Override
    public Contact createContact(String firstName, String lastName) {
        return new ContactType1(firstName, lastName, "Default Address");
    }
}