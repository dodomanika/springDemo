package com.example.demo.api.comment;

import com.example.demo.domain.article.ArticleRepository;
import com.example.demo.domain.comment.CommentDTO;
import com.example.demo.domain.comment.CommentRepository;
import com.example.demo.api.article.ArticleNotFoundException;
import com.example.demo.domain.article.Article;
import com.example.demo.domain.comment.Comment;
import com.example.demo.service.comment.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CommentController {

    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;
    private final CommentService commentService;

    public CommentController(CommentRepository commentRepository, ArticleRepository articleRepository, CommentService commentService) {
        this.commentRepository = commentRepository;
        this.articleRepository = articleRepository;
        this.commentService = commentService;
    }

    @GetMapping("/comments")
    public List<CommentDTO> getComments() {
        List<Comment> comments = commentRepository.findAllOrOrderByVotesDesc();
        List<CommentDTO> commentDTOS = new ArrayList<>();
        for (Comment c:comments
             ) {
            commentDTOS.add(new CommentDTO(c.getId(), c.getUserName(), c.getBody(), c.getVotes()));
        }
        return commentDTOS;
    }

    @GetMapping("/comments/{id}")
    public CommentDTO getComment(@PathVariable long id) {

//        Optional<Comment> commentOptional = commentRepository.findById(id);
//        if (commentOptional.isPresent()) {
//            Comment comment = commentOptional.get();
//            return comment;
//        } else {
//            throw new CommentNotFoundException();
//        }

        // EKWIWALENT tego co na dole
        Comment comment = commentRepository.findById(id).orElseThrow(CommentNotFoundException::new);
        return new CommentDTO(comment.getId(), comment.getUserName(), comment.getBody(), comment.getVotes());

        // SPOJRZ W TEN WYJATEK (w kod) /\
    }


    @PostMapping("/comments")
    public void addComment(@RequestBody CommentCreateRequest body) {
        long articleId = body.getArticleId();

        Article article = articleRepository.findById(articleId)
                .orElseThrow(ArticleNotFoundException::new);

        commentService.createComment(article, body.getUserName(), body.getBody());

    }

    @PostMapping("/comments/{id}/vote")
    public void vote(@RequestParam boolean up, @RequestParam boolean down) throws IncorrectVoteException {
        if (up == down) {
            throw new IncorrectVoteException();
        }
    }
}
