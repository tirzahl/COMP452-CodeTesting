import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class StatsFileHelper {
    public static LocalDateTime parseTimestamp(String value0) {
        try {
            return LocalDateTime.parse(value0);
        } catch (DateTimeParseException dtpe) {
            throw dtpe;
        }
    }

    public static int getNumGuesses(String value1) {
        try {
            return Integer.parseInt(value1);
        } catch (NumberFormatException nfe) {
            throw nfe;
        }
    }
}
