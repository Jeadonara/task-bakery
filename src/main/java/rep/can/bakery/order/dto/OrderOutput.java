package rep.can.bakery.order.dto;

import java.math.BigDecimal;
import java.util.List;

public class OrderOutput {
    private Order order;
    private BigDecimal totalPrice;
    private List<OrderSaleDetail> saleDetails;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderSaleDetail> getSaleDetails() {
        return saleDetails;
    }

    public void setSaleDetails(List<OrderSaleDetail> saleDetails) {
        this.saleDetails = saleDetails;
    }
}
