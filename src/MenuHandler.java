import java.util.Scanner;

public class MenuHandler {
    Member AuthenticatedMember;
    Scanner scanner;

    public MenuHandler(Member authenticatedMember, Scanner scanner) {
        this.AuthenticatedMember = authenticatedMember;
        this.scanner = scanner;
    }

    public void displayMenu() {
        boolean isLoggedIn = true;
        while (isLoggedIn) {
            System.out.println("\nWelcome, " + AuthenticatedMember.getUserName() + "! Choose an option:");
            System.out.println("1. Borrow a book");
            System.out.println("2. Check availability of a book");
            System.out.println("3. Check available books");
            System.out.println("4. Logout");

            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

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
                    isLoggedIn = false;
                    System.out.println("You have logged out successfully.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    void borrowBook() {
        System.out.print("Enter the ID of the book you want to borrow: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        // add the book to list of books borrowed by the user
        AuthenticatedMember.addBookToBorrowedList(bookId);
//       reducing the no of copies by 1 once a book is borrowed
        AuthenticatedMember.UpdatingNoofBooks(bookId);



    }
// check availability of a particular book
void checkBookAvailability() {
        System.out.print("Enter the ID of the book to check availability: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        AuthenticatedMember.checkAvailability(bookId);
    }

//    check available books
void checkAvailableBooks() {
        System.out.println("Available books:");
        AuthenticatedMember.checkAvailability();
    }

}
