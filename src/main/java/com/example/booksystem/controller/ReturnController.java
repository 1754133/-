package com.example.booksystem.controller;

import com.example.booksystem.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/returnInfo")
public class ReturnController {
    @Autowired
    private ReturnService returnService;

    @PostMapping
    public void addReturnInfo(@RequestParam int borrowId, @RequestParam String condition, @RequestParam int fine, @RequestParam String remark){
        returnService.addReturnInfo(borrowId, condition, fine, remark);
    }

    @GetMapping("/{userId}")
    public List<Map<String, Object>> getBorrowHistory(@PathVariable("userId") int userId){
        return returnService.getBorrowHistory(userId);
    }
}
