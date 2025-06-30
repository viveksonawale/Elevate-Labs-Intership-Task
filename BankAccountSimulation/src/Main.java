import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();
        while (true) {
            System.out.println("Enter Your Choice: ");
            System.out.println("1.Deposit Money");
            System.out.println("2.Withdraw Money");
            System.out.println("3.Show Balance");
            System.out.println("4.Show Transactions History");
            System.out.println("5.Exit");
            int choice = scanner.nextInt();
            switch (choice) {
//                Deposit Money
                case 1:
                    System.out.println("Enter Money Amount: ");
                    double amount = scanner.nextDouble();
                    account.deposit(amount);
                    break;
//                    Withdraw Money
                case 2:
                    System.out.println("Enter Money Amount: ");
                    double amountForWithdraw = scanner.nextDouble();
                    account.withdraw(amountForWithdraw);
                    break;
//                    Show Balance
                case 3:
                    account.showBalance();
                    break;
//                    Transaction history
                case 4:
                    account.printTransactionHistory();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
            }
        }
    }
}