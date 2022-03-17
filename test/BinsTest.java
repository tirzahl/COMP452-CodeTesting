import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class BinsTest {

    @Test
    void setUpBin(){
        Bins bins = new Bins();
        assertEquals("1",bins.setUpBin(0));
        assertEquals("2-3", bins.setUpBin(1));
        assertEquals("4-5", bins.setUpBin(2));
        assertEquals("6-7", bins.setUpBin(3));
        assertEquals("8-9", bins.setUpBin(4));
        assertEquals("10-11", bins.setUpBin(5));
        assertEquals("12-13", bins.setUpBin(6));
        assertEquals("14 or more", bins.setUpBin(7));
    }

    @Test
    void loadBin0(){
        Bins bins = new Bins();
        GamesStatsStub GSS = new GamesStatsStub(10,1);
        assertEquals(1, bins.getGamesInBin(GSS, 0));
    }

    @Test
    void loadBin1(){
        Bins bins = new Bins();
        GamesStatsStub GSS = new GamesStatsStub(10,1);
        assertEquals(2, bins.getGamesInBin(GSS, 1));
    }

    @Test
    void loadBin4(){
        Bins bins = new Bins();
        GamesStatsStub GSS = new GamesStatsStub(10,1);
        assertEquals(2, bins.getGamesInBin(GSS, 4));
    }

    @Test
    void loadBin6(){
        Bins bins = new Bins();
        GamesStatsStub GSS = new GamesStatsStub(10,1);
        assertEquals(2, bins.getGamesInBin(GSS, 6));
    }

    @Test
    void loadLastBin(){
        Bins bins = new Bins();
        //Guesses from 14 to 15
        GamesStatsStub GSS = new GamesStatsStub(15,1);
        assertEquals(2, bins.getGamesInBin(GSS, 7));
    }

}