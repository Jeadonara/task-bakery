package rep.can.bakery.product.service;

import rep.can.bakery.product.dto.GetProductsOutput;
import rep.can.bakery.product.dto.GetProductsSearchInput;

public interface ProductService {

    GetProductsOutput getProducts(GetProductsSearchInput searchInput);
}
