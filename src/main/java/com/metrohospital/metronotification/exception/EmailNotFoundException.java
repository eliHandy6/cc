package com.metrohospital.metronotification.exception;

/**
 * @Author: Zack Ogoma
 * Version :1.0.0
 * Email:zackogoma@gmail.com
 **/
public class EmailNotFoundException extends RuntimeException {

    public EmailNotFoundException(Long id) {
        super("Email id not found : " + id);
    }


}