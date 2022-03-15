public class ComputerGuesses {
    private int numGuesses;
    private int lowerBound;
    private int upperBound;
    private int lastGuess;

    public ComputerGuesses(int numGuesses, int lowerBound, int upperBound){
        this.numGuesses = numGuesses;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }
    public int calculateGuess(boolean higher, int increment){

        if(higher){
            lowerBound = Math.max(lowerBound, lastGuess + 1);
        }
        else{
            upperBound = Math.min(upperBound, lastGuess);
        }
        lastGuess = (lowerBound + upperBound + 1) / 2;
        numGuesses += increment;

        return lastGuess;
    }
    public int calculateGuess(int increment){
        lastGuess = (lowerBound + upperBound + 1) / 2;
        numGuesses += increment;

        return lastGuess;
    }

    public int getLastGuess(){
        return  lastGuess;
    }

    public int getUpperBound(){
        return  upperBound;
    }

    public int getLowerBound(){
        return lowerBound;
    }

    public int getNumGuesses(){
        return numGuesses;
    }

}
