import java.util.Scanner;

public class Main {
    //    Function Addition
    public static int addition(int n1, int n2) {
        return n1 + n2;
    }

    //    Function Subtraction
    public static int substraction(int n1, int n2) {
        return n1 - n2;
    }

    //    Function Multiplication
    public static int multiplication(int n1, int n2) {
        return n1 * n2;
    }

    //    Function Division
    public static double division(int n1, int n2) {
        double divResult = 0;
        try {
            divResult = (double) n1 / n2;
        } catch (ArithmeticException e) {
            System.out.println("Error : Cannot Divde By Zero");
        }
        return divResult;
    }

    public static void main(String[] args) {
        System.out.println("*------Welcome To Java Simple Calculator!-----*");
        while (true) {
            int result = 0;
            double resultdouble = 0.0d;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Operator [+,-,*,/,E] :");
            char operator = scanner.next().charAt(0);
            if (operator == 'e' || operator == 'E') {
                System.out.println("Exiting....");
                System.exit(0);
            }
            System.out.println("Enter Number:");
            int num1 = scanner.nextInt();
            System.out.println("Enter Number:");
            int num2 = scanner.nextInt();
            switch (operator) {
                case '+':
                    result = addition(num1, num2);
                    System.out.println("Output:" + result);
                    break;
                case '-':
                    result = substraction(num1, num2);
                    System.out.println("Output:" + result);
                    break;
                case '*':
                    result = multiplication(num1, num2);
                    System.out.println("Output:" + result);
                    break;
                case '/':
                    resultdouble = division(num1, num2);
                    System.out.println("Output:" + resultdouble);
                    break;
                default:
                    System.out.println("Something Went Wrong!!!");
            }
        }
    }
}
