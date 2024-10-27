package models;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Transaction {
    private String date;
    private double amount;
    private String description;

    @Override
    public String toString() {
        return "Transaction{" +
                "date='" + date + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
