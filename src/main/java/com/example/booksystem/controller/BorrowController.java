package com.example.booksystem.controller;

import com.example.booksystem.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/borrow")
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    @PostMapping(value = "/borrowinfo")
    public void borrowBook(@RequestParam int bookId, @RequestParam int userId){
        borrowService.borrowBook(bookId, userId, false);
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

    @GetMapping(value = "/borrowinfo/email/{email}")
    public List<Map<String, Object>> getBorrowInfoByEmail(@PathVariable("email") String email){
        return borrowService.getBorrowInfoByEmail(email);
    }

    @GetMapping(value = "/borrowinfo/overdue")
    public List<Map<String, Object>> getOverDueBorrowInfo(){
        return borrowService.getOverDueBorrowInfo();
    }

    @PutMapping(value = "/borrowinfo/{id}")
    public void renew(@PathVariable("id") int id, @RequestParam String shReturnDate) throws ParseException {
        borrowService.renew(id, shReturnDate);
    }

    @GetMapping(value = "/borrowinfo/notice/{userId}")
    public List<Map<String, Object>> getReturnDate(@PathVariable("userId") int userId) throws ParseException {
        return borrowService.checkOverdue(userId);
    }
}
