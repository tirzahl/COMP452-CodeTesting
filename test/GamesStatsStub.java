public class GamesStatsStub extends GameStats{
    private int maxNumGuesses;
    private int numGuessesForEach;

    public GamesStatsStub(int maxNumGuesses, int numGuessesForEach){
        this.maxNumGuesses = maxNumGuesses;
        this.numGuessesForEach = numGuessesForEach;
    }


    @Override
    public int numGames(int numGuesses) {
        return numGuessesForEach;
    }

    @Override
    public int maxNumGuesses() {
        return maxNumGuesses;
    }
}