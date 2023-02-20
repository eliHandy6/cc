package com.metrohospital.metronotification.emails;


import com.metrohospital.metronotification.emails.entities.EmailMessage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Zack Ogoma
 * Version :1.0.0
 * Email:zackogoma@gmail.com
 **/
public interface EmailRepository extends JpaRepository<EmailMessage, Long> {
}
