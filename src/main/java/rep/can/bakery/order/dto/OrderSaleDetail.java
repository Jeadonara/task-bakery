package rep.can.bakery.order.dto;

import java.math.BigDecimal;

public class OrderSaleDetail {

    private final Integer amount;
    private final Integer saleSize;
    private final BigDecimal salePrice;

    public OrderSaleDetail(Integer amount, Integer saleSize, BigDecimal salePrice) {
        this.amount = amount;
        this.saleSize = saleSize;
        this.salePrice = salePrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getSaleSize() {
        return saleSize;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }
}
