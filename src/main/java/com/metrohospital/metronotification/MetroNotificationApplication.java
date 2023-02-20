package com.metrohospital.metronotification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MetroNotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MetroNotificationApplication.class, args);
    }

}
