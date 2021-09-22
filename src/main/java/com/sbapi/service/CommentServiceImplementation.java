package com.sbapi.service;

import com.sbapi.entity.Comment;
import com.sbapi.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImplementation implements  CommentService{

    @Autowired
    private CommentRepository commentRepository;



    @Override
    public Comment addComment(Comment comment) {
         this.commentRepository.save(comment);
         return comment;
    }

    @Override
    public List<Comment> getComments() {

        return this.commentRepository.findAll();

    }

    @Override
    public Comment getComment(Long cid) {
        return this.commentRepository.findById(cid).orElse(null);
    }

    @Override
    public Comment updateComment(Comment comment) {
        Comment existingComment = this.commentRepository.findById(comment.getCid()).orElse(null);
        existingComment.setCommentValue(comment.getCommentValue());
        return this.commentRepository.save(existingComment);

    }

    @Override
    public String deleteComment(long cid) {
        this.commentRepository.deleteById(cid);
        return "Comment successfully deleted ! ";
    }

    @Override
    public String upvoteComment(Long cid) {
        Comment c = this.commentRepository.getById(cid);
        c.setCUpVoteValue(c.getCUpVoteValue() + 1);
        this.commentRepository.save(c);
        return "Comment Upvoted ! ";
    }

    @Override
    public String downnvoteComment(Long cid) {
        Comment c = this.commentRepository.getById(cid);
        c.setCDownVoteValue(c.getCDownVoteValue() + 1);
        this.commentRepository.save(c);
        return "Comment Downvoted ! ";
    }
}
