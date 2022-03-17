/**
 * Data class to hold the result of a game
 * Refactored to make member variables private
 * Public member variables were un-needed and dangerous
 */
public class GameResult {
    private final boolean humanWasPlaying;
    private final int correctValue;
    private final int numGuesses;

    public GameResult(boolean humanWasPlaying, int correctValue, int numGuesses){
        this.humanWasPlaying = humanWasPlaying;
        this.correctValue = correctValue;
        this.numGuesses = numGuesses;
    }

    public boolean getHumanWasPlaying(){
        return humanWasPlaying;
    }

    public int getCorrectValue(){
        return correctValue;
    }

    public int getNumGuesses(){
        return  numGuesses;
    }
}
