package com.ms.account.management.controller;

import com.ms.account.management.exception.DataNotFoundException;
import com.ms.account.management.exception.ApiError;
import com.ms.account.management.exception.BadRequestException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class AccountManagementExceptionHandlerTest {

    @InjectMocks
    AccountManagementExceptionHandler exceptionHandler;

    @Mock
    HttpServletRequest request;

    @Test
    void handleAccountsNotFoundException() {
        DataNotFoundException exception = DataNotFoundException.builder()
                .message(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build();
        ResponseEntity<ApiError> response = exceptionHandler.handleAccountsNotFoundException(exception, request);
        assertThat(response.getStatusCode(), is(HttpStatus.NOT_FOUND));
        assertNotNull(response.getBody());
        assertThat(response.getBody().getErrorMessage(), is("Not Found"));
    }

    @Test
    void handleBadRequestException() {
        BadRequestException exception = BadRequestException.builder()
                .message(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .build();
        ResponseEntity<ApiError> response = exceptionHandler.handleBadRequestException(exception, request);
        assertThat(response.getStatusCode(), is(HttpStatus.BAD_REQUEST));
        assertNotNull(response.getBody());
        assertThat(response.getBody().getErrorMessage(), is("Bad Request"));
    }

    @Test
    void handleGenericException() {
        Exception exception = mock(Exception.class);
        ResponseEntity<ApiError> response = exceptionHandler.handleException(exception, request);
        assertThat(response.getStatusCode(), is(HttpStatus.INTERNAL_SERVER_ERROR));
    }
}