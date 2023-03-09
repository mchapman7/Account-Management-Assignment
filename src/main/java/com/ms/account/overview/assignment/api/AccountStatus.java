package com.ms.account.overview.assignment.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountStatus {
    OPENED("OPENED"),
    CLOSED("CLOSED");

    private final String value;

    public static AccountStatus getValue(String status) {
        for (AccountStatus v : values()) {
            if (v.toString().equalsIgnoreCase(status)) {
                return v;
            }
        }
        return null;
    }
}
