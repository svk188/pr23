package com.example.lab18.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

    @Qualifier("getJavaMailSender")
    @Autowired
    private JavaMailSender javaMailSender;

    @Async
    public void sendMessage(String text) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("java_java1@mail.ru");
        message.setTo("java_java1@mail.ru");
        message.setSubject("Info message");
        message.setText(text);

        javaMailSender.send(message);
    }
}
