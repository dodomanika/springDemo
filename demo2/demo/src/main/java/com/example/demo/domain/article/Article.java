package com.example.demo.domain.article;

import com.example.demo.domain.comment.Comment;

import javax.persistence.*;
import java.util.List;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String body;

    @OneToMany(mappedBy = "article")
    private List<Comment> comments;

    public Article() {
    }

    public Article(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    /*public void setTitle(String title) {
        this.title = title;
    }*/

    public String getBody() {
        return body;
    }

    /*public void setBody(String body) {
        this.body = body;
    }*/
}
