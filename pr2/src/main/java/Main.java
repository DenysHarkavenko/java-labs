import models.Transaction;
import transactions.TransactionCSVReader;
import transactions.TransactionReportGenerator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "https://informer.com.ua/dut/java/pr2.csv";
        List<Transaction> transactions = TransactionCSVReader.readTransactions(filePath);

        System.out.println("Усі транзакції:");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }

        String monthYear = "01-2024";
        LocalDate startDate = LocalDate.parse("01-01-2024", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate endDate = LocalDate.parse("31-01-2024", DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        TransactionReportGenerator.generateReports(transactions, monthYear, startDate, endDate);
    }
}

