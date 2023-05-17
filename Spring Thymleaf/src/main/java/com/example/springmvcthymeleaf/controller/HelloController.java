package com.example.springmvcthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.springmvcthymeleaf.model.Candidate;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello.html";
    }
    @PostMapping("/receive")
    public ModelAndView reciveData(@ModelAttribute Candidate candidate,ModelAndView model){
        model.setViewName("candidate.html");
        model.addObject("candidate", candidate);
        return model;
    }

}
