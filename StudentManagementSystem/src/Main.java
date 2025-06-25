import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    int studentId;
    String Name;
    String Branch;
    double pointer;

    @Override
    public String toString() {
        return "Student{" +
                "Student ID=" + studentId +
                ", Name='" + Name + '\'' +
                ", Branch='" + Branch + '\'' +
                ", Pointer=" + pointer +
                '}';
    }

    public Student(int studentId, String name, String branch, double pointer) {
        this.studentId = studentId;
        Name = name;
        Branch = branch;
        this.pointer = pointer;
    }
}

public class Main {
    public static void main(String[] args) {
        int counter = 0;
//        Created a Collections ArrayList with interface List for the index feature....
        List<Student> students = new ArrayList<Student>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter CURD Choice \n1.CREATE\n2.UPDATE\n3.READ\n4.DELETE\n5.EXIT");
            int choice = scanner.nextInt();
            switch (choice) {
//        CURD OPERATION--> CREATE
                case 1:
                    System.out.println("Enter Number of Student: ");
                    counter = scanner.nextInt();
                    for (int i = 1; i <= counter; i++) {
                        System.out.println("Enter Student Id: ");
                        int studentId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter Student Name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter Student Branch: ");
                        String branch = scanner.nextLine();
                        System.out.println("Enter Student Pointer: ");
                        double pointer = scanner.nextDouble();
                        Student student = new Student(studentId, name, branch, pointer);
                        students.add(student);
                    }
                    for (Student s : students) {
                        System.out.println(s);
                    }
                    break;
//          CURD OPERATION --> UPDATE
                case 2:
                    System.out.println("Update Student Id: ");
                    int updateID = scanner.nextInt();
                    for (Student s : students) {
                        if (updateID == s.studentId) {
                            System.out.println("What Your Want to Change:\n1.name \n2.branch \n3.pointer\n4.EXIT");
                            int c = scanner.nextInt();
                            if (c == 1) {
                                System.out.println("Enter New Name :");
                                scanner.nextLine();
                                String newName = scanner.nextLine();
                                s.Name = newName;
                            } else if (c == 2) {
                                System.out.println("Enter New Branch :");
                                scanner.nextLine();
                                String newBranch = scanner.nextLine();
                                s.Branch = newBranch;
                            } else if (c == 3) {
                                System.out.println("Enter New Pointer :");
                                double newPointer = scanner.nextDouble();
                                s.pointer = newPointer;
                            } else {
                                break;
                            }
                        }
                    }
                    break;

//          CURD OPERATION --> READ
                case 3:
                    if (students.isEmpty()) {
                        System.out.println("No students to display.");
                    } else {
                        for (Student s : students) {
                            System.out.println(s);
                        }
                    }
                    break;

//          CURD OPERATION --> DELETE
                case 4:
                    System.out.println("Delete Student Id: ");
                    int deleteID = scanner.nextInt();
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).studentId == deleteID) {
                            students.remove(i);
                            System.out.println("Student deleted.");
                            break;
                        } else {
                            System.out.println("NO ID Found!!!");
                        }
                    }
                    break;

//          EXIT
                case 5:
                    System.out.println("Exiting....");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Something Went Wrong!!!!!");
            }
        }
    }
}