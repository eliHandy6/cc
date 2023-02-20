package com.metrohospital.metronotification.emails.service;

import com.metrohospital.metronotification.emails.dtos.EmailDto;


public interface EmailService {

    void stageAndSendEmail(EmailDto emailDto);
}
