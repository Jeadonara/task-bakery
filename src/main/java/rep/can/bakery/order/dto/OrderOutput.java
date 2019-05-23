package rep.can.bakery.order.dto;

import java.math.BigDecimal;
import java.util.List;

public class OrderOutput {
    private final Order order;
    private final BigDecimal totalPrice;
    private final List<OrderSaleDetail> saleDetails;


    public OrderOutput(Order order, BigDecimal totalPrice, List<OrderSaleDetail> saleDetails) {
        this.order = order;
        this.totalPrice = totalPrice;
        this.saleDetails = saleDetails;
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
}
