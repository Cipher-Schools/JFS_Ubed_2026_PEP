package module1.oop.basics;

// Demonstrating 'this' keyword usage
public class Book {
    String title;
    String author;
    double price;
    
    // Constructor with parameters having same names as fields
    public Book(String title, String author, double price) {
        this.title = title;     // 'this' refers to instance variable
        this.author = author;
        this.price = price;
    }
    
    // Method using 'this' to return current object
    public Book updatePrice(double newPrice) {
        this.price = newPrice;
        return this; // returns current object
    }
    
    public void display() {
        System.out.println(title + " by " + author + " - $" + price);
    }
    
    public static void main(String[] args) {
        Book book = new Book("Java Basics", "John Doe", 29.99);
        book.display();
        
        book.updatePrice(24.99).display(); // method chaining
    }
}
