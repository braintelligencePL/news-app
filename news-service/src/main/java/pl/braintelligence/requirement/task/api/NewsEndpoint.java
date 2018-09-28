package pl.braintelligence.requirement.task.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import pl.braintelligence.requirement.task.application.NewsService;
import pl.braintelligence.requirement.task.application.dto.NewsDto;

@Controller
@RequestMapping("/news")
public class NewsEndpoint {

    private NewsService newsService;

    public NewsEndpoint(NewsService newsService) {
        this.newsService = newsService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{country}/{category}")
    public ResponseEntity<NewsDto> getTopHeadlines(
            @PathVariable String country,
            @PathVariable String category,
            @RequestParam(value = "page", defaultValue = "1") String page
    ) {
        return newsService.getTopHeadlines(country, category, page);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ResponseEntity<NewsDto> queryForNews(
            @RequestParam(value = "query") String query
    ) {
        return newsService.queryForNews(query);
    }

}
