import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;


public class HumanGuessesGameTest {

    @Test
    void setUpCorrectly() {
        RandomTestStub myRandTestStub = new RandomTestStub(500);
        HumanGuessesGame myHGGTest = new HumanGuessesGame(myRandTestStub);
        assertEquals(0, myHGGTest.getNumGuesses());
        assertEquals(false, myHGGTest.isDone());
        assertEquals(500, myHGGTest.getTarget());
    }

}
