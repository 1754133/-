package com.example.booksystem.controller;

import com.example.booksystem.service.ReserveService;
import org.apache.ibatis.annotations.Delete;
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
    public boolean addReservation(@RequestParam int bookId, @RequestParam int userId){
        reserveService.addReservation(bookId, userId);
        return true;
    }

    @GetMapping(value = "/{userId}")
    public List<Map<String, Object>> getReservation(@PathVariable("userId") int userId){
        return reserveService.getReservationByUserId(userId);
    }

    @GetMapping(value = "/{bookId}/{userId}")
    public boolean ifReserved(@PathVariable("bookId") int bookId, @PathVariable("userId") int userId){
        return reserveService.ifReserved(bookId, userId);
    }

    @DeleteMapping(value = "/{bookId}")
    public void deleteReservation(@PathVariable("bookId") int bookId){
        reserveService.deleteReservation(bookId);
    }

    @DeleteMapping(value = "/{bookId}/{userId}")
    public boolean cancelReservation(@PathVariable("bookId") int bookId, @PathVariable("userId") int userId){
        reserveService.cancelReservation(bookId, userId);
        return true;
    }
}
