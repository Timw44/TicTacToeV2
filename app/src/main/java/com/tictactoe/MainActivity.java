package com.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean firstPlayersTurn = true;

    public void playButtonPressed(View view) {
        setContentView(R.layout.gamegrid);
    }

    public void grid1Pressed(View view) {
        //sets view based on bool
        ImageView iv = findViewById(R.id.imageView2);
        whichImage(iv);
        switchPlayer();
    }
    public void grid2Pressed(View view) {
        //sets view based on bool
        ImageView iv = findViewById(R.id.imageView3);
        whichImage(iv);
        switchPlayer();
    }
    public void grid3Pressed(View view) {
        //sets view based on bool
        ImageView iv = findViewById(R.id.imageView4);
        whichImage(iv);
        switchPlayer();
    }
    public void grid4Pressed(View view) {
        //sets view based on bool
        ImageView iv = findViewById(R.id.imageView5);
        whichImage(iv);
        switchPlayer();
    }
    public void grid5Pressed(View view) {
        //sets view based on bool
        ImageView iv = findViewById(R.id.imageView6);
        whichImage(iv);
        switchPlayer();
    }
    public void grid6Pressed(View view) {
        //sets view based on bool
        ImageView iv = findViewById(R.id.imageView7);
        whichImage(iv);
        switchPlayer();
    }
    public void grid7Pressed(View view) {
        //sets view based on bool
        ImageView iv = findViewById(R.id.imageView8);
        whichImage(iv);
        switchPlayer();
    }
    public void grid8Pressed(View view) {
        //sets view based on bool
        ImageView iv = findViewById(R.id.imageView9);
        whichImage(iv);
        switchPlayer();
    }
    public void grid9Pressed(View view) {
        //sets view based on bool
        ImageView iv = findViewById(R.id.imageView10);
        whichImage(iv);
        switchPlayer();
    }

    public void whichImage(ImageView iv)
    {
        if (firstPlayersTurn)
        {
            iv.setBackgroundResource(R.drawable.eagle);
        }
        else{
            iv.setBackgroundResource(R.drawable.wing);
        }
    }

    public void switchPlayer()
    {
        if (firstPlayersTurn)
        {
            firstPlayersTurn = false;
        }
        else{
            firstPlayersTurn = true;
        }

    }
}