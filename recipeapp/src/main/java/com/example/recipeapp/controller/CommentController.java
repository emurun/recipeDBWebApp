package com.example.recipeapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import com.example.recipeapp.model.Comment;
import com.example.recipeapp.model.CommentInfo;
import com.example.recipeapp.model.LongObject;
import com.example.recipeapp.model.User;
import com.example.recipeapp.service.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    CommentService commentService;
    UserService userService;

    public CommentController(CommentService commentService, UserService userService) {
        this.commentService = commentService;
        this.userService = userService;
    }

    @RequestMapping(path = "/postComment", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<Comment> postComment(@RequestBody Comment comment) {
        System.out.println("Posting comment for recipe: " + comment.getRecipeId() + " by user " + comment.getUserId());
        Comment com = commentService.saveComment(comment);
        return new ResponseEntity<>(com, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/getRecipeComments", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<List<CommentInfo>> getRecipeComments(@RequestBody LongObject rId) {
        Long recipeId = rId.getLong();
        List<Comment> comments = commentService.getCommentsByRecipe(recipeId);

        List<CommentInfo> commentInfos = new ArrayList<CommentInfo>();
        for (int i = 0; i < comments.size(); i++) {
            Comment comment = comments.get(i);
            User user = userService.findByUserId(comment.getUserId());
            String userName = user.getUserName();
            CommentInfo cInfo = new CommentInfo(comment.getCommentId(), comment.getContent(), comment.getRecipeId(),
                    userName);
            commentInfos.add(cInfo);
        }

        return new ResponseEntity<>(commentInfos, HttpStatus.ACCEPTED);
    }

}
