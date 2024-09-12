package com.volzv.vacation_pay_calculator.service;

import com.volzv.vacation_pay_calculator.model.CalculationDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.volzv.vacation_pay_calculator.model.Const.*;

/**
 * Класс, реализующий методы рассчета отпускных
 */
@Service
public class CalculationService {
    /**
     * Метод рассчета отпускных
     *
     * @param averageSalary     - средняя зарплата за месяц
     * @param vacationDaysCount - количество дней отпуска
     * @param vacationStartDate - дата начала отпуска
     * @return - DTO объект с рассчетом
     */
    public CalculationDTO vacationPayCalculate(double averageSalary, int vacationDaysCount, LocalDate vacationStartDate) {
        double vacationPay = averageSalary / AVERAGE_NUMBER_OF_DAYS_IN_MONTH * vacationDaysCount;
        vacationPay = (double) Math.round(vacationPay * 100) / 100;
        LocalDate vacationEndDate = getVacationEndDate(vacationDaysCount, vacationStartDate);

        return CalculationDTO.builder()
                .vacationPay(vacationPay)
                .vacationStartDate(vacationStartDate)
                .vacationEndDate(vacationEndDate)
                .build();
    }

    /**
     * Метод возвращает дату последнего дня отпуска.
     * Принимает на вход количество дней отпуска и дату его начала
     * Если в период отпуска попадают праздники, окончание отпуска переносится
     *
     * @param vacationDaysCount - количество дней отпуска
     * @param vacationStartDate - дата начала отпуска
     * @return - дата, которая будет последним днем отпуска
     */
    private LocalDate getVacationEndDate(int vacationDaysCount, LocalDate vacationStartDate) {
        LocalDate currentData = vacationStartDate.minusDays(1);
        int daysCount = 0;
        while (daysCount < vacationDaysCount) {
            currentData = currentData.plusDays(1);
            if (!isHoliday(currentData)) {
                daysCount++;
            }
        }
        return currentData;
    }

    /**
     * Метод проверяет, является ли переданная дата праздником или нет
     *
     * @param date - передаваемая дата
     * @return true если дата является праздником и false в противном случае
     */
    private boolean isHoliday(LocalDate date) {
        String dateShort = date.format(DateTimeFormatter.ofPattern(DATE_PATTERN_SHORT));
        return HOLIDAYS.stream()
                .anyMatch(h -> h.equals(dateShort));
    }
}
