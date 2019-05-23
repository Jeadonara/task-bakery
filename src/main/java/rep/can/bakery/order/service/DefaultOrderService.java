package rep.can.bakery.order.service;

import rep.can.bakery.order.dto.CreateOrdersInput;
import rep.can.bakery.order.dto.CreateOrdersOutput;
import rep.can.bakery.product.service.ProductService;
import rep.can.bakery.product.service.ProductServiceFactory;

class DefaultOrderService implements OrderService {

    private final ProductService productService = ProductServiceFactory.get();

    @Override
    public CreateOrdersOutput createOrder(CreateOrdersInput orderInput) {
        return null;
    }

}
