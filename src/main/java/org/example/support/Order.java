package org.example.support;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {
    private final BigDecimal price;
    private final Long stockItemId;
}
