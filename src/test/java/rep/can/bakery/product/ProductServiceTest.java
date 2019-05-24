package rep.can.bakery.product;

import org.junit.jupiter.api.Test;
import rep.can.bakery.product.dto.GetProductsOutput;
import rep.can.bakery.product.dto.GetProductsSearchInput;
import rep.can.bakery.product.dto.Product;
import rep.can.bakery.product.service.ProductService;
import rep.can.bakery.product.service.ProductServiceFactory;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.*;
import static rep.can.bakery.product.Constants.DEFAULT_PRODUCTS;

public class ProductServiceTest {

    private ProductService productService = ProductServiceFactory.get();

    @Test
    public void givenEmptyProductCode_whenGetProducts_thenEmptyProductsReturned() {
        GetProductsSearchInput input = new GetProductsSearchInput();
        input.setProductCodes(EMPTY_LIST);

        GetProductsOutput output = productService.getProducts(input);

        assertTrue(output.getProducts().isEmpty());
    }

    @Test
    public void givenDefaultProductCodes_whenGetProducts_thenDefaultProductsReturned() {

        List<String> productCodesToSearch = DEFAULT_PRODUCTS
                .stream()
                .map(Product::getCode)
                .collect(Collectors.toList());

        GetProductsSearchInput searchInput = new GetProductsSearchInput();
        searchInput.setProductCodes(productCodesToSearch);

        GetProductsOutput searchOutput = productService.getProducts(searchInput);

        List<Product> products = searchOutput.getProducts();

        Boolean allDefaultProductsReturned = products
                .stream()
                .map(Product::getCode)
                .collect(Collectors.toList())
                .containsAll(productCodesToSearch);

        assertTrue(allDefaultProductsReturned && products.size() == productCodesToSearch.size());

    }

}
