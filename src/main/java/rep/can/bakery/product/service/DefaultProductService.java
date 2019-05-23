package rep.can.bakery.product.service;

import rep.can.bakery.product.dto.GetProductsOutput;
import rep.can.bakery.product.dto.GetProductsSearchInput;
import rep.can.bakery.product.dto.Product;
import rep.can.bakery.product.dto.ProductSaleDetail;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        Product vs5 = new Product("Vegemite Scroll", "VS5");
        vs5.setSaleDetails(
                Arrays
                        .asList(
                                ProductSaleDetail.of(3, BigDecimal.valueOf(6.99)),
                                ProductSaleDetail.of(5, BigDecimal.valueOf(8.99))
                        )
        );

        Product mb11 = new Product("Blueberry Muffin", "MB11");
        vs5.setSaleDetails(
                Arrays
                        .asList(
                                ProductSaleDetail.of(2, BigDecimal.valueOf(9.95)),
                                ProductSaleDetail.of(5, BigDecimal.valueOf(16.95)),
                                ProductSaleDetail.of(8, BigDecimal.valueOf(24.95))
                        )
        );

        Product cf = new Product("Croissant", "CF");
        vs5.setSaleDetails(
                Arrays
                        .asList(
                                ProductSaleDetail.of(3, BigDecimal.valueOf(5.95)),
                                ProductSaleDetail.of(5, BigDecimal.valueOf(9.95)),
                                ProductSaleDetail.of(9, BigDecimal.valueOf(16.99))
                        )
        );

        return Arrays.asList(vs5, mb11, cf);
    }
}
