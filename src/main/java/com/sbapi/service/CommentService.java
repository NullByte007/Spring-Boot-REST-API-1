package com.sbapi.service;

import com.sbapi.entity.Comment;

import java.util.List;

public interface CommentService {

    public Comment addComment(Comment comment);
    public List<Comment> getComments();
    public Comment getComment(Long cid);
    public Comment updateComment(Comment comment);
    public String deleteComment(long cid);

    public String upvoteComment(Long cid);
    public String downnvoteComment(Long cid);

}
