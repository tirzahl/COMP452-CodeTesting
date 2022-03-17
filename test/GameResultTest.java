import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;


public class GameResultTest {

    @Test
    void testConstructor(){
        GameResult GR = new GameResult(true, 500, 1);
        assertEquals(1,GR.getNumGuesses());
        assertTrue(GR.getHumanWasPlaying());
        assertEquals(500,GR.getCorrectValue());
    }
}
