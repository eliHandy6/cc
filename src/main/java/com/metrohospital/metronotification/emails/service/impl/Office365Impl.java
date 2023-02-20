package com.metrohospital.metronotification.emails.service.impl;

import com.metrohospital.metronotification.emails.EmailRepository;
import com.metrohospital.metronotification.emails.entities.EmailMessage;
import com.metrohospital.metronotification.emails.enums.MessageStatus;
import com.metrohospital.metronotification.emails.service.EmaiInterface;
import groovy.util.logging.Slf4j;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class Office365Impl implements EmaiInterface {

    private final EmailRepository emailRepository;
    private final JavaMailSender mailSender;

    @Override
    public void send(EmailMessage emailMessage) {
        int retryCount = emailMessage.getRetryCount() == null ? 0 : emailMessage.getRetryCount();
        try {
            if (retryCount < 3) {
                String body = emailMessage.getMessage() + "<br/><br/>";
                MimeMessage mimeMessage = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
                helper.setText(body, true);
                helper.setTo(emailMessage.getReceipientAdress());
                helper.setSubject(emailMessage.getSubject());
                helper.setFrom(emailMessage.getEmailFrom());
                mailSender.send(mimeMessage);
                emailMessage.setStatus(String.valueOf(MessageStatus.S));
                emailRepository.save(emailMessage);
            }

        } catch (MessagingException e) {
            ++retryCount;
            emailRepository.save(emailMessage);
            throw new IllegalStateException("failed to send email");
        }

    }
}