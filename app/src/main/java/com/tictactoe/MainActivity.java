package com.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int[][] tttboard = new int[3][3];
    public boolean firstPlayersTurn = true;
    public Button[] ivs = new Button[9];
    public TextView turnText;
    public boolean backBtnAdded=false;
    public int spotsAvailable=9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playButtonPressed(View view) {
        setContentView(R.layout.gamegrid);
        backBtnAdded=false;
        spotsAvailable=9;
        // clear tttboard
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                tttboard[i][j] = -1;
            }
        }

        // populate ivs list
        ivs[0] = findViewById(R.id.row1col1);
        ivs[1] = findViewById(R.id.row1col2);
        ivs[2] = findViewById(R.id.row1col3);
        ivs[3] = findViewById(R.id.row2col1);
        ivs[4] = findViewById(R.id.row2col2);
        ivs[5] = findViewById(R.id.row2col3);
        ivs[6] = findViewById(R.id.row3col1);
        ivs[7] = findViewById(R.id.row3col2);
        ivs[8] = findViewById(R.id.row3col3);

        // register turn text var
        turnText = findViewById(R.id.turnText);
        if (firstPlayersTurn) {
            turnText.setText("current player turn is: Eagle");
        } else {
            turnText.setText("current player turn is: Wing");
        }
    }

    public void grid1Pressed(View view) {
        spotsAvailable += -1;
        //sets view based on bool
        Button btn = findViewById(R.id.row1col1);
        whichImage(btn, 0, 0);
    }
    public void grid2Pressed(View view) {
        spotsAvailable += -1;
        //sets view based on bool
        Button btn = findViewById(R.id.row1col2);
        whichImage(btn, 0, 1);
    }
    public void grid3Pressed(View view) {
        spotsAvailable += -1;
        //sets view based on bool
        Button btn = findViewById(R.id.row1col3);
        whichImage(btn, 0, 2);
    }
    public void grid4Pressed(View view) {
        spotsAvailable += -1;
        //sets view based on bool
        Button btn = findViewById(R.id.row2col1);
        whichImage(btn, 1, 0);
    }
    public void grid5Pressed(View view) {
        spotsAvailable += -1;
        //sets view based on bool
        Button btn = findViewById(R.id.row2col2);
        whichImage(btn, 1, 1);
    }
    public void grid6Pressed(View view) {
        spotsAvailable += -1;
        //sets view based on bool
        Button btn = findViewById(R.id.row2col3);
        whichImage(btn, 1, 2);
    }
    public void grid7Pressed(View view) {
        spotsAvailable += -1;
        //sets view based on bool
        Button btn = findViewById(R.id.row3col1);
        whichImage(btn, 2, 0);
    }
    public void grid8Pressed(View view) {
        spotsAvailable += -1;
        //sets view based on bool
        Button btn = findViewById(R.id.row3col2);
        whichImage(btn, 2, 1);
    }
    public void grid9Pressed(View view) {
        spotsAvailable += -1;
        //sets view based on bool
        Button btn = findViewById(R.id.row3col3);
        whichImage(btn, 2, 2);
    }

    public void whichImage(Button btn, int row, int col) {
        //tttboard[row][col] = firstPlayersTurn;
        if (tttboard[row][col] == -1) {
            if (firstPlayersTurn) {
                //iv.setBackgroundResource(R.drawable.eagle);
                tttboard[row][col] = 1;
            } else {
                //iv.setBackgroundResource(R.drawable.wing);
                tttboard[row][col] = 0;
            }

            switchPlayer();
            updatetttboard();
            checkIfWon();
        } else {
            Toast.makeText(MainActivity.this, "Spot already taken", Toast.LENGTH_LONG).show();
        }

    }

    private void updateTurnText()
    {
        if (firstPlayersTurn) {
            turnText.setText("Current player turn is: Eagle");
        } else {
            turnText.setText("Current player turn is: Wing");
        }
    }

    public void updatetttboard() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                //Log.d("DBG", "checking " + (i*3 + j));
                if(tttboard[i][j] == 1) {
                    ivs[i*3 + j].setBackgroundResource(R.drawable.eagle);
                } else if(tttboard[i][j] == 0) {
                    ivs[i*3 + j].setBackgroundResource(R.drawable.wing);
                } else {
                    //Log.d("DBG", "nothing set");
                }
            }
        }
    }

    public void checkIfWon()
    {
        WinChecker wc = new WinChecker(tttboard);
        int wcout = wc.checkWinner();
        if(wcout == 1) {
            Log.d("DBG", "Eagles have won");
            Toast.makeText(MainActivity.this, "Eagles won", Toast.LENGTH_LONG).show();
            turnText.setText("EAGLES HAVE WON");
            makeBackButton();
        } else if(wcout == 0) {
            Log.d("DBG", "Wings have won");
            Toast.makeText(MainActivity.this, "Wings won", Toast.LENGTH_LONG).show();
            turnText.setText("WINGS HAVE WON");
            makeBackButton();
        }
        else if(spotsAvailable==0)
        {
            Log.d("DBG", "Tie");
            Toast.makeText(MainActivity.this, "Tie", Toast.LENGTH_LONG).show();
            turnText.setText("TIE");
            makeBackButton();
        }

    }

    public void makeBackButton() {
       if(!backBtnAdded)
       {
           Button backbtn = new Button(this);
           backbtn.setText("BACK TO MAIN MENU");
           backbtn.setOnClickListener(view -> {
               setContentView(R.layout.activity_main);
           });

           LinearLayout gl = findViewById(R.id.gamelayout);
           gl.addView(backbtn);
           backBtnAdded=true;
       }
    }

    public void switchPlayer()
    {
        if (firstPlayersTurn) {
            firstPlayersTurn = false;
        } else {
            firstPlayersTurn = true;
        }
        updateTurnText();
    }
}