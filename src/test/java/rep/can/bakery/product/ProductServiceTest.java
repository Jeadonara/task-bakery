package rep.can.bakery.product;

import org.junit.jupiter.api.Test;
import rep.can.bakery.product.dto.GetProductsOutput;
import rep.can.bakery.product.dto.GetProductsSearchInput;
import rep.can.bakery.product.service.ProductService;
import rep.can.bakery.product.service.ProductServiceFactory;

import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.*;

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

    }

}
