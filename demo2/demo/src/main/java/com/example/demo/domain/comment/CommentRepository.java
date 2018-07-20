package com.example.demo.domain.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select new com.example.demo.domain.comment.CommentDTO(c.id) from Comment c")
    List<CommentDTO> packAllIntoDTO();

    List<Comment> findAllOrOrderByVotesDesc();
}
