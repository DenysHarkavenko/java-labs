package transactions;

import models.Transaction;
import transactions.TransactionAnalyzer;

import java.time.LocalDate;
import java.util.*;

public abstract class TransactionReportGenerator {

    public static void printBalanceReport(double totalBalance) {
        System.out.println("Загальний баланс: " + totalBalance);
    }

    public static void printTransactionsCountByMonth(String monthYear, int count) {
        System.out.println("Кількість транзакцій за " + monthYear + ": " + count);
    }

    public static void printTopExpensesReport(List<Transaction> topExpenses) {
        System.out.println("10 найбільших витрат:");
        for (Transaction expense : topExpenses) {
            System.out.println(expense.getDescription() + ": " + expense.getAmount());
        }
    }

    public static void printCategoryExpensesReport(List<Transaction> transactions) {
        Map<String, Double> categoryExpenses = new HashMap<>();

        for (Transaction transaction : transactions) {
            if (transaction.getAmount() < 0) {
                String category = transaction.getDescription();
                categoryExpenses.put(category, categoryExpenses.getOrDefault(category, 0.0) + transaction.getAmount());
            }
        }

        System.out.println("Сумарні витрати по категоріях (\"*\" = 1000 грн):");
        for (Map.Entry<String, Double> entry : categoryExpenses.entrySet()) {
            String category = entry.getKey();
            double totalExpense = entry.getValue();
            System.out.print(category + ": ");
            int stars = (int)(-totalExpense / 1000);
            for (int i = 0; i < stars; i++) {
                System.out.print("*");
            }
            System.out.println(" (" + totalExpense + ")");
        }
    }

    public static void generateReports(List<Transaction> transactions, String monthYear, LocalDate startDate, LocalDate endDate) {
        double totalBalance = TransactionAnalyzer.calculateTotalBalance(transactions);
        printBalanceReport(totalBalance);
        System.out.println();

        int transactionsCount = TransactionAnalyzer.countTransactionsByMonth(monthYear, transactions);
        printTransactionsCountByMonth(monthYear, transactionsCount);
        System.out.println();

        Optional<Transaction> largestExpense = TransactionAnalyzer.findLargestExpense(transactions, startDate, endDate);
        Optional<Transaction> smallestExpense = TransactionAnalyzer.findSmallestExpense(transactions, startDate, endDate);

        if (largestExpense.isPresent()) {
            System.out.println("Найбільша витрата: " + largestExpense.get());
        } else {
            System.out.println("Не знайдено витрат за вказаний період.");
        }

        if (smallestExpense.isPresent()) {
            System.out.println("Найменша витрата: " + smallestExpense.get());
        } else {
            System.out.println("Не знайдено витрат за вказаний період.");
        }
        System.out.println();

        printCategoryExpensesReport(transactions);
    }
}

