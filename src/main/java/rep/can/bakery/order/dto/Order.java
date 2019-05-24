package rep.can.bakery.order.dto;

import static rep.can.bakery.infrastructure.Constants.STRING_EMPTY;

public class Order {
    private final String productCode;
    private final Integer amount;

    Order(String productCode, Integer amount) {
        this.productCode = productCode;
        this.amount = amount;
    }

    public String getProductCode() {
        return productCode;
    }

    public Integer getAmount() {
        return amount;
    }

    public static Order of(String product, Integer amount) {
        return new Order(product, amount);
    }

    @Override
    public String toString() {
        return amount + STRING_EMPTY + productCode;
    }
}
