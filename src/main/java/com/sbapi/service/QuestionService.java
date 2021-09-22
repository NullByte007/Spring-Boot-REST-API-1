package com.sbapi.service;

import com.sbapi.entity.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {


    public Question addQuestion(Question question);
    public List<Question> getQuestions();
    public Optional<Question> getQuestion(Long qid);
    public Question updateQuestion(Question question);
    public String deleteQuestion(Long qid);

    public String upvoteQuestion(Long qid);
    public String downvoteQuestion(Long qid);
}
