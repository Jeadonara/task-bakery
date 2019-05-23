package rep.can.bakery.order;

import org.junit.jupiter.api.Test;
import rep.can.bakery.order.dto.CreateOrdersInput;
import rep.can.bakery.order.dto.CreateOrdersOutput;
import rep.can.bakery.order.dto.Order;
import rep.can.bakery.order.dto.OrderOutput;
import rep.can.bakery.order.dto.OrderSaleDetail;
import rep.can.bakery.order.service.OrderService;
import rep.can.bakery.order.service.OrderServiceFactory;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    private OrderService orderService = OrderServiceFactory.get();

    @Test
    public void givenEmptyOrders_whenCreateOrder_thenEmptyOrderOutputReturned() {
        CreateOrdersInput input = new CreateOrdersInput();
        input.setOrders(EMPTY_LIST);

        CreateOrdersOutput ordersOutput = orderService.createOrder(input);

        assertTrue(ordersOutput.getOrderOutputs().isEmpty());
    }

    @Test
    public void givenSampleOrders_whenCreateOrder_thenNotEmptyOrderOutputReturned() {
        CreateOrdersInput input = getCreateOrderInputWithSampleOrders();

        CreateOrdersOutput ordersOutput = orderService.createOrder(input);

        List<OrderOutput> orderOutputs = ordersOutput.getOrderOutputs();

        assertFalse(orderOutputs.isEmpty(), "Order Output can not be empty");

    }

    @Test
    public void givenSampleOrders_whenCreateOrder_thenSameSizeOrderOutputReturned() {
        CreateOrdersInput input = getCreateOrderInputWithSampleOrders();

        CreateOrdersOutput ordersOutput = orderService.createOrder(input);

        assertEquals(ordersOutput.getOrderOutputs().size(), input.getOrders().size(), "Order Outputs size must be equal to Order Inputs Size");

    }

    private CreateOrdersInput getCreateOrderInputWithSampleOrders() {
        List<Order> orders = Arrays
                .asList(
                        Order.of("VS5", 10),
                        Order.of("MB11", 14),
                        Order.of("CF", 13)
                );


        CreateOrdersInput ordersInput = new CreateOrdersInput();
        ordersInput.setOrders(orders);

        return ordersInput;
    }

    @Test
    public void givenOrder_whenCreateOrder_thenExpectedOrderOutputReturned() {
        Order order = Order.of("VS5", 10);

        CreateOrdersInput input = new CreateOrdersInput();
        input.setOrders(Arrays.asList(order));

        CreateOrdersOutput ordersOutput = orderService.createOrder(input);

        List<OrderOutput> orderOutputs = ordersOutput.getOrderOutputs();

        assertEquals(orderOutputs.size(), 1, "Unexpected Order Outputs for " + " amount of " + order.getAmount() + " " + order.getProductCode());

        OrderOutput orderOutput = orderOutputs.get(0);

        assertEquals(orderOutput.getOrder().getProductCode(), order.getProductCode(), "Unexpected Product for Order Output");
        assertEquals(orderOutput.getOrder().getAmount(), order.getAmount(), "Input And Output Amount Of Product Order Doesn't Match");

        assertEquals(BigDecimal.valueOf(17.88).compareTo(orderOutput.getTotalPrice()),0,"Unexpected Total Price");

        OrderSaleDetail orderSaleDetail = orderOutput.getSaleDetails().get(0);
        assertEquals(orderSaleDetail.getAmount().compareTo(2),0,"Unexpected Order Sale Amount");
        assertEquals(orderSaleDetail.getSaleSize().compareTo(5),0,"Unexpected Order Sale Size");
        assertEquals(orderSaleDetail.getSalePrice().compareTo(BigDecimal.valueOf(8.99)),0,"Unexpected Order Sale Price");
    }


}
