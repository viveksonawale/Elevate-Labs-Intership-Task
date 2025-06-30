public class SavingAccount extends Account {
    private static final double MIN_BALANCE = 1000;

    @Override
    public void withdraw(double amount) {
        if ((balance - amount) < MIN_BALANCE) {
            System.out.println("Withdraw process is been denied!!!!");
            System.out.println("REASON: Minimum balance must be ₹" + MIN_BALANCE);
        } else {
            balance -= amount;
        }
    }
}
