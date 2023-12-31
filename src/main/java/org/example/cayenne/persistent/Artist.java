package org.example.cayenne.persistent;

import org.example.cayenne.persistent.auto._Artist;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Artist extends _Artist {

    private static final long serialVersionUID = 1L;

    static final String DEFAULT_DATE_FORMAT = "yyyyMMdd";

    /**
     * Sets date of birth using a string in format yyyyMMdd.
     */
    public void setDateOfBirthString(String yearMonthDay) {
        if (yearMonthDay == null) {
            setDateOfBirth(null);
            return;
        }

        LocalDate date;
        try {
            DateTimeFormatter formatter = DateTimeFormatter
                    .ofPattern(DEFAULT_DATE_FORMAT);
            date = LocalDate.parse(yearMonthDay, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(
                    "A date argument must be in format '"
                            + DEFAULT_DATE_FORMAT + "': " + yearMonthDay);
        }
        setDateOfBirth(date);
    }

}
