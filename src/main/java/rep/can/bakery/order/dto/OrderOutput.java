package rep.can.bakery.order.dto;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class OrderOutput {
    private final Order order;
    private final BigDecimal totalPrice;
    private final List<OrderSaleDetail> saleDetails;
    private final Boolean isEmpty;


    private OrderOutput(Order order, BigDecimal totalPrice, List<OrderSaleDetail> saleDetails, Boolean isEmpty) {
        this.order = order;
        this.totalPrice = totalPrice;
        this.saleDetails = saleDetails;
        this.isEmpty = isEmpty;
    }

    public Order getOrder() {
        return order;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public List<OrderSaleDetail> getSaleDetails() {
        return saleDetails;
    }

    public Boolean isEmpty() {
        return this.isEmpty;
    }

    public static OrderOutput emptyOutputOfOrder(Order order) {
        return new OrderOutput(order, BigDecimal.ZERO, Collections.emptyList(), true);
    }

    public static OrderOutput of(Order order, BigDecimal totalPrice, List<OrderSaleDetail> saleDetails) {
        return new OrderOutput(order, totalPrice, saleDetails, false);
    }
}
