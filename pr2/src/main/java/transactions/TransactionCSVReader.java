package transactions;

import models.Transaction;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;

public class TransactionCSVReader {

    public static List<Transaction> readTransactions(String filePath) {
        return readFromFile(filePath, values -> {
            String date = values[0];
            double amount = Double.parseDouble(values[1]);
            String description = values[2];
            return new Transaction(date, amount, description);
        });
    }

    private static List<Transaction> readFromFile(String filePath, Function<String[], Transaction> mapper) {
        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(filePath).openStream(), StandardCharsets.UTF_8))) {
            reader.lines()
                    .map(line -> line.split(","))
                    .map(mapper)
                    .forEach(transactions::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}
