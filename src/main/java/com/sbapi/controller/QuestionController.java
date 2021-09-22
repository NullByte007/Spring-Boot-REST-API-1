package com.sbapi.controller;

import com.sbapi.entity.Question;
import com.sbapi.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;


    // test  method
    @GetMapping("/home")
    public String  home()
    {
        return "HELLO ! WELCOME TO QUESTION HOME";
    }

    // To get all questions
    @GetMapping("/questions")
    public List<Question> GetAllQuestions()
    {
        return questionService.getQuestions();
    }

    // get question using ID
    @GetMapping("/question/{qid}")
    public Question getQuestionById(@PathVariable Long qid)
    {
        return questionService.getQuestion(qid).orElse(null);
    }


    // to add question
    @PostMapping("/add-question")
    public Question addQuestion(@RequestBody Question question)
    {
        return questionService.addQuestion(question);
    }

    // update question
    @PutMapping("/update-question")
    public Question updateQuestion(@RequestBody Question question)
    {
        return questionService.updateQuestion(question);
    }

    // to delete the question
    @DeleteMapping("/delete-question/{qid}")
    public String deleteQuestion(@PathVariable Long qid)
    {
        return questionService.deleteQuestion(qid);
    }

    @PutMapping("/upvote-question/{qid}")
    public String upvoteQuestion(@PathVariable Long qid)
    {
        return questionService.upvoteQuestion(qid);
    }

    @PutMapping("/downvote-question/{qid}")
    public String downvoteQuestion(@PathVariable Long qid)
    {
        return questionService.downvoteQuestion(qid);
    }


}
