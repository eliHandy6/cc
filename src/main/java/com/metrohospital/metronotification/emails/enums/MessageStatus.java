package com.metrohospital.metronotification.emails.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageStatus {

    R("R"),
    S("S"),
    D("D"),
    OK("OK");

    private String name;
}