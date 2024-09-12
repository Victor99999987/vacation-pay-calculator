package com.volzv.vacation_pay_calculator.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

import static com.volzv.vacation_pay_calculator.model.Const.DATE_PATTERN;

/**
 * Класс, содержит информацию о результатах рассчета
 */
@Getter
@Builder
public class CalculationDTO {
    private double vacationPay;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN)
    private LocalDate vacationStartDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN)
    private LocalDate vacationEndDate;
}
