package pl.braintelligence.requirement.task.application.dto;

import java.util.List;

public class NewsDto {

    private String country;
    private String category;
    private List<NewArticle> articles;

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

    public List<NewArticle> getArticles() {
        return articles;
    }

    public void setArticles(List<NewArticle> articles) {
        this.articles = articles;
    }
}

