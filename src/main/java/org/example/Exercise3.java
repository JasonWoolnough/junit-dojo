package org.example;

import org.example.support.Invoice;
import org.example.support.Order;
import org.example.support.OrderDto;
import org.example.support.ShopService;

public class Exercise3 {
    private final ShopService shopService;

    public Exercise3(ShopService shopService) {
        this.shopService = shopService;
    }

    public Invoice placeOrder(Order order, Long customerId) {
        OrderDto orderDto = new OrderDto();
        orderDto.setAmount(order.getPrice());
        orderDto.setStockItemId(order.getStockItemId());

        return shopService.placeOrder(orderDto, customerId);
    }


}
