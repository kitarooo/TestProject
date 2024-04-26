package backend.microservices.testproject.controller;

import backend.microservices.testproject.dto.request.NewsRequest;
import backend.microservices.testproject.dto.response.NewsFullResponse;
import backend.microservices.testproject.dto.response.NewsResponse;
import backend.microservices.testproject.exception.handler.ExceptionResponse;
import backend.microservices.testproject.service.impl.NewsServiceImpl;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/news")
@RequiredArgsConstructor
public class NewsController {
    private final NewsServiceImpl newsService;

    @PostMapping("/createNews")
    @Operation(summary = "Admin endpoint", description = "Для добавления продукта!",
            responses = {
                    @ApiResponse(
                            content = @Content(mediaType = "application/json"),
                            responseCode = "200", description = "Good")
            })
    public String create(@RequestBody NewsRequest request) {
        return newsService.createNews(request);
    }

    @GetMapping("/all")
    @Operation(summary = "Admin endpoint", description = "Для добавления продукта!",
            responses = {
                    @ApiResponse(
                            content = @Content(mediaType = "application/json"),
                            responseCode = "200", description = "Good")
            })
    public List<NewsResponse> getAll() {
        return newsService.getAllNews();
    }

    @GetMapping("{id}")
    @Operation(summary = "User endpoint", description = "Для получения полной информации и статье с новостью!",
            responses = {
                    @ApiResponse(
                            content = @Content(mediaType = "application/json"),
                            responseCode = "200", description = "Good"),
                    @ApiResponse(
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ExceptionResponse.class)),
                            responseCode = "404", description = "News not found!"
                    )
            })
    public NewsFullResponse getById(@PathVariable Long id) {
        return newsService.getById(id);
    }
}
