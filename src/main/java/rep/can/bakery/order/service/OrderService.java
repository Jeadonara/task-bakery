package rep.can.bakery.order.service;


import rep.can.bakery.order.dto.CreateOrdersInput;
import rep.can.bakery.order.dto.CreateOrdersOutput;
import rep.can.bakery.order.dto.Order;
import rep.can.bakery.order.dto.OrderOutput;

import java.util.List;

public interface OrderService {

    CreateOrdersOutput createOrder(CreateOrdersInput orderInput);
}
