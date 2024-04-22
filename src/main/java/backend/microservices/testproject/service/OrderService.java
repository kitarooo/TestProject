package backend.microservices.testproject.service;

import backend.microservices.testproject.dto.request.OrderRequest;
import backend.microservices.testproject.entity.Order;

import java.util.List;
public interface OrderService {
    String createOrder(OrderRequest request);
    List<Order> getAll();
    Order getById(Long id);
}
