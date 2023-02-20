package com.metrohospital.metronotification.emails.dtos;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @Author: Zack Ogoma
 * Version :1.0.0
 * Email:zackogoma@gmail.com
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class EmailDto {

    @NotNull(message = "Email from  is missing")
    @Email(message = "Invalid email address")
    private String emailFrom;

    @NotNull(message = "Email subject is missing")
    private String subject;
    @NotNull(message = "Email Body is missing")
    private String message;
    @NotNull(message = "Email recipients address  is missing")
    @Email(message = "Invalid email address")
    private String recipientsAddress;

    private Map<String, Object> props;
}
