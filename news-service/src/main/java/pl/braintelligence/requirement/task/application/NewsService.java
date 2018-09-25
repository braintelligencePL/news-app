package pl.braintelligence.requirement.task.application;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import pl.braintelligence.requirement.task.application.dto.NewsDto;

@Service
public class NewsService {

    public List<NewsDto> getNews(String country, String category) {
        return Collections.emptyList();
    }

}
