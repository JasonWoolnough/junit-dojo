package org.example.support;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDto {
    private BigDecimal amount;
    private Long stockItemId;
}
