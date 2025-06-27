
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public int choice;
    public String newFileName;
    public String newFileData;
    public String fileName;

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        AddNotes addNotes = new AddNotes();
        ViewNotes viewNotes = new ViewNotes();
        while (true) {
            System.out.println("\nWelcome to Java Notes Application.");
            System.out.println("Choose Options:");
            System.out.println("1. Add Notes");
            System.out.println("2. View Notes");
            System.out.println("3. Exit\n");

            System.out.print("Enter your choice: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // consume invalid input
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Choice: Add Notes");
                    System.out.print("Enter New File Name: ");
                    newFileName = scanner.nextLine();
                    String file = newFileName +".txt";

                    System.out.println("Enter your Notes:");
                    newFileData = scanner.nextLine();

                    addNotes.writeFile(file, newFileData);
                    break;

                case 2:
                    System.out.println("Choice: View Notes");
                    System.out.print("Enter File Name: ");
                    fileName = scanner.nextLine();
                    String file1 = fileName +".txt";

                    viewNotes.viewFile(file1);
                    break;

                case 3:
                    System.out.println("Exiting....");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice! Please select between 1 to 3.");
            }
        }
    }

    public Main() throws IOException {
        start();
    }

    public static void main(String[] args) throws IOException {
        new Main();
    }
}
