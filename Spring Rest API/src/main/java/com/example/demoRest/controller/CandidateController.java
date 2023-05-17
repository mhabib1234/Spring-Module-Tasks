package com.example.demoRest.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class CandidateController {
    @GetMapping("/get-info/{id}")
    public admin getAdminInfo(@PathVariable Int id){
        return new Admin("BJIT admin");
    }

}
