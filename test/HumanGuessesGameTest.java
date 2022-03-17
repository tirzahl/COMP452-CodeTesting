import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.util.Random;


public class HumanGuessesGameTest {

    @Test
    void setUpCorrectly() {
        RandomTestStub myRandTestStub = new RandomTestStub(500);
        HumanGuessesGame myHGGTest = new HumanGuessesGame(myRandTestStub);
        assertEquals(0, myHGGTest.getNumGuesses());
        assertEquals(false, myHGGTest.isDone());
        assertEquals(500, myHGGTest.getTarget());
    }

    @Test
    void guessIncrements(){
        RandomTestStub myRandTestStub = new RandomTestStub(500);
        HumanGuessesGame myHGGTest = new HumanGuessesGame(myRandTestStub);
        assertEquals(0, myHGGTest.getNumGuesses());
        myHGGTest.makeGuess(1);
        assertEquals(myHGGTest.getNumGuesses(), 1);
    }

    @Test
    void lowGuessReturnsLow(){
        RandomTestStub myRandTestStub = new RandomTestStub(500);
        HumanGuessesGame myHGGTest = new HumanGuessesGame(myRandTestStub);
        assertEquals(GuessResult.LOW, myHGGTest.makeGuess(1));
    }

    @Test
    void highGuessReturnsHigh(){
        RandomTestStub myRandTestStub = new RandomTestStub(500);
        HumanGuessesGame myHGGTest = new HumanGuessesGame(myRandTestStub);
        assertEquals(GuessResult.HIGH, myHGGTest.makeGuess(1000));
    }

}
