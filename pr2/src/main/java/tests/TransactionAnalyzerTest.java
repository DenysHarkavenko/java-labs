package tests;

import models.Transaction;
import transactions.TransactionAnalyzer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionAnalyzerTest {

    @Test
    public void testTopTenExpensesSortedCorrectly() {
        List<Transaction> transactions = List.of(
                new Transaction("01-12-2023", -150.0, "Кав'ярня"),
                new Transaction("05-12-2023", -7850.0, "Сільпо"),
                new Transaction("07-12-2023", -1200.0, "Аптека"),
                new Transaction("10-12-2023", 80000.0, "Зарплата"),
                new Transaction("12-12-2023", 1500.0, "Авторські винагороди"),
                new Transaction("14-12-2023", -3200.0, "Комунальні послуги"),
                new Transaction("16-12-2023", -5000.0, "Ресторан"),
                new Transaction("17-12-2023", -200.0, "Кінотеатр"),
                new Transaction("18-12-2023", -2500.0, "Магазин електроніки"),
                new Transaction("19-12-2023", -450.0, "Супермаркет"),
                new Transaction("20-12-2023", -50.0, "Книга"),
                new Transaction("21-12-2023", -15000.0, "Нова техніка"),
                new Transaction("22-12-2023", -6000.0, "Подорож")
        );

        List<Transaction> topExpenses = TransactionAnalyzer.findTopTenExpenses(transactions);

        assertEquals(10, topExpenses.size());

        for (int i = 1; i < topExpenses.size(); i++) {
            assertTrue(topExpenses.get(i - 1).getAmount() <= topExpenses.get(i).getAmount(),
                    "Транзакції не відсортовані за спаданням витрат");
        }
    }

    @Test
    public void testNoExpensesReturnedForPositiveTransactions() {
        List<Transaction> transactions = List.of(
                new Transaction("01-12-2023", 150.0, "Кав'ярня"),
                new Transaction("05-12-2023", 7850.0, "Сільпо"),
                new Transaction("07-12-2023", 1200.0, "Аптека"),
                new Transaction("10-12-2023", 80000.0, "Зарплата")
        );

        List<Transaction> topExpenses = TransactionAnalyzer.findTopTenExpenses(transactions);

        assertTrue(topExpenses.isEmpty(), "Список витрат не повинен містити позитивні транзакції");
    }

    @Test
    public void testTopTenExpensesWhenFewerThanTenExpensesExist() {
        List<Transaction> transactions = List.of(
                new Transaction("05-12-2023", -7850.0, "Сільпо"),
                new Transaction("07-12-2023", -1200.0, "Аптека")
        );

        List<Transaction> topExpenses = TransactionAnalyzer.findTopTenExpenses(transactions);

        assertEquals(2, topExpenses.size());
        assertEquals(-7850.0, topExpenses.get(0).getAmount());
        assertEquals(-1200.0, topExpenses.get(1).getAmount());
    }
}
