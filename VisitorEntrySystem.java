import java.util.ArrayList;
import java.util.Scanner;

public class VisitorEntrySystem {

    private static final ArrayList<Visitor> visitorList = new ArrayList<>();

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            int choice;

            do {
                System.out.println("\n===== Visitor Entry Tracking System =====");
                System.out.println("1. Add Visitor");
                System.out.println("2. Record Exit");
                System.out.println("3. Display All Visitors");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input!");
                    sc.next();
                    continue;
                }

                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1 -> {
                        System.out.print("Enter Visitor Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Purpose of Visit: ");
                        String purpose = sc.nextLine();

                        Visitor v = new Visitor(name, purpose);
                        visitorList.add(v);

                        System.out.println("Visitor Added! ID: " + v.getId());
                    }

                    case 2 -> {
                        System.out.print("Enter Visitor ID: ");

                        if (!sc.hasNextInt()) {
                            System.out.println("Invalid ID!");
                            sc.next();
                            continue;
                        }

                        int id = sc.nextInt();
                        sc.nextLine();

                        boolean found = false;

                        for (Visitor v : visitorList) {
                            if (v.getId() == id) {
                                v.recordExit();
                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("Visitor not found!");
                        }
                    }

                    case 3 -> {
                        if (visitorList.isEmpty()) {
                            System.out.println("No visitors yet.");
                        } else {
                            visitorList.forEach(Visitor::display);
                        }
                    }

                    case 4 -> System.out.println("Exiting...");

                    default -> System.out.println("Invalid choice!");
                }

            } while (true);
        }
    }
}