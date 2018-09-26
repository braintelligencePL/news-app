package pl.braintelligence.requirement.task.application.utils;

import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

import pl.braintelligence.requirement.task.application.dto.NewsArticle;
import pl.braintelligence.requirement.task.application.dto.NewsDto;
import pl.braintelligence.requirement.task.domain.news.News;
import pl.braintelligence.requirement.task.domain.values.Article;

public class DtoMapper {

    public static NewsDto mapToNewsDto(News news) {
        NewsDto newsDto = new NewsDto();
        newsDto.setCountry(news.getCountry());
        newsDto.setCategory(news.getCategory());
        newsDto.setArticles(news.getArticles().stream()
                .map(DtoMapper::mapToNewsArticle)
                .collect(Collectors.toList()));
        return newsDto;
    }

    private static NewsArticle mapToNewsArticle(Article article) {
        NewsArticle newsArticle = new NewsArticle();
        newsArticle.setAuthor(article.getAuthor());
        newsArticle.setArticleUrl(article.getUrl());
        newsArticle.setDescription(article.getDescription());
        newsArticle.setImageUrl(article.getUrlToImage());
        newsArticle.setSourceName(article.getSource().getName());
        newsArticle.setDate(
                new SimpleDateFormat("yyyy/MM/dd")
                        .format(article.getPublishedAt()));
        return newsArticle;
    }

}
