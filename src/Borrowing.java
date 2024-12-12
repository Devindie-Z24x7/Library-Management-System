import java.time.LocalDate;

public class Borrowing {
    private int BorrowerId;
    private int BookId;
    private LocalDate BorrowDate;
    private LocalDate DueDate;

    public Borrowing(int borrowerId, int bookId) {
        BorrowerId = borrowerId;
        BookId = bookId;
        BorrowDate = LocalDate.now();
        DueDate = BorrowDate.plusWeeks(1);
    }

    public int getBorrowerId() {
        return BorrowerId;
    }

    public void setBorrowerId(int borrowerId) {
        BorrowerId = borrowerId;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }

    public LocalDate getBorrowDate() {
        return BorrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        BorrowDate = borrowDate;
    }

    public LocalDate getDueDate() {
        return DueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        DueDate = dueDate;
    }
}

