import java.util.Scanner;

public class AddEmployee {
    int id;
    String name;
    int age;
    String department;
    Scanner scanner = new Scanner(System.in);

    void getInput() {
        System.out.print("Enter the Employee ID: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid ID (number): ");
            scanner.next();
        }
        id = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline

        System.out.print("Enter the Employee Name: ");
        name = scanner.nextLine();

        System.out.print("Enter the Age: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid age: ");
            scanner.next();
        }
        age = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline

        System.out.print("Enter the Department: ");
        department = scanner.nextLine();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }
}
