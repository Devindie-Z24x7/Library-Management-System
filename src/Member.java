import java.util.*;
import org.mindrot.jbcrypt.BCrypt;

public class Member {
    private int MemberId;
    private String UserName;
    private String Password;
    private List<Book> BooksBorrowed;

    public Member(int memberId, String userName, String password, List<Book> booksBorrowed) {
        MemberId = memberId;
        UserName = userName;
        Password =  hashPassword(password);
        BooksBorrowed = booksBorrowed;
    }

    public Member(int memberId, String userName, String password) {
        MemberId = memberId;
        UserName = userName;
        Password = hashPassword(password);
        BooksBorrowed = new ArrayList<>();
    }

    public Member(String userName, String password) {
        UserName = userName;
        Password = password;
        BooksBorrowed = new ArrayList<>();
    }


    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean verifyPassword(String inputPassword) {
        return BCrypt.checkpw(inputPassword, Password);
    }


    public int getMemberId() {
        return MemberId;
    }

    public void setMemberId(int memberId) {
        MemberId = memberId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public List<Book> getBooksBorrowed() {
        return BooksBorrowed;
    }

    public void setBooksBorrowed(List<Book> booksBorrowed) {
        BooksBorrowed = booksBorrowed;
    }

    public void checkAvailability(int bookId) {
        Library library = Library.getInstance();
        List<Book> books = library.getBooks();
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                if (book.getNoOfCopies() >0) {
                    System.out.println("Book with ID " + bookId + " is available.");
                    return;
                } else {
                    System.out.println("Book with ID " + bookId + " is not available.");
                    return;
                }
            }
        }
        System.out.println("Book with ID " + bookId + " not found in the library.");
    }

    public void checkAvailability() {
        Library library = Library.getInstance();
        List<Book> availableBooks = library.checkAvailability();
        for (Book book : availableBooks) {
            System.out.println(book.getBookId()+"."+book.getTitle());
        }
    }

    public void UpdatingNoofBooks(int bookId) {
        for (Book book : Library.getInstance().checkAvailability()){
            if (book.getBookId() == bookId) {
                book.setNoOfCopies(book.getNoOfCopies()-1);
                break;

            }
        }
    }

    public void addBookToBorrowedList(int bookId) {
        boolean bookFound = false; // Flag to track if the book was found

        for (Book book : Library.getInstance().getBooks()) {
            if (book.getBookId() == bookId) {
                if (book.getNoOfCopies() >0) { // Check if the book is available
                    BooksBorrowed.add(book);
                    System.out.println("Book with ID " + bookId + " has been added to your borrowed list.");
                } else {
                    System.out.println("Book with ID " + bookId + " is not available.");
                }
                bookFound = true; // Mark the book as found
                break; // Exit the loop once the book is found and processed
            }
        }

        // If the book ID was not found in the library
        if (!bookFound) {
            System.out.println("Book with ID " + bookId + " not found in the library.");
        }
    }

}

