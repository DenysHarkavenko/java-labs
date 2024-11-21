package org.example.order.processing;

import org.example.order.product.Product;

import java.util.List;

public class OrderManager {
    public <T extends Product> void processOrders(List<T> orders) {
        orders.forEach(order -> {
            Runnable orderTask = () -> {
                OrderProcessor<T> orderProcessor = new OrderProcessor<>(order);
                orderProcessor.process();
            };
            new Thread(orderTask).start();
        });
    }
}
