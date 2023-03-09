package com.ms.account.overview.assignment.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = 585767647878L;
    private final String message;
}
