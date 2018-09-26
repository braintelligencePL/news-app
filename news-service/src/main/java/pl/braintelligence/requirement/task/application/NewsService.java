package pl.braintelligence.requirement.task.application;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import pl.braintelligence.requirement.task.application.dto.NewsSource;
import pl.braintelligence.requirement.task.infrastructure.NewsClient;

@Service
public class NewsService {

    private final NewsClient newsClient;

    public NewsService(NewsClient newsClient) {
        this.newsClient = newsClient;
    }

    public ResponseEntity<NewsSource> getNews(String country, String category) {
        return newsClient.getSources();
    }

}
