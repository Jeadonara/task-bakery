package rep.can.bakery.order.service;


public class OrderServiceFactory {

    public static OrderService get() {
        return new DefaultOrderService();
    }
}
