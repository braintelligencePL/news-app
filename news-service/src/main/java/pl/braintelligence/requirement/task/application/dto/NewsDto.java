package pl.braintelligence.requirement.task.application.dto;

import java.util.List;

public class NewsDto {

    private String country;
    private String category;
    private List<NewArticles> articles;

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

    public List<NewArticles> getArticles() {
        return articles;
    }

    public void setArticles(List<NewArticles> articles) {
        this.articles = articles;
    }
}

