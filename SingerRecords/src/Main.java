import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);

        Singers singer1 = new Singers();

        System.out.println("Default Values:");
        singer1.displaySingerDetails();

        System.out.println("\nPlease enter the following details for the singer:");

        System.out.print("Singer ID: ");
        int singerId = scanner.nextInt();
        singer1.setSingerId(singerId);

        scanner.nextLine(); // Consume the leftover newline

        System.out.print("Singer Name: ");
        String singerName = scanner.nextLine();
        singer1.setSingerName(singerName);

        System.out.print("Singer Address: ");
        String singerAddress = scanner.nextLine();
        singer1.setSingerAddress(singerAddress);

        System.out.print("Date of Birth (yyyy-mm-dd): ");
        String dobString = scanner.nextLine();
        LocalDate dateOfBirth = LocalDate.parse(dobString, DateTimeFormatter.ISO_LOCAL_DATE);
        singer1.setDateOfBirth(dateOfBirth);

        System.out.print("Number of Albums Published: ");
        int numberOfAlbums = scanner.nextInt();
        singer1.setNumberOfAlbumsPublished(numberOfAlbums);

        System.out.println("\nUpdated Values:");
        singer1.displaySingerDetails();

        scanner.close();
    }
}
