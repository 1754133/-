package com.example.booksystem.service;

import org.springframework.stereotype.Service;

@Service
public interface MailService {
    String sendCheckCode(String email);

    void sendReservation(String email, String bookName);
}
