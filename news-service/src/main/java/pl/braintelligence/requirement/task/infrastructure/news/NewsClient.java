package pl.braintelligence.requirement.task.infrastructure.news;

import static java.util.Objects.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.logging.Logger;

import pl.braintelligence.requirement.task.domain.news.News;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class NewsClient {

    private static final Logger LOGGER = Logger.getLogger(NewsClient.class.getName());

    @Value("${news-service.top-headlines}")
    private String topHeadlinesUri;

    @Value("${news-service.api-key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public NewsClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public News getNews(String country, String category) {
        LOGGER.info("Getting top news from NewsAPI");
        News news = new News(country, category);

        URI targetUrl = UriComponentsBuilder.fromUriString(topHeadlinesUri)
                .queryParam("apiKey", apiKey)
                .queryParam("category", category)
                .queryParam("country", country)
                .build().toUri();

        System.out.println(targetUrl);

        news.setArticles(
                requireNonNull(
                        restTemplate.getForEntity(targetUrl, News.class).getBody())
                        .getArticles());

        return news;
    }
}
