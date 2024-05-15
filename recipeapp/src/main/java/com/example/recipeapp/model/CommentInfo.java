package com.example.recipeapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommentInfo {

    @JsonProperty
    private Long commentId;
    @JsonProperty
    private String content;
    @JsonProperty
    private Long recipeId;
    @JsonProperty
    private String userName;

    public CommentInfo(Long commentId, String content, Long recipeId, String userName) {
        this.commentId = commentId;
        this.content = content;
        this.recipeId = recipeId;
        this.userName = userName;
    }

}
