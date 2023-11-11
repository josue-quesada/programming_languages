package Exercise2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

class Member {
    private int memberId;
    private String name;
    private String address;
    private List<Loan> loans;

    public Member(int memberId, String name, String address) {
        this.memberId = memberId;
        this.name = name;
        this.address = address;
        this.loans = new ArrayList<>();
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public int getBooksBorrowed() {
        return (int) loans.stream().filter(Loan::isOngoing).count();
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            Loan loan = new Loan(book.getCode(), memberId, new Date());
            loans.add(loan);
            book.setAvailable(false);
            System.out.println("Book borrowed by " + name + ": " + book.getTitle());
        } else {
            System.out.println("The book is not available for loan.");
        }
    }
}