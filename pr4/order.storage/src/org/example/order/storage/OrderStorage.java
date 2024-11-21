package org.example.order.storage;

import org.example.order.product.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderStorage {
    private List<Product> orders = new ArrayList<>();

    public void addOrder(Product product) {
        orders.add(product);
    }

    public List<Product> getOrders() {
        return orders;
    }
}
