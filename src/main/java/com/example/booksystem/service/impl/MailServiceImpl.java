package com.example.booksystem.service.impl;

import com.example.booksystem.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MailServiceImpl implements MailService {
    @Value("${spring.mail.username}")
    private String from;
    @Autowired
    private JavaMailSender mailSender;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public String sendCheckCode(String email){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        String checkCode = String.valueOf(new Random().nextInt(799999) + 100000);
        String message = "您的注册验证码为：" + checkCode;
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("注册验证码");
        simpleMailMessage.setText(message);
        mailSender.send(simpleMailMessage);
        logger.info("邮件发送成功！");
        return checkCode;
    }

    public void sendReservation(String email, String bookName){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        String message = "您在图书馆所预约的图书：《" + bookName + "》已经成功借阅，请及时去图书馆取走书籍，并注意归还时间。";
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("图书预定通知");
        simpleMailMessage.setText(message);
        mailSender.send(simpleMailMessage);
        logger.info("邮件发送成功！");
    }

    public void sendOverDueMail(String email, String bookName){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        String message = "您在图书馆所借阅的图书：《" + bookName + "》已经超过归还期限，为避免影响您的账号的后续使用，请尽快前往图书馆归还书籍。";
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("图书超期通知");
        simpleMailMessage.setText(message);
        mailSender.send(simpleMailMessage);
        logger.info("邮件发送成功！");
    }
}
