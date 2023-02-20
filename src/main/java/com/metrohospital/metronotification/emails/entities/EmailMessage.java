/**
 *
 */
package com.metrohospital.metronotification.emails.entities;

import com.metrohospital.metronotification.audit.AuditModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "email_messages")
public class EmailMessage extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMAIL_CODE")
    private Long id;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @Column(name = "EMAIL_SENDER_ADDRESS")
    private String emailFrom;

    @Column(name = "EMAIL_TO_SEND_DATE")
    private LocalDate dateToSend;

    @Column(name = "EMAIL_SUBJ")
    private String subject;

    @Column(name = "EMAIL_SENT_RESPONSE")
    private String sentReponse;

    @Column(name = "EMAIL_SEND_DATE")
    private LocalDate dateSent;

    @Column(name = "EMAIL_PREPARED_DATE")
    private LocalDate datePrepared;

    @Column(name = "EMAIL_PREPARED_BY")
    private String preparedBy;

    @Column(name = "EMAIL_MSG", nullable = false)
    private String message;

    @Column(name = "EMAIL_RETRIES_COUNT")
    private Integer retryCount;

    @Column(name = "EMAIL_RECEIPIENT")
    private String receipientAdress;

    @Column(name = "EMAIL_STATUS")
    private String status;


}
