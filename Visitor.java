import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Visitor {

    private static int counter = 1;

    private final int id;
    private final String name;
    private final String purpose;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public Visitor(String name, String purpose) {
        this.id = counter++;
        this.name = name;
        this.purpose = purpose;
        this.entryTime = LocalDateTime.now();
        this.exitTime = null;
    }

    public int getId() {
        return id;
    }

    public void recordExit() {
        if (this.exitTime == null) {
            this.exitTime = LocalDateTime.now();
            System.out.println("Exit recorded successfully!");
        } else {
            System.out.println("Exit already recorded!");
        }
    }

    public void display() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println("ID         : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Purpose    : " + purpose);
        System.out.println("Entry Time : " + entryTime.format(formatter));

        if (exitTime != null) {
            System.out.println("Exit Time  : " + exitTime.format(formatter));

            Duration duration = Duration.between(entryTime, exitTime);
            System.out.println("Duration   : " + duration.toMinutes() + " minutes");
        } else {
            System.out.println("Exit Time  : Not Exited Yet");
            System.out.println("Duration   : Still inside");
        }

        System.out.println("----------------------------------");
    }
}