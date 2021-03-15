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
    public int[][] tttboard = new int[3][3]; //board data values; used to check for wins and status
    public ImageView[][] gameButtons = new ImageView[3][3];//view buttons for clicks
    public boolean firstPlayersTurn = true;//determines player's turn
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
        clearBoard();

        // register turn text var
        turnText = findViewById(R.id.turnText);

        setContentView(R.layout.gamegrid);

        setup();
    }//end playButtonPressed()

    private void setup() {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++) //populate gameButtons 3x3 array
            {
                int id = getResources().getIdentifier("row"+(i+1)+"col"+(j+1),"id",getPackageName());
                gameButtons[i][j] = (ImageView) findViewById(id); //gets the id of buttons
                Log.println(Log.WARN,"BUTTON:",  gameButtons[i][j].toString());
                final int finalRowPos = i;
                final int finalColPos = j;
                gameButtons[i][j].setOnClickListener(new View.OnClickListener() { //create onclick listener per button
                    @Override
                    public void onClick(View view) {
                        spotsAvailable += -1;
                        if (tttboard[finalRowPos][finalColPos] == -1) //if space is empty then change status/background img
                        {
                            if (firstPlayersTurn)
                            {
                                tttboard[finalRowPos][finalColPos] = 1;
                                view.setBackgroundResource(R.drawable.eagle);
                                turnText.setText("Current player turn is: Wings");
                            } else {
                                tttboard[finalRowPos][finalColPos] = 0;
                                view.setBackgroundResource(R.drawable.wing);
                                turnText.setText("Current player turn is: Eagle");
                            }
                            switchPlayer();
                            checkIfWon();
                        }
                    }
                });
            }
        }
    }

    // clears tic tac toe board
    private void clearBoard()
    {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                tttboard[i][j] = -1;//clears board
            }//end for loop col
        }//end for loop row
    }

//Calls WinChecker class which returns a value of -1,0, or 1
// if the value equals -1 then no one has one
// if the value equals 0 then wings have won
//  if the value equals 1 then wings have won
    // also checks if the spots available =0, if true and no one won, then it is a tie
    public void checkIfWon()
    {
        WinChecker wc = new WinChecker(tttboard);
        int wcout = wc.checkWinner(); // Checks to see if anyone won, returns a int; 0 = win, 1 = tie
        if(wcout == 0)
        {
            if(firstPlayersTurn)
            {
                Log.d("DBG", "Wings have won");
                Toast.makeText(MainActivity.this, "Wings won", Toast.LENGTH_LONG).show();
                turnText.setText("WINGS HAVE WON");
                makeBackButton();
            }
            else
            {
                Log.d("DBG", "Eagles have won");
                Toast.makeText(MainActivity.this, "Eagles won", Toast.LENGTH_LONG).show();
                turnText.setText("EAGLES HAVE WON");
                makeBackButton();
            }
        }
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
    }//end switchPlayer()
}//end MainActivity