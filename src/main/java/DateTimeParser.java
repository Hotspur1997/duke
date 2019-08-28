import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;

enum TimePatternType {
    DAY_OF_WEEK, DATE_TIME, DATE, TIME
}

public class DateTimeParser {
    LocalDateTime parseStringToDate(String line) throws DukeException {
        String[] patterns = {"['next ']['this ']E", "['this ']['next ']EEEE", "dd/MM/yyyy HHmm",
                "d/MM/yyyy HHmm", "dd/MM/yy HHmm", "HHmm",
                "dd/MM/yy", "yyyy-MM-dd'T'HH:mm[:ss.n]"};
        TimePatternType[] types = {TimePatternType.DAY_OF_WEEK, TimePatternType.DAY_OF_WEEK,
                TimePatternType.DATE_TIME, TimePatternType.DATE_TIME, TimePatternType.DATE_TIME, TimePatternType.TIME, TimePatternType.DATE,
                TimePatternType.DATE_TIME};
        int i = 0;
        while (i < patterns.length) {
            try {
                TemporalAccessor ac = DateTimeFormatter.ofPattern(patterns[i]).parse(line);
                switch (types[i]) {
                    case DAY_OF_WEEK:
                        LocalDateTime localDateTime = LocalDateTime.now();
                        return localDateTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.from(ac)));
                    case DATE_TIME:
                        return LocalDateTime.from(ac);
                    case TIME:
                        LocalDate localDate = LocalDate.now();
                        return localDate.atTime(LocalTime.from(ac));
                    case DATE:
                        LocalTime localTime = LocalTime.now();
                        return localTime.atDate(LocalDate.from(ac));
                    default:
                }
            } catch (DateTimeParseException e) {
                i++;
            }
        }
        throw new DukeException("The format is invalid! Please try writing in a better format");
    }
}
