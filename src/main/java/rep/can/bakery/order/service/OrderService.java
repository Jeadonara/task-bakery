package rep.can.bakery.order.service;


import rep.can.bakery.order.dto.CreateOrdersInput;
import rep.can.bakery.order.dto.CreateOrdersOutput;

public interface OrderService {

    CreateOrdersOutput createOrder(CreateOrdersInput orderInput);
}
