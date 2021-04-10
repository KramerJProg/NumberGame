package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    private Button left;
    private Button right;
    private int numLeft; // numbers on the buttons
    private int numRight;
    private int points; // player's total score, starts at 0

    Random rand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        left = (Button) findViewById(R.id.buttonLeft);
        right = (Button) findViewById(R.id.buttonRight);

        points = 0;
        rand = new Random();
        roll();
    }

    private void roll() {
        numLeft = rand.nextInt(9) + 1;
        numRight = rand.nextInt(9) + 1;
        while (numLeft == numRight) {
            numRight = rand.nextInt(9) + 1;
        }
        left.setText("" + numLeft);
        right.setText("" + numRight);
    }

    public void onClick(View v) {
        if (v == left) {
            check(numLeft, numRight);
        }
        else {
            check(numRight, numLeft);
        }
    }

    private void check(int a, int b) {
        if (a > b) {
            points++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        }
        else {
            points--;
            Toast.makeText(this, "Nope! Try again.", Toast.LENGTH_SHORT).show();
        }
        TextView pointsView = (TextView) findViewById(R.id.scoreText);
        pointsView.setText("Points: " + points);
        roll(); // Puts new set of numbers on screen
    }
}