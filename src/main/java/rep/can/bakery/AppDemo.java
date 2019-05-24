package rep.can.bakery;

import rep.can.bakery.order.dto.CreateOrdersInput;
import rep.can.bakery.order.dto.CreateOrdersOutput;
import rep.can.bakery.order.dto.Order;
import rep.can.bakery.order.service.OrderService;
import rep.can.bakery.order.service.OrderServiceFactory;

import java.util.Arrays;
import java.util.List;

public class AppDemo {

    private static final List<Order> DEMO_ORDERS;

    static {
        DEMO_ORDERS = Arrays.asList(
                Order.of("VS5", 10),
                Order.of("MB11", 14),
                Order.of("CF", 13)
        );
    }

    public static void main(String[] args) {

        System.out.println("/////////////////////////");
        System.out.println(System.lineSeparator());
        System.out.println("Input");

        DEMO_ORDERS.forEach(o -> System.out.println(o.toString()));

        CreateOrdersInput orderInput = new CreateOrdersInput();
        orderInput.setOrders(DEMO_ORDERS);


        OrderService orderService = OrderServiceFactory.get();


        CreateOrdersOutput ordersOutput = orderService.createOrder(orderInput);

        System.out.println(System.lineSeparator());

        System.out.println("Output");

        System.out.println(ordersOutput.toString());

        System.out.println(System.lineSeparator());

        System.out.println("/////////////////////////");

    }
}
