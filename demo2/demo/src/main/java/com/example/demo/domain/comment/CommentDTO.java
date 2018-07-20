package com.example.demo.domain.comment;

public class CommentDTO {
    private final long id;
    private final String userName;
    private final String body;
    private final int votes;

    public CommentDTO(long id, String userName, String body, int votes) {
        this.id = id;
        this.userName = userName;
        this.body = body;
        this.votes = votes;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getBody() {
        return body;
    }

    public int getVotes() {
        return votes;
    }
}
