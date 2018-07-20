package com.example.demo.service.article;

import com.example.demo.domain.article.Article;
import com.example.demo.domain.article.ArticleRepository;
import org.springframework.beans.factory.FactoryBean;

public class ArticleService {
    private ArticleRepository articleRepository;
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public void createArticle(String title, String body) {
        Article article = new Article(title, body);
        articleRepository.save(article);
    }
}
