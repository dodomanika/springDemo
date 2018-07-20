package com.example.demo.api.article;

import com.example.demo.domain.article.ArticleRepository;
import com.example.demo.domain.article.Article;
import com.example.demo.service.article.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    private ArticleRepository repository;
    private ArticleService articleService;

    public ArticleController(ArticleRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/articles")
    public List<Article> getArticles() {
        return repository.findAll();
    }

    @GetMapping(value = "/articles/{id}")
    public Article getArticle(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping(value = "/articles")
    public void addArticle(@RequestBody ArticleCreateRequest body) {
        articleService.createArticle(body.getTitle(), body.getBody());
    }

}
