package pl.braintelligence.requirement.task.domain.news;

import java.util.List;

import pl.braintelligence.requirement.task.domain.values.Article;

public class News {

    private String country;
    private String category;
    private List<Article> articles;

    public News(String country, String category) {
        this.country = country;
        this.category = category;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}

