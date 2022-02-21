package com.misyn.courier.company.service;


public interface SendEmailService {
    public void sendEmail(String to, String subject, String text);
}
