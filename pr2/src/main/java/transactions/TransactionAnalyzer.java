package transactions;

import models.Transaction;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TransactionAnalyzer {

    public static double calculateTotalBalance(List<Transaction> transactions) {
        return transactions.stream().mapToDouble(Transaction::getAmount).sum();
    }

    public static int countTransactionsByMonth(String monthYear, List<Transaction> transactions) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return (int) transactions.stream()
                .map(transaction -> LocalDate.parse(transaction.getDate(), formatter))
                .filter(date -> date.format(DateTimeFormatter.ofPattern("MM-yyyy")).equals(monthYear))
                .count();
    }

    public static List<Transaction> findTopTenExpenses(List<Transaction> transactions) {
        return transactions.stream()
                .filter(transaction -> transaction.getAmount() < 0)
                .sorted(Comparator.comparingDouble(Transaction::getAmount))
                .limit(10)
                .toList();
    }

    public static Optional<Transaction> findLargestExpense(List<Transaction> transactions, LocalDate startDate, LocalDate endDate) {
        return findExpenseWithinRange(transactions, startDate, endDate, Comparator.comparingDouble(Transaction::getAmount));
    }

    public static Optional<Transaction> findSmallestExpense(List<Transaction> transactions, LocalDate startDate, LocalDate endDate) {
        return findExpenseWithinRange(transactions, startDate, endDate, Comparator.comparingDouble(Transaction::getAmount).reversed());
    }

    private static Optional<Transaction> findExpenseWithinRange(List<Transaction> transactions, LocalDate startDate, LocalDate endDate, Comparator<Transaction> comparator) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return transactions.stream()
                .filter(transaction -> transaction.getAmount() < 0)
                .filter(transaction -> {
                    LocalDate date = LocalDate.parse(transaction.getDate(), formatter);
                    return !date.isBefore(startDate) && !date.isAfter(endDate);
                })
                .min(comparator);
    }
}
