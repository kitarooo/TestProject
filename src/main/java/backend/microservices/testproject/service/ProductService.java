package backend.microservices.testproject.service;

import backend.microservices.testproject.dto.request.ProductRequest;
import backend.microservices.testproject.dto.response.ProductFullResponse;
import backend.microservices.testproject.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {
    String createProduct(ProductRequest request);
    List<ProductResponse> getAll();
    ProductFullResponse getById(Long id);
}
