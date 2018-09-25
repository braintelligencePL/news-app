package pl.braintelligence.requirement.task.application;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import pl.braintelligence.requirement.task.application.dto.NewArticles;

@Service
public class NewsService {

    public List<NewArticles> getArticles() {
        return Collections.emptyList();
    }
}
