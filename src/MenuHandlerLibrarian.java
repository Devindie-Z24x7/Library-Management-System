import java.util.Scanner;

public class MenuHandlerLibrarian extends MenuHandler {

    // Constructor, passes the authenticated member and scanner to the superclass
    public MenuHandlerLibrarian(Member authenticatedMember, Scanner scanner) {
        super(authenticatedMember, scanner);
    }

    @Override
    public void displayMenu() {
        boolean isLoggedIn = true;
        System.out.println("\nWelcome, " + AuthenticatedMember.getUserName() + " (Librarian)! Choose an option:");
        while (isLoggedIn) {
            // Accessing the AuthenticatedMember from the parent class
            System.out.println("1. Borrow a book");
            System.out.println("2. Check availability of a book");
            System.out.println("3. Check available books");
            System.out.println("4. Return a book");
            System.out.println("5. Register a new member");
            System.out.println("6. Remove a member");
            System.out.println("7. Add a book");
            System.out.println("8. Remove a book");
            System.out.println("9. Logout");

            System.out.print("Enter your choice (1-9): ");
            int choice = scanner.nextInt(); // Use scanner to take input
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    borrowBook();
                    break;
                case 2:
                    checkBookAvailability();
                    break;
                case 3:
                    checkAvailableBooks();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    registerMember();
                    break;
                case 6:
                    removeMember();
                    break;
                case 7:
                    addBook();
                    break;
                case 8:
                    removeBook();
                    break;
                case 9:
                    isLoggedIn = false;
                    System.out.println("You have logged out successfully.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
            }
        }
    }

    // Adding a book
    private void addBook() {
        System.out.print("Enter the book ID: ");
        int bookId = scanner.nextInt();  // Use scanner to get the book ID
        scanner.nextLine(); // Consume the newline

        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter the book author: ");
        String author = scanner.nextLine();

        System.out.print("Enter the book category: ");
        String category = scanner.nextLine();

        System.out.print("Enter the number of copies: ");
        int noOfCopies = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        // Add the new book via the Librarian instance
        ((Librarian) AuthenticatedMember).Addbook(bookId, title, author, category, noOfCopies);
    }

    // Removing a book
    private void removeBook() {
        System.out.print("Enter the book ID to remove: ");
        int bookId = scanner.nextInt();  // Get the book ID from the user

        // Removing the book via the Librarian instance
        ((Librarian) AuthenticatedMember).removeBook(bookId);
    }

    // Register a new member
    private void registerMember() {
        System.out.print("Enter the new member's username: ");
        String userName = scanner.nextLine();

        System.out.print("Enter the new member's password: ");
        String password = scanner.nextLine();

        // Register the new member via the Librarian instance
        ((Librarian) AuthenticatedMember).RegisterMember(userName, password);
    }

    // Removing a member
    private void removeMember() {
        System.out.print("Enter the member ID to remove: ");
        int memberId = scanner.nextInt();  // Get the member ID from the user
        scanner.nextLine(); // Consume the newline

        // Remove the member via the Librarian instance
        ((Librarian) AuthenticatedMember).removeMember(memberId);
    }
}
