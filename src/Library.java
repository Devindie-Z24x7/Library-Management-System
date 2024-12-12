import java.util.ArrayList;
import java.util.List;

public class Library {
    private static volatile Library instance; // Singleton instance
    private List<Member> Members;
    private List<Book> Books;

    private Library() {
        Members = new ArrayList<>();
        Books = new ArrayList<>();
    }

    // Method to get the single instance of Library
    public static Library getInstance() {
        if (instance == null) { // First check (no locking)
            synchronized (Library.class) {
                if (instance == null) { // Second check (with locking)
                    instance = new Library();
                }
            }
        }
        return instance;
    }

    public List<Member> getMembers() {
        return Members;
    }

    public void setMembers(List<Member> members) {
        Members = members;
    }

    public List<Book> getBooks() {
        return Books;
    }

    public void setBooks(List<Book> books) {
        Books = books;
    }

    public void addBook(Book book){
        Books.add(book);
    }

    public void removeBook(Book book){
        Books.remove(book);

    }


    public void addMember(Member member){
        Members.add(member);
    }

    public void removeMember(Member member){
        Members.remove(member);

    }

    public List<Book> checkAvailability(){
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : Books){
            if(book.getNoOfCopies() >0){
                availableBooks.add(book);
            }

        }
        return availableBooks;
    }

    public Member login(String userName, String password){
        for (Member member : Library.getInstance().getMembers()) {
            if (member.getUserName().equals(userName)) {
                if (member.verifyPassword(password)) {
                    return member; // Return the Member object if login is successful
                } else {
                    System.out.println("Invalid password.");
                    return null; // Return null if the password is incorrect
                }
            }
        }
        System.out.println("User not found.");
        return null; // Return null if the user is not found
    }




}
