package module2.collections.set.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class QSEmailSorter {
    public static void main(String[] args) {
        // Use Set to remove duplicates from a list of email IDs and sort them.

        List<String> emails = new ArrayList<>();
        emails.add("alice@example.com");
        emails.add("bob@example.com");
        emails.add("charlie@example.com");
        emails.add("alice@example.com"); // Duplicate
        emails.add("david@example.com");
        emails.add("bob@example.com");   // Duplicate

        System.out.println("Original List: " + emails);

        // Remove duplicates and sort using TreeSet
        // TreeSet automatically sorts elements and removes duplicates
        Set<String> uniqueSortedEmails = new TreeSet<>(emails);

        System.out.println("Unique & Sorted: " + uniqueSortedEmails);
        
        // Alternative: HashSet + Collections.sort
        Set<String> uniqueEmails = new HashSet<>(emails);
        List<String> sortedList = new ArrayList<>(uniqueEmails);
        Collections.sort(sortedList);
        System.out.println("HashSet + Sort: " + sortedList);
    }
}
