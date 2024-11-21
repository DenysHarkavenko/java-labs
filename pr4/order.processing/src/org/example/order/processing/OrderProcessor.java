package org.example.order.processing;

import org.example.order.product.Product;

public class OrderProcessor<T extends Product> {
    private T product;

    public OrderProcessor(T product) {
        this.product = product;
    }

    public void process() {
        System.out.println("Processing order for: " + product.getName());
    }
}
