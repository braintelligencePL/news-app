package pl.braintelligence.requirement.task.domain.news;

import java.util.List;

import pl.braintelligence.requirement.task.domain.exceptions.ErrorCode;
import pl.braintelligence.requirement.task.domain.exceptions.InvalidCodeException;
import pl.braintelligence.requirement.task.domain.values.Article;
import pl.braintelligence.requirement.task.domain.values.Category;
import pl.braintelligence.requirement.task.domain.values.Country;

public class News {

    private Country country;
    private Category category;
    private List<Article> articles;

    public News(Country country, Category category) {
        validateCountry(country);
        validateCategory(category);
        this.country = country;
        this.category = category;
    }

    private void validateCategory(Category category) {
        if (category.isInvalid()) {
            throw new InvalidCodeException(ErrorCode.NONEXISTENT_CATEGORY);
        }
    }

    private void validateCountry(Country country) {
        if (country.isInvalid()) {
            throw new InvalidCodeException(ErrorCode.NONEXISTENT_COUNTRY);
        }
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    private News() {
    }
}

