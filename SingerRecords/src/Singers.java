import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Singers {

    private int singerId;
    private String singerName;
    private String singerAddress;
    private LocalDate dateOfBirth;
    private int numberOfAlbumsPublished;

    public Singers() {
        this.singerId = 0;
        this.singerName = "Unknown";
        this.singerAddress = "Unknown";
        this.dateOfBirth = LocalDate.of(1900, 1, 1); // Default to Jan 1, 1900
        this.numberOfAlbumsPublished = 0;
    }

    public Singers(int singerId, String singerName, String singerAddress, LocalDate dateOfBirth, int numberOfAlbumsPublished) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.singerAddress = singerAddress;
        this.dateOfBirth = dateOfBirth;
        this.numberOfAlbumsPublished = numberOfAlbumsPublished;
    }

    public void setSingerId(int singerId) {
        if (singerId > 0) {
            this.singerId = singerId;
        } else {
            System.out.println("Invalid singer ID. Must be positive.");
        }
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public void setSingerAddress(String singerAddress) {
        this.singerAddress = singerAddress;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setNumberOfAlbumsPublished(int numberOfAlbumsPublished) {
        if (numberOfAlbumsPublished >= 0) {
            this.numberOfAlbumsPublished = numberOfAlbumsPublished;
        } else {
            System.out.println("Invalid number of albums. Must be non-negative.");
        }
    }

    public int getSingerId() {
        return singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public String getSingerAddress() {
        return singerAddress;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getNumberOfAlbumsPublished() {
        return numberOfAlbumsPublished;
    }

    public void displaySingerDetails() {
        System.out.println("Singer ID: " + singerId);
        System.out.println("Singer Name: " + singerName);
        System.out.println("Singer Address: " + singerAddress);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Number of Albums Published: " + numberOfAlbumsPublished);
    }
}

