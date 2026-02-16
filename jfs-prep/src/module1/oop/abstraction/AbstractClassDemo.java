package module1.oop.abstraction;

// Abstract class - cannot be instantiated, may have abstract methods
abstract class BankAccount {
    protected String accountNumber;
    protected double balance;
    
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    // Abstract method - no implementation, must be overridden
    public abstract void calculateInterest();
    
    // Concrete method - has implementation
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }
    
    public void display() {
        System.out.println("Account: " + accountNumber + ", Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate = 0.04;
    
    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
    
    @Override
    public void calculateInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest added: $" + interest);
    }
}

class CurrentAccount extends BankAccount {
    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
    
    @Override
    public void calculateInterest() {
        System.out.println("No interest for current account");
    }
}

public class AbstractClassDemo {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("SAV001", 10000);
        savings.display();
        savings.calculateInterest();
        savings.display();
        
        System.out.println();
        
        BankAccount current = new CurrentAccount("CUR001", 5000);
        current.display();
        current.calculateInterest();
    }
}
