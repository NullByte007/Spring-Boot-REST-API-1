package com.sbapi.service;

import com.sbapi.entity.Question;
import com.sbapi.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class QuestionServiceImplementation implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {

        questionRepository.save(question);
        return question;
    }

    @Override
    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }


    @Override
    public Optional<Question> getQuestion(Long qid) {
        return questionRepository.findById(qid);
    }


    @Override
    public Question updateQuestion(Question question) {
        Question existingQuestion = questionRepository.findById(question.getQid()).orElse(null);
        existingQuestion.setQTitle(question.getQTitle());
        existingQuestion.setQDescription(question.getQDescription());
        existingQuestion.setTags(question.getTags());
        existingQuestion.setQUpVoteValue(question.getQUpVoteValue());
        existingQuestion.setQDownVoteValue(question.getQDownVoteValue());
        return questionRepository.save(existingQuestion);
    }

    @Override
    public String deleteQuestion(Long qid) {
        questionRepository.deleteById(qid);
        return "Question successfully deleted ! ";
    }
}
