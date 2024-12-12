import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Welcome to the Libarary ! \n");

//        creating dummy data for the testing purposes
        Library library = Dataset.createLibraryWithDummyData();

        Scanner scanner = new Scanner(System.in);

//      user login
        System.out.print("Enter your username: ");
        String userName = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

//       authenticating the user
        Member AuthenticatedMember = library.login(userName, password);

        if(AuthenticatedMember != null) {
            System.out.println("You have successfully logged in");
            if (AuthenticatedMember instanceof Librarian){
                MenuHandlerLibrarian librarianMenuHandler = new MenuHandlerLibrarian(AuthenticatedMember, scanner);
                librarianMenuHandler.displayMenu();
            }
            else{
                MenuHandler menuHandler = new MenuHandler(AuthenticatedMember, scanner);
                menuHandler.displayMenu();
            }
        }
        else{
            System.out.println("Login failed.");
        }


    }
}