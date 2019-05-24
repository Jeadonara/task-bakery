package rep.can.bakery.order.service;

import rep.can.bakery.order.utils.MathUtils;
import rep.can.bakery.order.dto.CreateOrdersInput;
import rep.can.bakery.order.dto.CreateOrdersOutput;
import rep.can.bakery.order.dto.Order;
import rep.can.bakery.order.dto.OrderOutput;
import rep.can.bakery.order.dto.OrderSaleDetail;
import rep.can.bakery.product.dto.GetProductsOutput;
import rep.can.bakery.product.dto.GetProductsSearchInput;
import rep.can.bakery.product.dto.Product;
import rep.can.bakery.product.dto.ProductSaleDetail;
import rep.can.bakery.product.service.ProductService;
import rep.can.bakery.product.service.ProductServiceFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class DefaultOrderService implements OrderService {

    private final ProductService productService = ProductServiceFactory.get();

    @Override
    public CreateOrdersOutput createOrder(CreateOrdersInput input) {
        List<Order> orders = input.getOrders();

        Map<String, Product> codeProductMap = getAvailableProductsForOrders(orders);

        List<OrderOutput> orderOutputs = orders
                .stream()
                .map(order ->
                        Optional.ofNullable(codeProductMap.get(order.getProductCode()))
                                .map(product -> getProductOrderOutput(product, order))
                                .orElse(OrderOutput.emptyOutputOfOrder(order))
                )
                .collect(Collectors.toList());

        CreateOrdersOutput output = new CreateOrdersOutput();
        output.setOrderOutputs(orderOutputs);

        return output;
    }

    private Map<String, Product> getAvailableProductsForOrders(List<Order> orders) {

        List<String> productCodesToSearch = orders
                .stream()
                .map(Order::getProductCode)
                .collect(Collectors.toList());

        GetProductsSearchInput searchInput = new GetProductsSearchInput();
        searchInput.setProductCodes(productCodesToSearch);

        GetProductsOutput output = productService.getProducts(searchInput);

        return output
                .getProducts()
                .stream()
                .collect(Collectors.toMap(Product::getCode, p -> p));

    }

    private OrderOutput getProductOrderOutput(Product product, Order order) {

        Map<Integer, BigDecimal> saleSizePriceMap = product
                .getSaleDetails()
                .stream()
                .collect(Collectors.toMap(ProductSaleDetail::getSaleSize, ProductSaleDetail::getPrice));

        Map<Integer, Integer> sizedPackageAmountMap = MathUtils.getDivisionFactors(order.getAmount(), new ArrayList<>(saleSizePriceMap.keySet()));

        List<OrderSaleDetail> orderSaleDetails = sizedPackageAmountMap.entrySet()
                .stream()
                .map(entry -> new OrderSaleDetail(entry.getValue(), entry.getKey(), saleSizePriceMap.get(entry.getKey())))
                .collect(Collectors.toList());

        BigDecimal totalPrice = orderSaleDetails
                .stream()
                .map(d -> d.getSalePrice().multiply(new BigDecimal(d.getAmount())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);


        return OrderOutput.of(order, totalPrice, orderSaleDetails);

    }


}
