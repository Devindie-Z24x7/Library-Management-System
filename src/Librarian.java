import java.util.List;

public class Librarian extends Member {

    public Librarian(int memberId, String userName, String password, List<Book> booksBorrowed) {
        super(memberId, userName, password, booksBorrowed);
    }

    public Librarian(int memberId, String userName, String password) {
        super(memberId, userName, password);
    }

    public void RegisterMember(String userName, String password){
        int memberId = Library.getInstance().getMembers().size()+1;

        Member newMember = new Member(memberId,userName,password);
        Library.getInstance().addMember(newMember);

    }

    public void removeMember(int memberId){
        for (Member member : Library.getInstance().getMembers()){
            if(member.getMemberId() == memberId){
                Library.getInstance().removeMember(member);
                break;
            }

        }
    }

    public void viewMember(int memberId){
        for (Member member : Library.getInstance().getMembers()){
            if(member.getMemberId() == memberId){
                System.out.println("MemberId: " + member.getMemberId());
                System.out.println("UserName: " + member.getUserName());
                System.out.println("Books Borrowed: " + member.getBooksBorrowed());
            }

        }
    }

    public void displayMembers(){
        for (Member member : Library.getInstance().getMembers()){
            System.out.println("MemberId: " + member.getMemberId());
            System.out.println("UserName: " + member.getUserName());
            System.out.println("Books Borrowed: " + member.getBooksBorrowed());
        }
    }

    public void Addbook(int bookId, String title, String author, String category, int noOfCopies){
        Book newBook = new Book(bookId, title, author, category, noOfCopies);
        Library.getInstance().addBook(newBook);
    }

    public void removeBook(int BookId){
        for (Book book : Library.getInstance().getBooks()){
            if(book.getBookId() == BookId){
                Library.getInstance().removeBook(book);
                break;
            }

        }
    }

    public void displayBooks(){
        for (Book book : Library.getInstance().getBooks()){
            System.out.println("BookId: " + book.getBookId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Category: " + book.getCategory());
            System.out.println("Available No of Copies: " + book.getNoOfCopies());
        }
    }
}
