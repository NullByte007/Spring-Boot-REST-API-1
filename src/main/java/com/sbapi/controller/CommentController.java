package com.sbapi.controller;

import com.sbapi.entity.Comment;
import com.sbapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/commentHome")
    public String  commentHome()
    {
        return "HEYY COMMENT !!";
    }

    @PostMapping("/add-comment")
    public Comment addComment(@RequestBody Comment comment)
    {
        return commentService.addComment(comment);
    }

    @GetMapping("/comments")
    public List<Comment> getAllComments()
    {
        return commentService.getComments();
    }

    @GetMapping("/comment/{cid}")
    public Comment getCommentById(@PathVariable  Long cid)
    {
        return commentService.getComment(cid);
    }

    @PutMapping("/update-comment")
    public Comment updateComment(@RequestBody Comment comment)
    {
        return commentService.updateComment(comment);
    }

    @DeleteMapping("/delete-comment/{cid}")
    public String deleteComment(@PathVariable Long cid)
    {
        return commentService.deleteComment(cid);
    }

    @PutMapping("/upvote-comment/{cid}")
    public String upvoteComment(@PathVariable Long cid)
    {
        return commentService.upvoteComment(cid);
    }


    @PutMapping("/downvote-comment/{cid}")
    public String downvoteComment(@PathVariable Long cid)
    {
        return commentService.downnvoteComment(cid);
    }


}
