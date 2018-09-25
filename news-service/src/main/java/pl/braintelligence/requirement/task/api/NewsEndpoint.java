package pl.braintelligence.requirement.task.api;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import pl.braintelligence.requirement.task.application.NewsService;
import pl.braintelligence.requirement.task.application.dto.NewArticles;

@Controller
@RequestMapping("/news")
public class NewsEndpoint {

    private NewsService newsService;

    public NewsEndpoint(NewsService newsService) {
        this.newsService = newsService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<NewArticles> getProjects() {
        return newsService.getArticles();
    }
}
