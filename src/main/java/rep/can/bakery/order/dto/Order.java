package rep.can.bakery.order.dto;

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
}
