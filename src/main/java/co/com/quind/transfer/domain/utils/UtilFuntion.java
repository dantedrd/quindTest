package co.com.quind.transfer.domain.utils;

import co.com.quind.transfer.config.exception.CustomException;
import co.com.quind.transfer.config.exception.SPError;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class UtilFuntion {

    public static String transformLocalDateToString(LocalDate time){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaHoraString = time.format(dateFormat);
        return fechaHoraString;
    }
    public static String transformLocalDateTimeToString(LocalDateTime time){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaHoraString = time.format(dateFormat);
        return fechaHoraString;
    }

    public static LocalDate transformStringToLocalDate(String date){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(date, formatter);
        }catch (DateTimeParseException dateTimeParseException){
            throw new CustomException(SPError.INVALID_DATE_FORMAT.getErrorCode(),SPError.INVALID_DATE_FORMAT.getErrorMessage());
        }
    }

    public static LocalDateTime transformStringToLocalDateTime(String date){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            return LocalDateTime.parse(date, formatter);
        }catch (DateTimeParseException dateTimeParseException){
            throw new CustomException(SPError.INVALID_DATE_FORMAT.getErrorCode(),SPError.INVALID_DATE_FORMAT.getErrorMessage());
        }
    }
}
