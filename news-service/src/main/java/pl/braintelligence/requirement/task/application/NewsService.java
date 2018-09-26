package pl.braintelligence.requirement.task.application;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import pl.braintelligence.requirement.task.domain.news.News;
import pl.braintelligence.requirement.task.infrastructure.NewsClient;

@Service
public class NewsService {

    private final NewsClient newsClient;

    public NewsService(NewsClient newsClient) {
        this.newsClient = newsClient;
    }

    public ResponseEntity<News> getNews(String country, String category) {
        return newsClient.getNews(country, category);
    }
}
