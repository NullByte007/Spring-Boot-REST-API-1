package com.sbapi.service;

import com.sbapi.entity.Question;
import com.sbapi.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImplementation implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;


    /*  !!!!! NOTE !!!!!
    *  Here we are adding 'this' before all the transactions  because we have implemented interface and we are overriding
    *  the methods from them. Hence, we need this so that we can call the constructor of the implemented interface
    *  Had we not have used interface and directly written functions in QuestionService, we would not require 'this' keyword
    * */

    @Override
    public Question addQuestion(Question question) {

        this.questionRepository.save(question);
        return question;
    }

    @Override
    public List<Question> getQuestions() {
        return this.questionRepository.findAll();
    }


    @Override
    public Optional<Question> getQuestion(Long qid) {
        return this.questionRepository.findById(qid);
    }


    @Override
    public Question updateQuestion(Question question) {
        Question existingQuestion = this.questionRepository.findById(question.getQid()).orElse(null);
        existingQuestion.setQTitle(question.getQTitle());
        existingQuestion.setQDescription(question.getQDescription());
        existingQuestion.setTags(question.getTags());
        existingQuestion.setQUpVoteValue(question.getQUpVoteValue());
        existingQuestion.setQDownVoteValue(question.getQDownVoteValue());
        return this.questionRepository.save(existingQuestion);
    }

    @Override
    public String deleteQuestion(Long qid) {
        this.questionRepository.deleteById(qid);
        return "Question successfully deleted ! ";
    }

    @Override
    public String upvoteQuestion(Long qid) {
        Question q = this.questionRepository.getById(qid);
        q.setQUpVoteValue(q.getQUpVoteValue() + 1);
        this.questionRepository.save(q);
        return "Question Upvoted successfully ! ";
    }

    @Override
    public String downvoteQuestion(Long qid) {
        Question q = this.questionRepository.getById(qid);
        q.setQDownVoteValue(q.getQDownVoteValue() + 1);
        this.questionRepository.save(q);
        return "Question Downvoted successfully ! ";
    }
}
