package pl.braintelligence.requirement.task.domain.news;

import java.util.List;

import pl.braintelligence.requirement.task.domain.values.Article;

public class News {

    private String country;
    private String category;
    private List<Article> articles;

    public String getCountry() {
        return country;
    }

    public String getCategory() {
        return category;
    }

    public List<Article> getArticles() {
        return articles;
    }
}
