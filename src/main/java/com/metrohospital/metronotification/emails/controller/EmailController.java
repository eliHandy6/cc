package com.metrohospital.metronotification.emails.controller;

import com.metrohospital.metronotification.emails.dtos.EmailDto;
import com.metrohospital.metronotification.emails.service.EmailService;
import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Zack Ogoma
 * Version :1.0.0
 * Email:zackogoma@gmail.com
 **/


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/apis/v1/emails")
@Tag(name = "Emails")
public class EmailController {


    private final EmailService emailService;

    @Operation(summary = "Send Email notification")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = " Email notification sent",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Object.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid body",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Something wrong happened",
                    content = @Content)})
    @PostMapping
    public void sendNotification(
            @RequestBody @Valid EmailDto emailDto) {
        emailService.stageAndSendEmail(emailDto);

    }
}
