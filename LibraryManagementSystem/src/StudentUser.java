public class StudentUser extends User {
    public StudentUser(int userId, String name) {
        super(userId, name);
    }

    @Override
    public void displayUser() {
        System.out.println("StudentUser [ID: " + userId + ", Name: " + name + "]");
    }
}
