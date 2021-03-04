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
//Variable initialization
    public int[][] tttboard = new int[3][3];
    public boolean firstPlayersTurn = true;
    public ImageView[] ivs = new ImageView[9];
    public TextView turnText;
    public boolean backBtnAdded=false;
    public int spotsAvailable=9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }//end onCreate()

    //If the play btn is pressed, then a new game is started
    // resets values in case a player has already played and went back to menu

    public void playButtonPressed(View view) {
        setContentView(R.layout.gamegrid);
        backBtnAdded=false;
        spotsAvailable=9;
        // clear tttboard
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                tttboard[i][j] = -1;//clears board
            }//end for loop col
        }//end for loop row

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
        updateTurnText();
    }//end playButtonPressed()

// Checks which grid was pressed and changes the image according to which player's turn it is
    // Decreases the spots available so that if spotsAvailable==0 and no one won, a tie is determined
    public void grid1Pressed(View view) {
        spotsAvailable += -1;
        //sets view based on bool
        ImageView iv = findViewById(R.id.row1col1);
        whichImage(iv, 0, 0);
    }//end grid1Pressed()

    public void grid2Pressed(View view) {
        spotsAvailable += -1;
        //sets view based on bool
        ImageView iv = findViewById(R.id.row1col2);
        whichImage(iv, 0, 1);
    }//end grid2Pressed()

    public void grid3Pressed(View view) {
        spotsAvailable += -1;
        //sets view based on bool
        ImageView iv = findViewById(R.id.row1col3);
        whichImage(iv, 0, 2);
    }//end grid3Pressed()

    public void grid4Pressed(View view)
    {
        spotsAvailable += -1;
        //sets view based on bool
        ImageView iv = findViewById(R.id.row2col1);
        whichImage(iv, 1, 0);
    }//end grid4Pressed()

    public void grid5Pressed(View view) {
        spotsAvailable += -1;
        //sets view based on bool
        ImageView iv = findViewById(R.id.row2col2);
        whichImage(iv, 1, 1);
    }//end grid5pressed
    public void grid6Pressed(View view) {
        spotsAvailable += -1;
        //sets view based on bool
        ImageView iv = findViewById(R.id.row2col3);
        whichImage(iv, 1, 2);
    }//end grid6Pressed()

    public void grid7Pressed(View view) {
        spotsAvailable += -1;
        //sets view based on bool
        ImageView iv = findViewById(R.id.row3col1);
        whichImage(iv, 2, 0);
    }//end grid7Pressed()

    public void grid8Pressed(View view) {
        spotsAvailable += -1;
        //sets view based on bool
        ImageView iv = findViewById(R.id.row3col2);
        whichImage(iv, 2, 1);
    }//end grid8Pressed()

    public void grid9Pressed(View view) {
        spotsAvailable += -1;
        //sets view based on bool
        ImageView iv = findViewById(R.id.row3col3);
        whichImage(iv, 2, 2);
    }//end grid9Pressed()


// Determine's whose turn it is and sets the value to 1 or 0
    public void whichImage(ImageView iv, int row, int col) {
        //tttboard[row][col] = firstPlayersTurn;
        if (tttboard[row][col] == -1)//spot not taken
        {
            if (firstPlayersTurn)
            {
                //iv.setBackgroundResource(R.drawable.eagle);
                tttboard[row][col] = 1;
            } //if first player's turn
            else
            {
                //iv.setBackgroundResource(R.drawable.wing);
                tttboard[row][col] = 0;
            }//else second player's turn
            switchPlayer();
            updatetttboard();
            checkIfWon();
        }//if value =-1
        else
         {
            Toast.makeText(MainActivity.this, "Spot already taken", Toast.LENGTH_LONG).show();
        }// else value !=-1

    }//end whichImage()

    //Changes the text to reflect who's turn it is
    private void updateTurnText()
    {
        if (firstPlayersTurn)
        {
            turnText.setText("Current player turn is: Eagle");
        } //end if firstPlayersTurn
        else
        {
            turnText.setText("Current player turn is: Wing");
        }//end else notFirstPlayersTurn
    }//end updateTurnText


    //Changes the btns from blank to either an eagle or wings depending on the value in the board
    public void updatetttboard()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(tttboard[i][j] == 1)
                {
                    ivs[i*3 + j].setBackgroundResource(R.drawable.eagle);//Sets spot's image to an image of an eagle
                }// end if spot=1
                else if(tttboard[i][j] == 0)
                {
                    ivs[i*3 + j].setBackgroundResource(R.drawable.wing); //Sets spot's image to an image of wings
                }//end else if spot=0
            }//end for loop for col
        }//endfor loop for row
    }//end updatetttboard()

//Calls WinChecker class which returns a value of -1,0, or 1
// if the value equals -1 then no one has one
// if the value equals 0 then wings have won
//  if the value equals 1 then wings have won
    // also checks if the spots available =0, if true and no one won, then it is a tie
    public void checkIfWon()
    {
        WinChecker wc = new WinChecker(tttboard);
        int wcout = wc.checkWinner(); // Checks to see if anyone won, returns a int
        if(wcout == 1)
        {
            Log.d("DBG", "Eagles have won");
            Toast.makeText(MainActivity.this, "Eagles won", Toast.LENGTH_LONG).show();
            turnText.setText("EAGLES HAVE WON");
            makeBackButton();
        } //end if Eagles won
        else if(wcout == 0)
        {
            Log.d("DBG", "Wings have won");
            Toast.makeText(MainActivity.this, "Wings won", Toast.LENGTH_LONG).show();
            turnText.setText("WINGS HAVE WON");
            makeBackButton();
        }//end else if wcout==0 (Wings won)
        else if(spotsAvailable==0)// if there are no spots available and no one won, then it is a tie
        {
            Log.d("DBG", "Tie");
            Toast.makeText(MainActivity.this, "Tie", Toast.LENGTH_LONG).show();
            turnText.setText("TIE");
            makeBackButton();
        }//end else if spotsAvailable==0

    }//end checkIfWon()

//Creates a back btn and returns to Main Menu if back button pressed
    public void makeBackButton()
    {
       if(!backBtnAdded)//Checks to see if a back btn was already added
       {
           Button backbtn = new Button(this);
           backbtn.setText("BACK TO MAIN MENU");
           backbtn.setOnClickListener(view -> {
               setContentView(R.layout.activity_main);
           });

           LinearLayout gl = findViewById(R.id.gamelayout);
           gl.addView(backbtn);
           backBtnAdded=true;
       }//end if
    }//end makeBackButton()

    //Switches the players' turn
    public void switchPlayer()
    {
        if (firstPlayersTurn) //Changes player's turn from 1st player to 2nd player
        {
            firstPlayersTurn = false;
        }//end if
        else //Changes the player's turn from 2nd Player to 1st
         {
            firstPlayersTurn = true;
         }//end else
        updateTurnText();
    }//end switchPlayer()
}//end MainActivity