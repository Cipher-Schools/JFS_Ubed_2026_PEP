package module2.collections.basics.map.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Contact {
    String name;
    String email;

    public Contact(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Email: " + email;
    }
}

public class QSContactList {
    private static Map<String, Contact> contacts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Build a contact list using Map<PhoneNumber, Contact>
        
        while (true) {
            System.out.println("\n1. Add Contact\n2. Search Contact\n3. Delete Contact\n4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    searchContact();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void addContact() {
        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        contacts.put(phone, new Contact(name, email));
        System.out.println("Contact added successfully.");
    }

    private static void searchContact() {
        System.out.print("Enter Phone Number to Search: ");
        String phone = scanner.nextLine();
        Contact contact = contacts.get(phone);
        
        if (contact != null) {
            System.out.println("Found: " + contact);
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void deleteContact() {
        System.out.print("Enter Phone Number to Delete: ");
        String phone = scanner.nextLine();
        
        if (contacts.remove(phone) != null) {
            System.out.println("Contact deleted.");
        } else {
            System.out.println("Contact not found.");
        }
    }
}
