package com.example.booksystem.controller;

import com.example.booksystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/{keywords}/{typeId}")
    public List<Map<String, Object>> getBooksByKeywordAndType(@PathVariable(value = "keywords") String keywords, @PathVariable(value = "typeId") int typeId){
        return bookService.getBooksByKeywordsAndType(keywords, typeId);
    }

    @GetMapping(value = "/keywords/{keywords}")
    public List<Map<String, Object>> getBooksByKeywords(@PathVariable(value = "keywords") String keywords){
        return bookService.getBooksByKeywords(keywords);
    }

    @PostMapping
    public boolean addBook(@RequestParam String name, @RequestParam String press, @RequestParam String author, @RequestParam String shelfId, @RequestParam String synopsis, @RequestParam int typeId, @RequestParam int remain, @RequestParam String isbn){
        return bookService.addBook(name, press, author, shelfId, synopsis, typeId, remain, isbn);
    }

    @PutMapping(value = "/{bookId}")
    public void updateBookInfo(@PathVariable("bookId") int bookId, @RequestParam String name, @RequestParam String press, @RequestParam String author, @RequestParam String shelfId, @RequestParam String synopsis, @RequestParam int typeId, @RequestParam int remain, @RequestParam String isbn){
        bookService.updateBookInfo(bookId, name, press, author, shelfId, synopsis, typeId, remain, isbn);
    }

    @PutMapping(value = "/remain/{bookId}")
    public boolean updateRemain(@PathVariable("bookId") int bookId){
        bookService.updateRemain(bookId);
        return true;
    }
}
