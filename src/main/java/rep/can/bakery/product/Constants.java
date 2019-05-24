package rep.can.bakery.product;

import rep.can.bakery.product.dto.Product;
import rep.can.bakery.product.dto.ProductSaleDetail;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public final class Constants {

    private Constants() {
    }

    public static final List<Product> DEFAULT_PRODUCTS;

    static {
        Product vs5 = new Product("Vegemite Scroll", "VS5");
        vs5.setSaleDetails(
                Arrays
                        .asList(
                                ProductSaleDetail.of(3, BigDecimal.valueOf(6.99)),
                                ProductSaleDetail.of(5, BigDecimal.valueOf(8.99))
                        )
        );

        Product mb11 = new Product("Blueberry Muffin", "MB11");
        mb11.setSaleDetails(
                Arrays
                        .asList(
                                ProductSaleDetail.of(2, BigDecimal.valueOf(9.95)),
                                ProductSaleDetail.of(5, BigDecimal.valueOf(16.95)),
                                ProductSaleDetail.of(8, BigDecimal.valueOf(24.95))
                        )
        );

        Product cf = new Product("Croissant", "CF");
        cf.setSaleDetails(
                Arrays
                        .asList(
                                ProductSaleDetail.of(3, BigDecimal.valueOf(5.95)),
                                ProductSaleDetail.of(5, BigDecimal.valueOf(9.95)),
                                ProductSaleDetail.of(9, BigDecimal.valueOf(16.99))
                        )
        );

        DEFAULT_PRODUCTS = Arrays.asList(vs5, mb11, cf);
    }
}
