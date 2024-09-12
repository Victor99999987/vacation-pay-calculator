package com.volzv.vacation_pay_calculator.model;

import java.util.List;

/**
 * Класс для хранения констант
 */
public final class Const {
    private Const() {
    }

    public static final String DATE_PATTERN = "dd.MM.yyyy";
    public static final String DATE_PATTERN_SHORT = "dd.MM";
    public static final List<String> HOLIDAYS = List.of("01.01", "02.01", "03.01", "04.01", "05.01",
            "06.01", "07.01", "08.01", "23.02", "08.03", "01.05", "09.05", "12.06", "04.11");
    public static final double AVERAGE_NUMBER_OF_DAYS_IN_MONTH = 29.3;
}
