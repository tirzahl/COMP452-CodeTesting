public class Bins {
    private static final int [] BIN_EDGES = {1, 2, 4, 6, 8, 10, 12, 14};

    public int getBinsLength(){
        return BIN_EDGES.length;
    }

    public String setUpBin(int binIndex) {
        String binName;
        if(binIndex == BIN_EDGES.length-1){
            // last bin
            binName = BIN_EDGES[binIndex] + " or more";
        }
        else{
            int upperBound = BIN_EDGES[binIndex+1] - 1;
            if(upperBound > BIN_EDGES[binIndex]){
                binName = BIN_EDGES[binIndex] + "-" + upperBound;
            }
            else{
                binName = Integer.toString(BIN_EDGES[binIndex]);
            }
        }
        return binName;
    }


    public int getGamesInBin(GameStats stats, int binIndex) {
        final int lowerBound = BIN_EDGES[binIndex];
        int numGames = 0;

        if(binIndex == BIN_EDGES.length-1){
            // last bin
            // Sum all the results from lowerBound on up
            for(int numGuesses = lowerBound; numGuesses< stats.maxNumGuesses(); numGuesses++){
                numGames += stats.numGames(numGuesses);
            }
        }
        else{
            int upperBound = BIN_EDGES[binIndex +1];
            for(int numGuesses=lowerBound; numGuesses <= upperBound; numGuesses++) {
                numGames += stats.numGames(numGuesses);
            }
        }
        return numGames;
    }
}
