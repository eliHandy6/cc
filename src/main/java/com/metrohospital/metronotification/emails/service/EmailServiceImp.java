package com.metrohospital.metronotification.emails.service;

import com.metrohospital.metronotification.emails.EmailRepository;
import com.metrohospital.metronotification.emails.dtos.EmailDto;
import com.metrohospital.metronotification.emails.entities.EmailMessage;
import com.metrohospital.metronotification.emails.enums.MessageStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * @Author: Zack Ogoma
 * Version :1.0.0
 * Email:zackogoma@gmail.com
 **/

@Service
public class EmailServiceImp implements EmailService {

    private final EmailRepository emailRepository;

    private final EmaiInterface emaiInterface;

    public EmailServiceImp(EmailRepository emailRepository, EmaiInterface emaiInterface) {
        this.emailRepository = emailRepository;
        this.emaiInterface = emaiInterface;
    }

    @Override
    public void stageAndSendEmail(EmailDto emailDto) {

        EmailMessage mailMessage = EmailMessage.builder()
                .receipientAdress(emailDto.getRecipientsAddress())
                .message(emailDto.getMessage())
                .preparedBy("Metro")
                .status(String.valueOf(MessageStatus.D))
                .emailFrom(emailDto.getEmailFrom())
                .subject(emailDto.getSubject())
                .dateToSend(LocalDate.now())
                .datePrepared(LocalDate.now())
                .retryCount(0)
                .build();
        mailMessage = emailRepository.save(mailMessage);
        emaiInterface.send(mailMessage);


    }


}
