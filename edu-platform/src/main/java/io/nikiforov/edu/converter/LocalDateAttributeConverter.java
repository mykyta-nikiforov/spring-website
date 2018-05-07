package io.nikiforov.edu.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.LocalDate;

@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate locDate) {
        System.out.println("From convertToDatabaseColumn. LocalDate: " + locDate + "\nDate: " + Date.valueOf(locDate));
        return (locDate == null ? null : Date.valueOf(locDate));
    }

    @Override
    public LocalDate convertToEntityAttribute(Date sqlDate) {
        System.out.println("From convertToEntityAttribute. LocalDate: " + sqlDate + "\nDate: " + sqlDate.toLocalDate());
        return (sqlDate == null ? null : sqlDate.toLocalDate());
    }
}
