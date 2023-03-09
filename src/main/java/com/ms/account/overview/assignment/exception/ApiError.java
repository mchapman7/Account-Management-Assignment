package com.ms.account.overview.assignment.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@Builder
public class ApiError {

    private String errorId;
    private String errorMessage;
    private HttpStatus httpStatus;

    public static ApiError buildErrorResponse(Throwable exception, HttpStatus httpStatus) {
        return ApiError.builder()
                .errorId(httpStatus.name())
                .errorMessage(exception.getMessage())
                .httpStatus(httpStatus)
                .build();
    }

}
