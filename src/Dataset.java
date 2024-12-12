import java.util.ArrayList;
import java.util.List;

public class Dataset {

    public static Library createLibraryWithDummyData() {
        Library library = Library.getInstance();

        // Creating dummy books
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "To Kill a Mockingbird", "Harper Lee", "Fiction", 5));
        books.add(new Book(2, "1984", "George Orwell", "Dystopian", 3));
        books.add(new Book(3, "The Great Gatsby", "F. Scott Fitzgerald", "Classic", 2));
        books.add(new Book(4, "Moby Dick", "Herman Melville", "Adventure", 2));
        books.add(new Book(5, "Pride and Prejudice", "Jane Austen", "Romance", 8));
        books.add(new Book(6, "The Catcher in the Rye", "J.D. Salinger", "Fiction", 4));
        books.add(new Book(7, "The Hobbit", "J.R.R. Tolkien", "Fantasy", 6));
        books.add(new Book(8, "War and Peace", "Leo Tolstoy", "Historical", 3));
        books.add(new Book(9, "The Odyssey", "Homer", "Epic", 1));
        books.add(new Book(10, "Crime and Punishment", "Fyodor Dostoevsky", "Philosophical", 2));

        // Adding books to the library
        for (Book book : books) {
            library.addBook(book);
        }

        // Creating dummy members
        List<Member> members = new ArrayList<>();
        members.add(new Librarian(1, "JohnDoe", "password123"));
        members.add(new Member(2, "JaneSmith", "securePass"));
        members.add(new Member(3, "BobBrown", "passw0rd"));
        members.add(new Member(4, "AliceJones", "alice2024"));
        members.add(new Member(5, "CharlieD", "charlie123"));

        // Adding members to the library
        for (Member member : members) {
            library.addMember(member);
        }

        return library;
    }
}
