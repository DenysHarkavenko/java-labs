package models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class PreviousOrders {
    private List<Order> orders;

    public PreviousOrders() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PreviousOrders history = (PreviousOrders) o;
        return Objects.equals(orders, history.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orders);
    }

    @Override
    public String toString() {
        return "PreviousOrders{" +
                "orders=" + orders +
                '}';
    }
}
