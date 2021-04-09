package utilities.date;


import java.time.LocalDate;
import java.util.regex.Pattern;

public class Date {
    private static final Pattern DATE_PATTERN = Pattern.compile("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$");

    public static LocalDate toLocalDate(String date) {
        String[] split = date.split("-");
        return LocalDate.of(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
    }

    public static boolean isDateValid(String date) {
        return DATE_PATTERN.matcher(date).matches();
    }
}
