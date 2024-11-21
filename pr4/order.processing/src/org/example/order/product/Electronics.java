package org.example.order.product;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Electronics extends Product {
    @Builder
    public Electronics(String name) {
        super(name);
    }
}
