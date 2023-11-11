package Exercise2;

import java.util.Date;


public class Loan {
    private int bookCode;
    private int memberId;
    private Date date;

    public Loan(int bookCode, int memberId, Date date) {
        this.bookCode = bookCode;
        this.memberId = memberId;
        this.date = date;
    }

    public boolean isOngoing() {
        
        return true;
    }
}
