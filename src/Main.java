import java.util.Scanner;
import model.*;
import service.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static UserService userService = new UserService();
    private static ListingService listingService = new ListingService();
    private static BookingService bookingService = new BookingService();
    private static User currentUser = null;

    public static void main(String[] args) {
        System.out.println("Welcome to StudentRentals CLI!");

        while (true) {
            if (currentUser == null) showMainMenu();
            else if (currentUser instanceof Student) showStudentMenu();
            else if (currentUser instanceof Homeowner) showHomeownerMenu();
        }
    }

    private static void showMainMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. Register Student");
        System.out.println("2. Register Homeowner");
        System.out.println("3. Login");
        System.out.println("4. Exit");
        System.out.print("Choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> registerStudent();
            case 2 -> registerHomeowner();
            case 3 -> login();
            case 4 -> System.exit(0);
            default -> System.out.println("Invalid choice.");
        }
    }

    private static void showStudentMenu() {
        System.out.println("\n--- Student Menu ---");
        System.out.println("1. Search Listings");
        System.out.println("2. Request Booking");
        System.out.println("3. Logout");
        System.out.print("Choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> searchListings();
            case 2 -> requestBooking();
            case 3 -> logout();
            default -> System.out.println("Invalid choice.");
        }
    }

    private static void showHomeownerMenu() {
        System.out.println("\n--- Homeowner Menu ---");
        System.out.println("1. Create Listing");
        System.out.println("2. View Listings");
        System.out.println("3. Logout");
        System.out.print("Choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> createListing();
            case 2 -> viewListings();
            case 3 -> logout();
            default -> System.out.println("Invalid choice.");
        }
    }

    private static void registerStudent() {
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Email: "); String email = scanner.nextLine();
        System.out.print("Password: "); String password = scanner.nextLine();
        userService.registerStudent(name, email, password);
        System.out.println("Student registered!");
    }

    private static void registerHomeowner() {
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Email: "); String email = scanner.nextLine();
        System.out.print("Password: "); String password = scanner.nextLine();
        userService.registerHomeowner(name, email, password);
        System.out.println("Homeowner registered!");
    }

    private static void login() {
        System.out.print("Email: "); String email = scanner.nextLine();
        System.out.print("Password: "); String password = scanner.nextLine();
        currentUser = userService.login(email, password);
        if (currentUser == null) System.out.println("Login failed.");
        else System.out.println("Login successful! Welcome " + currentUser.getName());
    }

    private static void logout() {
        System.out.println("Logged out: " + currentUser.getName());
        currentUser = null;
    }

    private static void createListing() {
        System.out.print("Title: "); String title = scanner.nextLine();
        System.out.print("Price: "); double price = scanner.nextDouble(); scanner.nextLine();
        listingService.createListing(title, price, (Homeowner) currentUser);
    }

    private static void viewListings() {
        listingService.viewListings();
    }

    private static void searchListings() {
        System.out.println("Search Listings:");
        System.out.println("1. Search by keyword");
        System.out.println("2. Search by price range");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1 -> {
                System.out.print("Enter keyword: ");
                String keyword = scanner.nextLine();
                listingService.searchListingsByKeyword(keyword);
            }
            case 2 -> {
                System.out.print("Enter minimum price: ");
                double min = scanner.nextDouble();
                System.out.print("Enter maximum price: ");
                double max = scanner.nextDouble();
                scanner.nextLine(); 
                listingService.searchListingsByPrice(min, max);
            }
            default -> System.out.println("Invalid choice.");
        }
    }

    private static void requestBooking() {
        System.out.print("Enter Listing ID: "); int id = scanner.nextInt(); scanner.nextLine();
        bookingService.requestBooking(id, (Student) currentUser, listingService);
    }
}
