package com.example.BookManager.controller;

import com.example.BookManager.exception.AuthorNotFoundException;
import com.example.BookManager.model.Author;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private List<Author> authorList = new ArrayList<>();

    public AuthorController() {
        authorList.add(new Author(01, "Rabindranath", "rabin@gmail.com"));
        authorList.add(new Author(02, "kazi Najrul", "kazi@gmail.com"));
        authorList.add(new Author(03, "Arif azad", "arif@gmail.com"));
    }

    //to get any author info
    @GetMapping("/get-info/{id}")
    public ResponseEntity<Object> getAuthorInfo(@PathVariable Integer id) {

        for (Author author : authorList) {
            if (author.getId().equals(id)) {
                return new ResponseEntity<>(author, HttpStatus.OK);
            }
        }
        throw new AuthorNotFoundException("Author not found");
    }



    //to get all author info
    @GetMapping("/all-author-details")
    public ResponseEntity<Object> getAllAuthor() {

        if (authorList.isEmpty()) {
            throw new AuthorNotFoundException("Author List is empty! There is no author.");
        }
        Map<String, Object> response = new HashMap<>();
        response.put("numbers of author", authorList.size());
        response.put("author list", authorList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    /*
    //to get all author info
    @GetMapping("/all-author-details")
    public List<Author> getAllAuthor() {
        if (authorList.isEmpty()) {
            throw new AuthorNotFoundException("Author List is empty! There is no author.");
        }
        return authorList;
    }
*/

}
