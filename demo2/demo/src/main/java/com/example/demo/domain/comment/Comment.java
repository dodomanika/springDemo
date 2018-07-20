package com.example.demo.domain.comment;

import com.example.demo.domain.article.Article;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String userName;
    private String body;
    private int upVotes; //=0; ???
    private int downVotes;
    private int votes;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    public Comment() {
    }

    public Comment(Article article, String userName, String body) {
        this.article = article;
        this.userName = userName;
        this.body = body;
    }

    public long getId() { return id; }

    public Article getArticle() {
        return article;
    }

    public String getUserName() {
        return userName;
    }

    public String getBody() {
        return body;
    }

    public void incrementVotes() {
        this.upVotes++;
        this.votes++;
    }

    public void decrementVotes() {
        this.downVotes++;
        this.votes++;
    }

    public int getVotes() { return votes; }

}
