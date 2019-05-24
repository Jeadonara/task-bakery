package rep.can.bakery.product.service;

import rep.can.bakery.product.dto.GetProductsOutput;
import rep.can.bakery.product.dto.GetProductsSearchInput;
import rep.can.bakery.product.dto.Product;

import java.util.List;
import java.util.stream.Collectors;

import static rep.can.bakery.product.Constants.DEFAULT_PRODUCTS;

class DefaultProductService implements ProductService {

    @Override
    public GetProductsOutput getProducts(GetProductsSearchInput searchInput) {
        List<String> productCodesToFilter = searchInput.getProductCodes();


        List<Product> products = getDefaultProducts();

        List<Product> filteredProducts = products.stream()
                .filter(product -> productCodesToFilter.contains(product.getCode()))
                .collect(Collectors.toList());

        GetProductsOutput output = new GetProductsOutput();
        output.setProducts(filteredProducts);

        return output;
    }

    private List<Product> getDefaultProducts() {
        return DEFAULT_PRODUCTS;
    }
}
