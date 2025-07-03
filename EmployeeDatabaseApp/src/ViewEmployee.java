import java.sql.*;

public class ViewEmployee {
    public void viewAll() {
        String url = "jdbc:mysql://localhost:3306/employee_db";
        String username = "root";
        String password = "2005";

        String query = "SELECT * FROM employees";

        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)
        ) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("\n--- Employee Records ---");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String department = resultSet.getString("department");

                System.out.printf("ID: %d | Name: %s | Age: %d | Department: %s%n", id, name, age, department);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
