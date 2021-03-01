package com.tictactoe;

public class WinChecker {

    int[][] tttboard;
    public WinChecker(int[][] tttboard) {
        this.tttboard = tttboard;
    }

    public int checkWinner() {

        //***
        //ooo
        //ooo
        if(tttboard[0][0] == tttboard[0][1] && tttboard[0][1] == tttboard[0][2]) {
            return tttboard[0][0];
        }

        //ooo
        //***
        //ooo
        if(tttboard[1][0] == tttboard[1][1] && tttboard[1][1] == tttboard[1][2]) {
            return tttboard[1][0];
        }

        //ooo
        //ooo
        //***
        if(tttboard[2][0] == tttboard[2][1] && tttboard[2][1] == tttboard[2][2]) {
            return tttboard[2][0];
        }

        //*oo
        //*oo
        //*oo
        if(tttboard[0][0] == tttboard[1][0] && tttboard[1][0] == tttboard[2][0]) {
            return tttboard[0][0];
        }

        //o*o
        //o*o
        //o*o
        if(tttboard[0][1] == tttboard[1][1] && tttboard[1][1] == tttboard[2][1]) {
            return tttboard[1][1];
        }

        //oo*
        //oo*
        //oo*
        if(tttboard[0][2] == tttboard[1][2] && tttboard[1][2] == tttboard[2][2]) {
            return tttboard[0][2];
        }

        //*oo
        //o*o
        //oo*
        if(tttboard[0][0] == tttboard[1][1] && tttboard[1][1] == tttboard[2][2]) {
            return tttboard[1][1];
        }

        //oo*
        //o*o
        //*oo
        if(tttboard[0][2] == tttboard[1][1] && tttboard[1][1] == tttboard[2][0]) {
            return tttboard[1][1];
        }

        return -1;
    }
}
