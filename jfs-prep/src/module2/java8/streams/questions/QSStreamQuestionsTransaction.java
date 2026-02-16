package module2.java8.streams.questions;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Transaction {
    String name;
    int amount;

    Transaction(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
}

public class QSStreamQuestionsTransaction {
    public static void main(String[] args) {
        // Goal: Compute total amount per user using streams.
        
        List<Transaction> transactions = List.of(
            new Transaction("test1", 100),
            new Transaction("test2", 500),
            new Transaction("test1", 300),
            new Transaction("test2", 100),
            new Transaction("test3", 1000),
            new Transaction("test3", 50),
            new Transaction("test1", 10),
            new Transaction("test3", 200)
        );

        // Group by name and sum the amounts
        // Collectors.groupingBy(classifier, downstream)
        // classifier: Transaction::getName (Key)
        // downstream: Collectors.summingInt(Transaction::getAmount) (Value)
        Map<String, Integer> result = transactions.stream()
            .collect(Collectors.groupingBy(
                Transaction::getName, 
                Collectors.summingInt(Transaction::getAmount)
            ));

        System.out.println("Total Amount Per User: " + result);
    }
}
