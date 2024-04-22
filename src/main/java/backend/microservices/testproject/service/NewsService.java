package backend.microservices.testproject.service;

import backend.microservices.testproject.dto.request.NewsRequest;
import backend.microservices.testproject.dto.response.NewsFullResponse;
import backend.microservices.testproject.dto.response.NewsResponse;

import java.util.List;

public interface NewsService {
    String createNews(NewsRequest request);
    List<NewsResponse> getAllNews();
    NewsFullResponse getById(Long id);
}
