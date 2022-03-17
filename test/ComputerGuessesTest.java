import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class ComputerGuessesTest {
    private final int LOWER_BOUND = 1;
    private  final int UPPER_BOUND = 1000;

    @Test
    void boundsSetProperly(){
        ComputerGuesses GC = new ComputerGuesses(0,LOWER_BOUND,UPPER_BOUND);
        assertEquals(LOWER_BOUND,GC.getLowerBound());
        assertEquals(UPPER_BOUND, GC.getUpperBound());
    }

    @Test
    void numGuessesIncrementsWithHigher(){
        ComputerGuesses CG = new ComputerGuesses(0,LOWER_BOUND,UPPER_BOUND);
        assertEquals(0, CG.getNumGuesses());
        CG.calculateGuess(true,1);
        assertEquals(1,CG.getNumGuesses());
    }

    @Test
    void numGuessesIncrememntsWithLower(){
        ComputerGuesses CG = new ComputerGuesses(0,LOWER_BOUND,UPPER_BOUND);
        assertEquals(0,CG.getNumGuesses());
        CG.calculateGuess(false, 1);
        assertEquals(1, CG.getNumGuesses());
    }

    @Test
    void firstGuessIs501(){
        ComputerGuesses GC = new ComputerGuesses(0,LOWER_BOUND,UPPER_BOUND);
        assertEquals(501, GC.calculateGuess(0));
    }

    @Test
    void lowerBoundCanBeGuessed(){
        ComputerGuesses CG = new ComputerGuesses(0,LOWER_BOUND,UPPER_BOUND);
        Boolean correctAnswer = false;
        Boolean higher = false; //Always lower than guess because it's lowest bound
        int threshold = 20; //IF it isn't found in 20 guesses, something is wrong
        //This is exactly how actual code does it
        CG.calculateGuess(0);
        while(!correctAnswer && CG.getNumGuesses() < threshold){
            int guess = CG.calculateGuess(higher, 1);
            correctAnswer = guess == 1;
        }
        assertEquals(LOWER_BOUND,CG.getLastGuess());
    }

    @Test
    void upperBoundCanBeGuessed(){
        ComputerGuesses CG = new ComputerGuesses(0,LOWER_BOUND,UPPER_BOUND);
        Boolean correctAnswer = false;
        Boolean higher = true; //Always higher than guess, because it's upper bound
        int threshold = 20; //IF it isn't found in 20 guesses, something is wrong
        //This is exactly how actual code does it
        CG.calculateGuess(0);
        while(!correctAnswer && CG.getNumGuesses() < threshold){
            int guess = CG.calculateGuess(higher, 1);
            correctAnswer = guess == UPPER_BOUND;
        }
        assertEquals(UPPER_BOUND,CG.getLastGuess());
    }

    @Test
    void allValuesCanBeGuessed(){
        for(int i=1; i<=1000; i++) {
            ComputerGuesses CG = new ComputerGuesses(0, LOWER_BOUND, UPPER_BOUND);
            Boolean correctAnswer = false;

            int threshold = 20; //IF it isn't found in 20 guesses, something is wrong
            //This is exactly how actual code does it
            Boolean higher = i > CG.calculateGuess(0);
            while (!correctAnswer && CG.getNumGuesses() < threshold) {
                int guess = CG.calculateGuess(higher, 1);
                higher = i> guess;
                correctAnswer = guess == i;
            }
            assertEquals(i, CG.getLastGuess());
        }
    }

    @Test
    void allEvenValuesCanBeGuessed(){
        for(int i=2; i<=1000; i+=2) {
            ComputerGuesses CG = new ComputerGuesses(0, LOWER_BOUND, UPPER_BOUND);
            Boolean correctAnswer = false;

            int threshold = 20; //IF it isn't found in 20 guesses, something is wrong
            //This is exactly how actual code does it
            Boolean higher = i > CG.calculateGuess(0);
            while (!correctAnswer && CG.getNumGuesses() < threshold) {
                int guess = CG.calculateGuess(higher, 1);
                higher = i > guess;
                correctAnswer = guess == i;
            }
            assertEquals(i, CG.getLastGuess());
        }
    }



}
