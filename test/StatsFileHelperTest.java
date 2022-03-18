import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

public class StatsFileHelperTest {

    @Test
    void parsesIntCorrectly() {
        assertEquals(1, StatsFileHelper.getNumGuesses("1"));
    }

    @Test
    void parsesTimestampCorrectly() {
        assertEquals(LocalDateTime.of(2022,03,17,10,36,17), StatsFileHelper.parseTimestamp("2022-03-17T10:36:17"));
    }

    @Test
    void throwsNumFormatException() {
        assertThrows(NumberFormatException.class, () -> { StatsFileHelper.getNumGuesses("hello"); });
    }

    @Test
    void throwsDateTimeParseException() {
        assertThrows(DateTimeParseException.class, () -> { StatsFileHelper.parseTimestamp("hello"); });
    }


}
