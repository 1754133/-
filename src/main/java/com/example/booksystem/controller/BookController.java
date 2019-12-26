package com.example.booksystem.controller;

import com.example.booksystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/books")
public class BookController {
    @Autowired
    private BookService bookService;

    //详情界面
    @GetMapping(value = "/{bookId}")
    public Map<String, Object> getBookById(@PathVariable(value = "bookId") int bookId){
        return bookService.getBookById(bookId);
    }

    @GetMapping(value = "/type/{typeName}")
    public List<Map<String, Object>> getBooksByType(@PathVariable(value = "typeName") String typeName){
        return bookService.getBooksByType(typeName);
    }

    @GetMapping(value = "/keywords/{keywords}")
    public List<Map<String, Object>> getBooksByKeywords(@PathVariable(value = "keywords") String keywords){
        return bookService.getBooksByKeywords(keywords);
    }
}
