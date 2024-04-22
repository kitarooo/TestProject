package backend.microservices.testproject.service.impl;

import backend.microservices.testproject.dto.request.OrderRequest;
import backend.microservices.testproject.entity.Order;
import backend.microservices.testproject.entity.Product;
import backend.microservices.testproject.exception.NotFoundException;
import backend.microservices.testproject.repository.OrderRepository;
import backend.microservices.testproject.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductServiceImpl productService;
    @Override
    public String createOrder(OrderRequest request) {
        Product product = productService.checkProductOnExist(request.getProduct().getId());

        Order order = Order.builder()
                .product(product)
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .quantity(request.getQuantity())
                .build();
        orderRepository.save(order);

        return "Заказ успешно создан!";
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Заказ не найден!"));
    }
}
