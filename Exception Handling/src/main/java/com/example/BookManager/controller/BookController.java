package com.example.BookManager.controller;

import com.example.BookManager.exception.BookNotFoundException;
import com.example.BookManager.model.Book;
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
@RequestMapping("/book")
public class BookController {
    private List<Book> bookList = new ArrayList<>();

    public  BookController () {
        bookList.add(new Book("12 rules of life", 1, 50, 01));
        bookList.add(new Book("The Happiness Hypothesis", 2, -30, 02));
        bookList.add(new Book("Thinking Fast and Slow", 3, 100, 03));
    }


    //to get any book info
    @GetMapping("/get-info/{id}")
    public ResponseEntity<Object> getBookInfo(@PathVariable Integer id) {

        for (Book book : bookList) {
            if (book.getId().equals(id)) {
                return new ResponseEntity<>(book, HttpStatus.OK);
            }
        }
        throw new BookNotFoundException("Book not found");
    }


//get all books
@GetMapping("/all-books-details")
public ResponseEntity<Object> getAllBooks() {
    if (bookList.isEmpty()) {
        throw new BookNotFoundException("Book List is empty! There is no Book in the list.");
    }
    Map<String, Object> response = new HashMap<>();
    response.put("totalBooks", bookList.size());
    response.put("books", bookList);

    return new ResponseEntity<>(response, HttpStatus.OK);
}



    //get price

    @GetMapping("/calculate-price/{id}/{quantity}")
    public ResponseEntity<Object> calculatePrice(@PathVariable Integer id, @PathVariable Integer quantity) {
        for (Book book : bookList) {
            if (book.getId().equals(id)) {
                Integer totalPrice = book.getPrice() * quantity;
                if(totalPrice < 0) {
                    throw new IllegalArgumentException("Total price must be greater than 0");
                }
                Map<String, Object> response = new HashMap<>();
                response.put("totalPrice", totalPrice);
                response.put("bookPrice", book.getPrice());
                response.put("bookQuantity", quantity);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        }
        throw new BookNotFoundException("Book not found");
    }




        /*
    //to get all book info-----------------------------------------------------------------------

    @GetMapping("/all-books-details")
    public List<Book> getAllBooks() {
        if (bookList.isEmpty()) {
            throw new BookNotFoundException("Book List is empty! There is no Book in the list.");
        }
        int totalBooks = bookList.size();
        return bookList;
    }

    //get all books------------------------------------------------------------------------------

       @GetMapping("/all-books-details")
    public Map<String, Object> getAllBooks() {
        if (bookList.isEmpty()) {
            throw new BookNotFoundException("Book List is empty! There is no Book in the list.");
        }
        Map<String, Object> response = new HashMap<>();
        response.put("totalBooks", bookList.size());
        response.put("books", bookList);

        return response;
    }

    //to get price------------------------------------------------------------------------------------

     @GetMapping("/calculate-price/{id}/{quantity}")
    public Map<String, Object> calculatePrice(@PathVariable Integer id, @PathVariable Integer quantity) {
        for (Book book : bookList) {
            if (book.getId().equals(id)) {
                Integer totalPrice = book.getPrice() * quantity;
                if(totalPrice < 0) {
                    throw new IllegalArgumentException("Total price must be greater than 0");
                }
                Map<String, Object> response = new HashMap<>();
                response.put("total price:", totalPrice);
                response.put("Book Price ", book.getPrice());
                response.put("Book Quantity ", quantity);
                return response;
            }
        }
        throw new BookNotFoundException("Book not found");
    }

*/

}
