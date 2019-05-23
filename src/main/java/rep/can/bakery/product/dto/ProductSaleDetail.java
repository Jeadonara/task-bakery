package rep.can.bakery.product.dto;

import java.math.BigDecimal;

public class ProductSaleDetail {
    private final Integer saleSize;
    private final BigDecimal price;

    private ProductSaleDetail(int saleSize, BigDecimal price) {
        this.saleSize = saleSize;
        this.price = price;
    }

    public int getSaleSize() {
        return saleSize;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public static ProductSaleDetail of(Integer saleSize, BigDecimal price) {
        return new ProductSaleDetail(saleSize, price);
    }


}
