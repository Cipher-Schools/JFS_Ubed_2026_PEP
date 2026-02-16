package module1.oop.encapsulation;

// Encapsulation - data hiding using private fields and public getters/setters
public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;
    
    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }
    
    // Getter methods - provide read access
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getOwnerName() {
        return ownerName;
    }
    
    public double getBalance() {
        return balance;
    }
    
    // Setter with validation
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    
    // Business methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }
    
    public static void main(String[] args) {
        BankAccount account = new BankAccount("ACC001", "Alice", 1000.0);
        
        System.out.println("Owner: " + account.getOwnerName());
        System.out.println("Balance: $" + account.getBalance());
        
        account.deposit(500);
        account.withdraw(200);
        System.out.println("Final balance: $" + account.getBalance());
    }
}
