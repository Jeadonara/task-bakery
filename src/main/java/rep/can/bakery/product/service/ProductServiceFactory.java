package rep.can.bakery.product.service;

public class ProductServiceFactory {

    public static ProductService get() {
        return new DefaultProductService();
    }

}
