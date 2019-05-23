package rep.can.bakery.product.dto;

import java.util.List;

public class GetProductsSearchInput {

    private List<String> productCodes;

    public List<String> getProductCodes() {
        return productCodes;
    }

    public void setProductCodes(List<String> productCodes) {
        this.productCodes = productCodes;
    }
}
