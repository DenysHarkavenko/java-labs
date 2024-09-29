package tests;

import models.Transaction;
import transactions.TransactionCSVReader;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionCSVReaderTest {

    @Test
    public void testReadTransactionsWithCsvData() {
        String filePath = "https://informer.com.ua/dut/java/pr2.csv";

        List<Transaction> transactions = TransactionCSVReader.readTransactions(filePath);

        assertAll("Verify CSV content",
                () -> assertEquals(26, transactions.size(), "Size mismatch"),
                () -> assertEquals("05-12-2023", transactions.get(0).getDate(), "First transaction date mismatch"),
                () -> assertEquals(-7850.0, transactions.get(0).getAmount(), "First transaction amount mismatch"),
                () -> assertEquals("Сільпо", transactions.get(0).getDescription(), "First transaction description mismatch"),
                () -> assertEquals("07-12-2023", transactions.get(1).getDate(), "Second transaction date mismatch"),
                () -> assertEquals(-1200.0, transactions.get(1).getAmount(), "Second transaction amount mismatch"),
                () -> assertEquals("Аптека", transactions.get(1).getDescription(), "Second transaction description mismatch"),
                () -> assertEquals("10-12-2023", transactions.get(2).getDate(), "Third transaction date mismatch"),
                () -> assertEquals(80000.0, transactions.get(2).getAmount(), "Third transaction amount mismatch"),
                () -> assertEquals("Зарплата", transactions.get(2).getDescription(), "Third transaction description mismatch")
        );
    }
}
