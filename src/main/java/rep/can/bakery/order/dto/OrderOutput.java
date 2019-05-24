package rep.can.bakery.order.dto;

import rep.can.bakery.infrastructure.NumberUtils;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static rep.can.bakery.infrastructure.Constants.*;

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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(order).append(STRING_EMPTY).append(STRING_USD_SYMBOL).append(NumberUtils.formatBigDecimal(totalPrice, DEFAULT_SCALE));
        saleDetails
                .forEach(d -> {
                    builder.append(System.lineSeparator());
                    builder.append(d.toString());
                });
        return builder.toString();
    }
}
