package rep.can.bakery.order.dto;

import java.util.List;

public class CreateOrdersOutput {

    private List<OrderOutput> orderOutputs;

    public List<OrderOutput> getOrderOutputs() {
        return orderOutputs;
    }

    public void setOrderOutputs(List<OrderOutput> orderOutputs) {
        this.orderOutputs = orderOutputs;
    }
}
