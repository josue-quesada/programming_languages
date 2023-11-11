package Exercise2;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Member member1 = new Member(1, "John Doe", "123 Main St");
        Member member2 = new Member(2, "Jane Smith", "456 Oak St");
        Book book1 = new Book(101, "The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book(102, "To Kill a Mockingbird", "Harper Lee");
        Book book3 = new Book(103, "1984", "George Orwell");

        library.addMember(member1);
        library.addMember(member2);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        member1.borrowBook(book1);
        member1.borrowBook(book2);
        member2.borrowBook(book3);

        library.showAvailableBooks();

        library.showMembersWithMoreThanThreeBooksBorrowed();
    }
}