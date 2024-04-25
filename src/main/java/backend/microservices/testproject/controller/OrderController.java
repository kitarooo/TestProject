package backend.microservices.testproject.controller;

import backend.microservices.testproject.dto.request.OrderRequest;
import backend.microservices.testproject.entity.Order;
import backend.microservices.testproject.exception.handler.ExceptionResponse;
import backend.microservices.testproject.repository.OrderRepository;
import backend.microservices.testproject.service.impl.OrderServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderServiceImpl orderService;

    @PostMapping("/create")
    public String createOrder(@RequestBody OrderRequest request) {
        return orderService.createOrder(request);
    }

    @GetMapping("/all")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @GetMapping("{id}")
    @Operation(summary = "Admin endpoint", description = "Для получения заказа по id!",
            responses = {
                    @ApiResponse(
                            content = @Content(mediaType = "string"),
                            responseCode = "200", description = "Good"),
                    @ApiResponse(
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ExceptionResponse.class)),
                            responseCode = "404", description = "Order not found!"
                    )
            })
    public Order getById(@PathVariable Long id) {
        return orderService.getById(id);
    }
}
