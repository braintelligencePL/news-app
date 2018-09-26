package pl.braintelligence.requirement.task.application;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import pl.braintelligence.requirement.task.application.dto.NewsDto;
import pl.braintelligence.requirement.task.application.utils.DtoMapper;
import pl.braintelligence.requirement.task.infrastructure.news.NewsClient;

@Service
public class NewsService {

    private final NewsClient newsClient;

    public NewsService(NewsClient newsClient) {
        this.newsClient = newsClient;
    }

    public ResponseEntity<NewsDto> getNews(String country, String category) {
        return ResponseEntity.ok().body(
                DtoMapper.mapToNewsDto(newsClient.getNews(country, category))
        );
    }
}
