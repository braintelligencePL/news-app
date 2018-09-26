package pl.braintelligence.requirement.task.infrastructure;

import static java.util.Objects.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import pl.braintelligence.requirement.task.domain.news.News;
import pl.braintelligence.requirement.task.application.dto.NewsResponseArticles;
import pl.braintelligence.requirement.task.application.dto.NewsSource;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class NewsClient {

    private static final Logger LOGGER = Logger.getLogger(NewsClient.class.getName());

    @Value("${news-service.top-headlines}")
    private String topHeadlines;

    @Value("${news-service.api-key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public NewsClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<News> getNews(String country, String category) {

        News news = new News(country, category);

        URI targetUrl = UriComponentsBuilder.fromUriString(topHeadlines)
                .queryParam("apiKey", apiKey)
                .queryParam("category", category)
                .queryParam("country", country)
                .build().toUri();

        news.setArticles(
                requireNonNull(
                        restTemplate.getForEntity(targetUrl, NewsResponseArticles.class).getBody())
                        .getArticles());

        return ResponseEntity.ok().body(news);
    }
}
