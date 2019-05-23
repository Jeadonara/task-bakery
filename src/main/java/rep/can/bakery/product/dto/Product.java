package rep.can.bakery.product.dto;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private final String name;
    private final String code;
    private List<ProductSaleDetail> saleDetails;

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
        this.saleDetails = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public List<ProductSaleDetail> getSaleDetails() {
        return saleDetails;
    }

    public void setSaleDetails(List<ProductSaleDetail> saleDetails) {
        this.saleDetails = saleDetails;
    }
}
