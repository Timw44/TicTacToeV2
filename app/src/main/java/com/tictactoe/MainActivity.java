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
    public ImageView[][] gameButtons = new ImageView[3][3];
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
        clearBoard();
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

        setContentView(R.layout.gamegrid);

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                int id = getResources().getIdentifier("row"+(i+1)+"col"+(j+1),"id",getPackageName());
                Log.println(Log.WARN,"BUTTON:", "row"+(i+1)+"col"+(j+1));
                gameButtons[i][j] = (ImageView) findViewById(id);//id);
                Log.println(Log.WARN,"BUTTON:",  gameButtons[i][j].toString());
                final int finalRowPos = i;
                final int finalColPos = j;
                gameButtons[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        spotsAvailable += -1;
                        if (tttboard[finalRowPos][finalColPos] == -1)
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
    }//end playButtonPressed()

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
    }//end switchPlayer()
}//end MainActivity