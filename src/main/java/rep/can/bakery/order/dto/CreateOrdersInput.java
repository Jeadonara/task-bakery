package rep.can.bakery.order.dto;

import java.util.List;

public class CreateOrdersInput {

    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
