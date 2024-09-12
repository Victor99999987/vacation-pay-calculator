package com.volzv.vacation_pay_calculator.service;

import com.volzv.vacation_pay_calculator.model.CalculationDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculationServiceTest {
    private CalculationService calculationService;

    @BeforeEach
    void setUp() {
        calculationService = new CalculationService();
    }

    @Test
    @DisplayName("При расчете отпуска от текущей даты на 14 дней при средней зарплате 50000 отпускные должны быть 23890.78")
    void test1() {
        double averageSalary = 50000;
        int vacationDaysCount = 14;
        LocalDate vacationStartDate = LocalDate.now();

        double vacationPay = 23890.78; // 50000 / 29.3 * 14

        CalculationDTO result = calculationService.vacationPayCalculate(averageSalary, vacationDaysCount, vacationStartDate);
        assertEquals(vacationPay, result.getVacationPay());
    }

    @Test
    @DisplayName("При расчете отпуска от 01.01.2024 на 14 дней последним днем отпуска должен быть 22.01.2024")
    void test2() {
        double averageSalary = 50000;
        int vacationDaysCount = 14;
        LocalDate vacationStartDate = LocalDate.of(2024,01,01);
        LocalDate vacationEndDate = LocalDate.of(2024,01,22);

        CalculationDTO result = calculationService.vacationPayCalculate(averageSalary, vacationDaysCount, vacationStartDate);
        assertEquals(vacationEndDate, result.getVacationEndDate());
    }


    @Test
    @DisplayName("При расчете отпуска от текущей даты на 14 дней в ответе находится та же дата начала отпуска")
    void test3() {
        double averageSalary = 50000;
        int vacationDaysCount = 14;
        LocalDate vacationStartDate = LocalDate.now();

        CalculationDTO result = calculationService.vacationPayCalculate(averageSalary, vacationDaysCount, vacationStartDate);
        assertEquals(vacationStartDate, result.getVacationStartDate());
    }

}