package com.example.booksystem.controller;

import com.example.booksystem.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/reservation")
public class ReserveController {
    @Autowired
    private ReserveService reserveService;

    @PostMapping
    public void addReservation(@RequestParam int bookId, @RequestParam int userId){
        reserveService.addReservation(bookId, userId);
    }

    @GetMapping(value = "/{userId}")
    public List<Map<String, Object>> getReservation(@PathVariable("userId") int userId){
        return reserveService.getReservationByUserId(userId);
    }
}
