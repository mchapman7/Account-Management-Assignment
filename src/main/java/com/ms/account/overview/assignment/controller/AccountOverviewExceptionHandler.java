package com.ms.account.overview.assignment.controller;

import com.ms.account.overview.assignment.exception.*;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
@NoArgsConstructor
public class AccountOverviewExceptionHandler {

    @ExceptionHandler(AccountsNotFoundException.class)
    public ResponseEntity<ApiError> handleAccountsNotFoundException(final AccountsNotFoundException exception,
                                                                    final HttpServletRequest request) {
        logException(exception, request, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(ApiError.buildErrorResponse(exception, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TransactionsNotFoundException.class)
    public ResponseEntity<ApiError> handleTransactionsNotFoundException(final TransactionsNotFoundException exception,
                                                                        final HttpServletRequest request) {
        logException(exception, request, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(ApiError.buildErrorResponse(exception, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> handleBadRequestException(final BadRequestException exception,
                                                                        final HttpServletRequest request) {
        logException(exception, request, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(ApiError.buildErrorResponse(exception, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleException(final Exception exception,
                                                              final HttpServletRequest request) {
        logException(exception, request, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(ApiError.buildErrorResponse(exception, HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private void logException(Throwable exception, HttpServletRequest request, HttpStatus status) {
        log.error("message=\"Exception in ms-account-overview\"", exception);
    }

}
