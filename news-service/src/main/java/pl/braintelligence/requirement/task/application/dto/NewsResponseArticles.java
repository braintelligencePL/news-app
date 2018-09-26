package pl.braintelligence.requirement.task.application.dto;

import java.util.List;

import pl.braintelligence.requirement.task.domain.values.Article;

public class NewsResponseArticles {

    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
