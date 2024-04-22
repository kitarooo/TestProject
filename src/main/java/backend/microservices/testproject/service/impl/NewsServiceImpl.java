package backend.microservices.testproject.service.impl;

import backend.microservices.testproject.dto.request.NewsRequest;
import backend.microservices.testproject.dto.response.NewsFullResponse;
import backend.microservices.testproject.dto.response.NewsResponse;
import backend.microservices.testproject.entity.News;
import backend.microservices.testproject.exception.NotFoundException;
import backend.microservices.testproject.repository.NewsRepository;
import backend.microservices.testproject.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;

    @Override
    public String createNews(NewsRequest request) {
        newsRepository.save(News.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .build());

        return "Новая статья успешно создана!";
    }

    @Override
    public List<NewsResponse> getAllNews() {
        return newsRepository.findAll().stream()
                                .map(n -> NewsResponse.builder()
                                    .id(n.getId())
                                    .title(n.getTitle())
                                .build())
                .collect(Collectors.toList());
    }

    @Override
    public NewsFullResponse getById(Long id) {
        News news = newsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Статья с новостью не найдена!"));

        return NewsFullResponse.builder()
                .title(news.getTitle())
                .description(news.getDescription())
                .build();
    }
}
