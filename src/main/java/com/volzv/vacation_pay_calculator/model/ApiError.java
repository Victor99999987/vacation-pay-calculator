package com.volzv.vacation_pay_calculator.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

import static com.volzv.vacation_pay_calculator.model.Const.DATE_PATTERN;


/**
 * Класс содержит информацию об ошибке, возвращенную сервером
 */
@Setter
@Getter
@Builder
public class ApiError {
    private String message;
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN)
    private LocalDateTime timestamp;
}
