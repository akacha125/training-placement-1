// Base class for bank account
class BankAccount {
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    // Get the current balance
    public double getBalance() {
        return balance;
    }

    // Print account details
    public void displayAccountInfo() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}

// Derived class for savings account (inherits from BankAccount)
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountHolder, double initialBalance, double interestRate) {
        super(accountHolder, initialBalance); // Call parent constructor
        this.interestRate = interestRate;
    }

    // Method to calculate interest
    public void applyInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest); // Add interest to balance
        System.out.println("Interest of " + interest + " applied. New balance: " + getBalance());
    }

    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Derived class for checking account (inherits from BankAccount)
class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String accountHolder, double initialBalance, double overdraftLimit) {
        super(accountHolder, initialBalance); // Call parent constructor
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance() + overdraftLimit) {
            super.withdraw(amount);
        } else {
            System.out.println("Overdraft limit exceeded. Withdrawal denied.");
        }
    }

    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}

// Main class to run the program
public class BankSystem {
    public static void main(String[] args) {
        // Create instances of BankAccount subclasses
        BankAccount savings = new SavingsAccount("John Doe", 1000, 3.0); // Savings Account
        BankAccount checking = new CheckingAccount("Jane Smith", 500, 200); // Checking Account

        // Display initial information
        System.out.println("Savings Account Info:");
        savings.displayAccountInfo();
        System.out.println("\nChecking Account Info:");
        checking.displayAccountInfo();

        // Perform transactions
        System.out.println("\nDepositing 200 to Savings Account...");
        savings.deposit(200);

        System.out.println("\nWithdrawing 150 from Checking Account...");
        checking.withdraw(150);

        System.out.println("\nApplying interest to Savings Account...");
        ((SavingsAccount) savings).applyInterest();

        System.out.println("\nWithdrawing 800 from Checking Account...");
        checking.withdraw(800);

        // Final account info
        System.out.println("\nFinal Savings Account Info:");
        savings.displayAccountInfo();
        System.out.println("\nFinal Checking Account Info:");
        checking.displayAccountInfo();
    }
}
