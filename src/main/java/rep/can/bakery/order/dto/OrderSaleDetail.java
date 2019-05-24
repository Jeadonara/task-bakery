package rep.can.bakery.order.dto;

import rep.can.bakery.infrastructure.NumberUtils;

import java.math.BigDecimal;

import static rep.can.bakery.infrastructure.Constants.*;

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

    @Override
    public String toString() {
        return amount + STRING_EMPTY + STRING_TIMES + STRING_EMPTY + saleSize + STRING_USD_SYMBOL + NumberUtils.formatBigDecimal(salePrice, DEFAULT_SCALE);
    }
}
