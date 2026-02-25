package example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 */
public class SimpleBankAccount implements BankAccount {

    private double balance; // TDD: minimize accessibility of class members
    private final AccountHolder holder; // TDD: minimize mutability

    public SimpleBankAccount(final AccountHolder holder, final double balance) {
        this.holder = holder;
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public boolean deposit(final int userID, final double amount) {
        boolean result = false;

        if (checkUser(userID)) {
            this.balance += amount;
            result = true;
        }
        return result;
    }

    @Override
    public void withdraw(final int userID, final double amount) {

        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            this.balance -= amount;
            this.balance -= 1; // TDD: do not abuse obscure operators (+=,--)
        }
    }

    private boolean isWithdrawAllowed(final double amount){
        return this.balance >= amount;
    }

    private boolean checkUser(final int id) {
        return this.holder.id() == id;
    }
}
