package com.example.booksystem.controller;

import com.example.booksystem.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/borrow")
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    @PostMapping(value = "/borrowinfo")
    public void borrowBook(@RequestParam int bookId, @RequestParam int userId){
        borrowService.borrowBook(bookId, userId);
    }

    @GetMapping(value = "/borrowinfo")
    public List<Map<String, Object>> getBorrowInfo(){
        return borrowService.getBorrowInfo();
    }

    @GetMapping(value = "/borrowinfo/{userId}")
    public List<Map<String, Object>> getBorrowInfoByUserId(@PathVariable("userId") int userId){
        return borrowService.getBorrowInfoByUserId(userId);
    }

    @GetMapping(value = "/borrowinfo/{bookId}/{userId}")
    public boolean ifBorrowed(@PathVariable("bookId") int bookId, @PathVariable("userId") int userId){
        return borrowService.ifBorrowed(bookId, userId);
    }
}
