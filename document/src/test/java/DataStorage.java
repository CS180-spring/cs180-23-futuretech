import java.util.Scanner;

public class DataStorage {
    public static void main(String[] args) {
        UserAccountImpl userAccount = new UserAccountImpl();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the FutureDB!");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Create Guest Account");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();
                    userAccount.login(loginUsername, loginPassword);
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    String registerUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String registerPassword = scanner.nextLine();
                    userAccount.register(registerUsername, registerPassword);
                    break;
                case 3:
                    userAccount.createGuestAccount();
                    break;
                case 4:
                    System.out.println("Thank you for using the FutureDB. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice. Please try again.");
                    break;
            }
        }
    }
}
