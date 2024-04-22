package backend.microservices.testproject.service.impl;

import backend.microservices.testproject.dto.request.ProductRequest;
import backend.microservices.testproject.dto.response.ProductFullResponse;
import backend.microservices.testproject.dto.response.ProductResponse;
import backend.microservices.testproject.entity.Product;
import backend.microservices.testproject.exception.NotFoundException;
import backend.microservices.testproject.repository.ProductRepository;
import backend.microservices.testproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public String createProduct(ProductRequest request) {
        Product product = Product.builder()
                .productName(request.getProductName())
                .quantity(request.getQuantity())
                .build();
        productRepository.save(product);
        return "Продукт успешно добавлен!";
    }

    @Override
    public List<ProductResponse> getAll() {
        return productRepository.findAll().stream()
                .map(n -> ProductResponse.builder()
                        .id(n.getId())
                        .productName(n.getProductName())
                        .build()).collect(Collectors.toList());
    }

    @Override
    public ProductFullResponse getById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("Продукт не найден!"));
        return ProductFullResponse.builder()
                .productName(product.getProductName())
                .quantity(product.getQuantity())
                .build();
    }

    public Product checkProductOnExist(Long id) {
        return productRepository.findAllById(id).orElseThrow(
                () -> new NotFoundException("Продукт не найден!"));
    }
}
