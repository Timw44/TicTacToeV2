package com.tictactoe;

public class WinChecker {

    int[][] tttboard;
    public WinChecker(int[][] tttboard) {
        this.tttboard = tttboard;
    }

    public int checkWinner(){
        for(int x = 0; x < 3; x++)//check for vertical wins
        {
            if (tttboard[x][0] == tttboard[x][1] && tttboard[x][1] == tttboard[x][2] && tttboard[x][0] != -1) {
                return 0;
            }
        }
        for(int y = 0; y < 3; y++)//check for horizontal wins
        {
            if (tttboard[0][y] == tttboard[1][y] && tttboard[1][y] == tttboard[2][y] && tttboard[0][y] != -1) {
                return 0;
            }
        }
        //check for diagonal wins
        if(tttboard[0][0] == tttboard[1][1] && tttboard[1][1] == tttboard[2][2] && tttboard[0][0] != -1)
        {
            return 0;
        }
        else if(tttboard[0][2] == tttboard[1][1] && tttboard[1][1] == tttboard[2][0] && tttboard[0][2] != -1)
        {
            return 0;
        }
        return 1;
    }
}
