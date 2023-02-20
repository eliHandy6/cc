package com.metrohospital.metronotification.emails.service;

import com.metrohospital.metronotification.emails.entities.EmailMessage;

/**
 * @Author: Zack Ogoma
 * Version :1.0.0
 * Email:zackogoma@gmail.com
 **/
public interface EmaiInterface {

    void send(EmailMessage emailMessage);

}
