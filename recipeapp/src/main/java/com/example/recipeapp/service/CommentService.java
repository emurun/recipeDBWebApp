package com.example.recipeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recipeapp.model.Comment;
import com.example.recipeapp.repository.CommentRepository;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByRecipe(Long recipeId) {
        return commentRepository.findByRecipeId(recipeId);
    }

}
