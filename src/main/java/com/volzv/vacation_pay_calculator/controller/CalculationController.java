package com.volzv.vacation_pay_calculator.controller;

import com.volzv.vacation_pay_calculator.model.CalculationDTO;
import com.volzv.vacation_pay_calculator.service.CalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;
import java.time.LocalDate;

import static com.volzv.vacation_pay_calculator.model.Const.DATE_PATTERN;

@Validated
@RestController
@RequiredArgsConstructor
public class CalculationController {
    private final CalculationService calculationService;

    @GetMapping("/calculate")
    @ResponseStatus(HttpStatus.OK)
    CalculationDTO getCalculate(@RequestParam @Positive double averageSalary,
                                @RequestParam @Positive int vacationDaysCount,
                                @RequestParam @DateTimeFormat(pattern = DATE_PATTERN) LocalDate vacationStartDate) {
        return calculationService.vacationPayCalculate(averageSalary, vacationDaysCount, vacationStartDate);
    }

}
