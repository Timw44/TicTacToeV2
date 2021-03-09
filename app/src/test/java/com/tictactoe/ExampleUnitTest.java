package com.tictactoe;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void noWinner()
    {
        int[][] tttboard = {{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
        WinChecker noWinner=new WinChecker(tttboard);
        int expected = -1;
       assertEquals(expected,noWinner.checkWinner());
    }

    @Test
    public void noWinner2()
    {
        int[][] tttboard = {{0,-1,-1},{-1,-1,-1},{-1,-1,-1}};
        WinChecker noWinner=new WinChecker(tttboard);
        int expected = -1;
        assertEquals(expected,noWinner.checkWinner());
    }

    @Test
    public void noWinner3()
    {
        int[][] tttboard = {{0,0,-1},{-1,-1,-1},{-1,-1,-1}};
        WinChecker noWinner=new WinChecker(tttboard);
        int expected = -1;
        assertEquals(expected,noWinner.checkWinner());
    }

    @Test
    public void noWinner4()
    {
        int[][] tttboard = {{-1,-1,0},{-1,-1,-1},{-1,-1,-1}};
        WinChecker noWinner=new WinChecker(tttboard);
        int expected = -1;
        assertEquals(expected,noWinner.checkWinner());
    }

    @Test
    public void noWinner5()
    {
        int[][] tttboard = {{-1,-1,-1},{0,-1,-1},{-1,-1,-1}};
        WinChecker noWinner=new WinChecker(tttboard);
        int expected = -1;
        assertEquals(expected,noWinner.checkWinner());
    }

    @Test
    public void noWinner6()
    {
        int[][] tttboard = {{-1,-1,-1},{-1,0,-1},{-1,-1,-1}};
        WinChecker noWinner=new WinChecker(tttboard);
        int expected = -1;
        assertEquals(expected,noWinner.checkWinner());
    }

    @Test
    public void noWinner7()
    {
        int[][] tttboard = {{-1,-1,-1},{-1,-1,0},{-1,-1,-1}};
        WinChecker noWinner=new WinChecker(tttboard);
        int expected = -1;
        assertEquals(expected,noWinner.checkWinner());
    }

    @Test
    public void Winner()
    {
        int[][] tttboard = {{1,1,1},{-1,-1,-1},{-1,-1,-1}};
        WinChecker noWinner=new WinChecker(tttboard);
        int expected = 1;
        assertEquals(expected,noWinner.checkWinner());
    }

    @Test
    public void winner2()
    {
        int[][] tttboard = {{1,1,1},{-1,-1,-1},{-1,-1,-1}};
        WinChecker noWinner=new WinChecker(tttboard);
        int expected = 1;
        assertEquals(expected,noWinner.checkWinner());
    }
}