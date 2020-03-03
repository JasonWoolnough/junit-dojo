package org.example;

import org.example.support.ShopService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class Exercise3Test {
    @Mock
    ShopService shopService;

    @InjectMocks
    Exercise3 exercise3;

    /**
     * This test runs into a classic mockito problem. Let's break it down:
     *
     * 1. You want to do a verify on shopService.placeOrder, to make sure the OrderDto and customerId are passed through correctly
     * 2. Because OrderDto is instantiated inside the code, we need to use an argumentCaptor for the first parameter of placeOrder.
     * 3. Because the second parameter is a literal value, we don't need an argumentCaptor. We can just verify that the value 15L is provided.
     *    However, the code: verify(shopService).placeOrder(captor.capture(), 15L)
     */
    @Test
    public void placeOrder_shouldPlaceOrderWithOrderDtoAndCustomerId() {
    }
}
