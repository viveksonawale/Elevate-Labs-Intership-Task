import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/employee_db";
        String username = "root";
        String password = "2005";

        Connection connection = null;
        Scanner scanner = new Scanner(System.in);
        AddEmployee addEmployee = new AddEmployee();
        ViewEmployee viewEmployee = new ViewEmployee();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("✅ MySQL Connection Successful!");

            while (true) {
                System.out.println("\nChoose an option:");
                System.out.println("1. Add Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1: {
                        String query = "INSERT INTO employees (id, name, age, department) VALUES (?, ?, ?, ?)";
                        PreparedStatement preparedStatement = connection.prepareStatement(query);
                        addEmployee.getInput(); // assumes you fill id, name, age, department
                        preparedStatement.setInt(1, addEmployee.getId());
                        preparedStatement.setString(2, addEmployee.getName());
                        preparedStatement.setInt(3, addEmployee.getAge());
                        preparedStatement.setString(4, addEmployee.getDepartment());

                        int rowsInserted = preparedStatement.executeUpdate();
                        System.out.println(rowsInserted > 0 ? "✅ Employee added!" : "⚠️ Insert failed.");
                        preparedStatement.close();
                        break;
                    }
                    case 2: {
                        viewEmployee.viewAll();
                        break;
                    }
                    case 3: {
                        System.out.print("Enter ID of user to update: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();

                        System.out.print("Enter new age: ");
                        int newAge = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter new department: ");
                        String newDept = scanner.nextLine();

                        String updateSQL = "UPDATE employees SET name = ?, age = ?, department = ? WHERE id = ?";
                        PreparedStatement updateStmt = connection.prepareStatement(updateSQL);
                        updateStmt.setString(1, newName);
                        updateStmt.setInt(2, newAge);
                        updateStmt.setString(3, newDept);
                        updateStmt.setInt(4, updateId);

                        int updated = updateStmt.executeUpdate();
                        System.out.println("✅ Rows updated: " + updated);
                        updateStmt.close();
                        break;
                    }
                    case 4: {
                        System.out.print("Enter ID of user to delete: ");
                        int deleteId = scanner.nextInt();

                        String deleteSQL = "DELETE FROM employees WHERE id = ?";
                        PreparedStatement deleteStmt = connection.prepareStatement(deleteSQL);
                        deleteStmt.setInt(1, deleteId);

                        int deleted = deleteStmt.executeUpdate();
                        System.out.println("❌ Rows deleted: " + deleted);
                        deleteStmt.close();
                        break;
                    }
                    case 5: {
                        System.out.println("Exiting....");
                        return;
                    }
                    default:
                        System.out.println("❌ Invalid choice!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace(); // Print full error for debugging
        } finally {
            if (connection != null) connection.close();
            scanner.close();
        }
    }
}
