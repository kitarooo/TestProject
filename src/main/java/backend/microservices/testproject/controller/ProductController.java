package backend.microservices.testproject.controller;

import backend.microservices.testproject.dto.request.ProductRequest;
import backend.microservices.testproject.dto.response.ProductFullResponse;
import backend.microservices.testproject.dto.response.ProductResponse;
import backend.microservices.testproject.exception.handler.ExceptionResponse;
import backend.microservices.testproject.service.impl.ProductServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImpl productService;

    @PostMapping("/add")
    @Operation(summary = "Admin endpoing", description = "Для добавления продукта!")
    public String addProduct(@RequestBody ProductRequest request) {
        return productService.createProduct(request);
    }

    @GetMapping("/all")
    public List<ProductResponse> getAll() {
        return productService.getAll();
    }

    @GetMapping("{id}")
    @Operation(summary = "User endpoint", description = "Для получения продукта по id!",
            responses = {
                    @ApiResponse(
                            content = @Content(mediaType = "application/json"),
                            responseCode = "200", description = "Good"),
                    @ApiResponse(
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ExceptionResponse.class)),
                            responseCode = "404", description = "Product not found!"
                    )
            })
    public ProductFullResponse getById(@PathVariable Long id) {
        return productService.getById(id);
    }
}
