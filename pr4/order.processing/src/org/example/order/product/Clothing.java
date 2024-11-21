package org.example.order.product;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Clothing extends Product {
    @Builder
    public Clothing(String name) {
        super(name);
    }
}
