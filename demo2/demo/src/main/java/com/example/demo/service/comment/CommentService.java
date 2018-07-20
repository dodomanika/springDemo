package com.example.demo.service.comment;

import com.example.demo.domain.article.Article;
import com.example.demo.domain.comment.Comment;
import com.example.demo.domain.comment.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void createComment(Article article, String userName, String body) {
        Comment comment = new Comment(article, userName, body);
        commentRepository.save(comment);
    }
}
