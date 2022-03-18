import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.util.Random;

//all tests in this class use dependency injection
public class HumanGuessesGameTest {
    private  final int UPPER_BOUND = 1000;
    private final GuessResult CorrectGR = GuessResult.CORRECT;

    //using dependency injection
    @Test
    void setUpCorrectly() {
        RandomTestStub myRandTestStub = new RandomTestStub(500);
        HumanGuessesGame myHGGTest = new HumanGuessesGame(myRandTestStub);
        assertEquals(0, myHGGTest.getNumGuesses());
        assertFalse(myHGGTest.isDone());
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


    @Test
    void boundsSetProperly(){
        RandomTestStub myRandTestStub = new RandomTestStub(500);
        HumanGuessesGame HGG = new HumanGuessesGame(myRandTestStub);
        assertEquals(UPPER_BOUND, HGG.getUpperBound());
    }

    @Test
    void numGuessesIncrementsWithHigher(){
        RandomTestStub myRandTestStub = new RandomTestStub(500);
        HumanGuessesGame HGG = new HumanGuessesGame(myRandTestStub);
        assertEquals(0, HGG.getNumGuesses());
        HGG.makeGuess(700);
        assertEquals(1, HGG.getNumGuesses());
    }

    @Test
    void numGuessesIncrementsWithLower(){
        RandomTestStub myRandTestStub = new RandomTestStub(500);
        HumanGuessesGame HGG = new HumanGuessesGame(myRandTestStub);
        assertEquals(0,HGG.getNumGuesses());
        HGG.makeGuess(300);
        assertEquals(1, HGG.getNumGuesses());
    }

    @Test
    void firstGuessIs501(){
        RandomTestStub myRandTestStub = new RandomTestStub(501);
        HumanGuessesGame HGG = new HumanGuessesGame(myRandTestStub);
        GuessResult GR = HGG.makeGuess(501);
        assertEquals(CorrectGR, GR);
    }

    @Test
    void gameCorrectlySetToDone() {
        RandomTestStub myRandTestStub = new RandomTestStub(325);
        HumanGuessesGame HGG = new HumanGuessesGame(myRandTestStub);
        HGG.makeGuess(325);
        assertTrue(HGG.isDone());
    }




}
