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
        int expected = 1;
        assertEquals(expected,noWinner.checkWinner());
    }

    @Test
    public void noWinner2()
    {
        int[][] tttboard = {{0,-1,-1},{-1,-1,-1},{-1,-1,-1}};
        WinChecker noWinner=new WinChecker(tttboard);
        int expected = 1;
        assertEquals(expected,noWinner.checkWinner());
    }

    @Test
    public void noWinner3()
    {
        int[][] tttboard = {{0,0,-1},{-1,-1,-1},{-1,-1,-1}};
        WinChecker noWinner=new WinChecker(tttboard);
        int expected = 1;
        assertEquals(expected,noWinner.checkWinner());
    }

    @Test
    public void noWinner4()
    {
        int[][] tttboard = {{-1,-1,0},{-1,-1,-1},{-1,-1,-1}};
        WinChecker noWinner=new WinChecker(tttboard);
        int expected = 1;
        assertEquals(expected,noWinner.checkWinner());
    }

    @Test
    public void noWinner5()
    {
        int[][] tttboard = {{-1,-1,-1},{0,-1,-1},{-1,-1,-1}};
        WinChecker noWinner=new WinChecker(tttboard);
        int expected = 1;
        assertEquals(expected,noWinner.checkWinner());
    }

    @Test
    public void noWinner6()
    {
        int[][] tttboard = {{-1,-1,-1},{-1,0,-1},{-1,-1,-1}};
        WinChecker noWinner=new WinChecker(tttboard);
        int expected = 1;
        assertEquals(expected,noWinner.checkWinner());
    }

    @Test
    public void noWinner7()
    {
        int[][] tttboard = {{-1,-1,-1},{-1,-1,0},{-1,-1,-1}};
        WinChecker noWinner=new WinChecker(tttboard);
        int expected = 1;
        assertEquals(expected,noWinner.checkWinner());
    }

    @Test
    public void winnerHorizontal()
    {
        int[][] tttboard = {{1,1,1},
                {-1,-1,-1},
                {-1,-1,-1}};
        WinChecker winner=new WinChecker(tttboard);
        int expected = 0;
        assertEquals(expected,winner.checkWinner());
    }

    @Test
    public void winnerHorizontal2()
    {
        int[][] tttboard = {{-1,-1,-1},
                {1,1,1},
                {-1,-1,-1}};
        WinChecker winner=new WinChecker(tttboard);
        int expected = 0;
        assertEquals(expected,winner.checkWinner());
    }

    @Test
    public void winnerHorizontal3()
    {
        int[][] tttboard = {{-1,-1,-1},
                {-1,-1,-1},
                {1,1,1}};
        WinChecker winner=new WinChecker(tttboard);
        int expected = 0;
        assertEquals(expected,winner.checkWinner());
    }

    @Test
    public void winnerVertical()
    {
        int[][] tttboard = {{1,-1,-1},
                {1,-1,-1},
                {1,-1,-1}};
        WinChecker winner=new WinChecker(tttboard);
        int expected = 0;
        assertEquals(expected,winner.checkWinner());
    }

    @Test
    public void winnerVertical2()
    {
        int[][] tttboard = {{-1, 1,-1},
                {-1, 1,-1},
                {-1, 1,-1}};
        WinChecker winner=new WinChecker(tttboard);
        int expected = 0;
        assertEquals(expected,winner.checkWinner());
    }

    @Test
    public void winnerVertical3()
    {
        int[][] tttboard = {{-1, -1,1},
                {-1, -1,1},
                {-1, -1,1}};
        WinChecker winner=new WinChecker(tttboard);
        int expected = 0;
        assertEquals(expected,winner.checkWinner());
    }

    @Test
    public void winnerDiagonal()
    {
        int[][] tttboard = {{-1, -1,1},
                {-1, 1,-1},
                {1, -1,-1}};
        WinChecker winner=new WinChecker(tttboard);
        int expected = 0;
        assertEquals(expected,winner.checkWinner());
    }

    @Test
    public void winnerDiagonal2()
    {
        int[][] tttboard = {{1, -1,-1},
                {-1, 1,-1},
                {-1, -1,1}};
        WinChecker winner=new WinChecker(tttboard);
        int expected = 0;
        assertEquals(expected,winner.checkWinner());
    }

    @Test
    public void noWinner8()
    {
        int[][] tttboard = {{0,-1,-1},
                {-1,-1,1},
                {-1,0,-1}};
        WinChecker noWinner=new WinChecker(tttboard);
        int expected = 1;
        assertEquals(expected,noWinner.checkWinner());
    }

    @Test
    public void noWinner9()
    {
        int[][] tttboard = {{0,0,1},
                {1,1,0},
                {0,1,0}};
        WinChecker noWinner=new WinChecker(tttboard);
        int expected = 1;
        assertEquals(expected,noWinner.checkWinner());
    }

    @Test
    public void noWinner10()
    {
        int[][] tttboard = {{0,1,0},
                {0,1,1},
                {1,0,0}};
        WinChecker noWinner=new WinChecker(tttboard);
        int expected = 1;
        assertEquals(expected,noWinner.checkWinner());
    }

    @Test
    public void winnerHorizontal_wing()
    {
        int[][] tttboard = {{0,0,0},
                {-1,-1,-1},
                {-1,-1,-1}};
        WinChecker winner=new WinChecker(tttboard);
        int expected = 0;
        assertEquals(expected,winner.checkWinner());
    }

    @Test
    public void winnerHorizontal2_wing()
    {
        int[][] tttboard = {{-1,-1,-1},
                {0,0,0},
                {-1,-1,-1}};
        WinChecker winner=new WinChecker(tttboard);
        int expected = 0;
        assertEquals(expected,winner.checkWinner());
    }

    @Test
    public void winnerHorizontal3_wing()
    {
        int[][] tttboard = {{-1,-1,-1},
                {-1,-1,-1},
                {0,0,0}};
        WinChecker winner=new WinChecker(tttboard);
        int expected = 0;
        assertEquals(expected,winner.checkWinner());
    }

    @Test
    public void winnerVertical_wing()
    {
        int[][] tttboard = {{0,-1,-1},
                {0,-1,-1},
                {0,-1,-1}};
        WinChecker winner=new WinChecker(tttboard);
        int expected = 0;
        assertEquals(expected,winner.checkWinner());
    }

    @Test
    public void winnerVertical2_wing()
    {
        int[][] tttboard = {{-1, 0,-1},
                {-1, 0,-1},
                {-1, 0,-1}};
        WinChecker winner=new WinChecker(tttboard);
        int expected = 0;
        assertEquals(expected,winner.checkWinner());
    }

    @Test
    public void winnerVertical3_wing()
    {
        int[][] tttboard = {{-1, -1,0},
                {-1, -1,0},
                {-1, -1,0}};
        WinChecker winner=new WinChecker(tttboard);
        int expected = 0;
        assertEquals(expected,winner.checkWinner());
    }

    @Test
    public void winnerDiagonal_wing()
    {
        int[][] tttboard = {{-1, -1,0},
                {-1, 0,-1},
                {0, -1,-1}};
        WinChecker winner=new WinChecker(tttboard);
        int expected = 0;
        assertEquals(expected,winner.checkWinner());
    }

    @Test
    public void winnerDiagonal2_wing()
    {
        int[][] tttboard = {{0, -1,-1},
                {-1, 0,-1},
                {-1, -1,0}};
        WinChecker winner=new WinChecker(tttboard);
        int expected = 0;
        assertEquals(expected,winner.checkWinner());
    }
}