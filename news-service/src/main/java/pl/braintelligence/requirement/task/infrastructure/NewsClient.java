package pl.braintelligence.requirement.task.infrastructure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.logging.Logger;

import pl.braintelligence.requirement.task.application.dto.NewsSource;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class NewsClient {

    private static final Logger LOGGER = Logger.getLogger(NewsClient.class.getName());

    @Value("${news-service.uri}")
    private String uri;

    @Value("${news-service.api-key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public NewsClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<NewsSource> getSources() {
        LOGGER.info("Getting sources from NewsAPI");
        URI targetUrl = UriComponentsBuilder.fromUriString(uri)
                .queryParam("apiKey", apiKey)
                .queryParam("category", "technology")
                .build().toUri();
        System.out.println(restTemplate.getForEntity(targetUrl, NewsSource.class).getBody());

        return restTemplate.getForEntity(targetUrl, NewsSource.class);
    }

    public ResponseEntity<>

}
