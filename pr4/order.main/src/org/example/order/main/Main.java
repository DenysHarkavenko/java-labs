package org.example.order.main;

import com.github.javafaker.Faker;
import org.example.order.processing.OrderManager;
import org.example.order.product.Clothing;
import org.example.order.product.Electronics;
import org.example.order.product.Product;
import org.example.order.storage.OrderStorage;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();

        OrderStorage orderStorage = new OrderStorage();
        orderStorage.addOrder(Clothing.builder().name(faker.commerce().productName()).build());
        orderStorage.addOrder(Electronics.builder().name(faker.commerce().productName()).build());

        OrderManager orderManager = new OrderManager();
        List<Product> orders = orderStorage.getOrders();
        orderManager.processOrders(orders);
    }
}
