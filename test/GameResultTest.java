import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;


public class GameResultTest {

    @Test
    void testConstructor(){
        GameResult GR = new GameResult(true, 500, 1);
        assertEquals(GR.getNumGuesses(),1);
        assertTrue(GR.getHumanWasPlaying());
        assertEquals(GR.getCorrectValue(),500);
    }
}
