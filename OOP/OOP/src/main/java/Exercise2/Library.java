package Exercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Member> members;
    private List<Book> books;

    public Library() {
        this.members = new ArrayList<>();
        this.books = new ArrayList<>();
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void showAvailableBooks() {
        System.out.println("Available books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book.getTitle() + " - " + book.getAuthor());
            }
        }
    }

    public void showMembersWithMoreThanThreeBooksBorrowed() {
        List<Member> membersWithMoreThanThreeBooks = members.stream()
                .filter(member -> member.getBooksBorrowed() > 3)
                .collect(Collectors.toList());

        System.out.println("Members with more than 3 books borrowed:");
        for (Member member : membersWithMoreThanThreeBooks) {
            System.out.println(member.getName() + " - Books borrowed: " + member.getBooksBorrowed());
        }
    }
}
