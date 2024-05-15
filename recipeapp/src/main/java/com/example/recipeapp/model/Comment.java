package com.example.recipeapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long commentId;

    @Column(name = "recipe_id")
    Long recipeId;

    @Column(name = "user_id")
    Long userId;

    @Column(name = "content")
    String content;

    public Comment() {
    }

    public Long getCommentId() {
        return commentId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public String getContent() {
        return content;
    }

    public void setCommentId(Long id) {
        this.commentId = id;
    }

    public void setUserId(Long id) {
        this.userId = id;
    }

    public void setRecipeId(Long id) {
        this.recipeId = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
