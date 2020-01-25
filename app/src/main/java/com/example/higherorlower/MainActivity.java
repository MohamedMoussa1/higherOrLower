package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNum;

    public void generateRandomNum() {
        Random rand = new Random();
        randomNum = rand.nextInt(20)+1;
    }
    public boolean checkIfEmpty(EditText input) {

        if (TextUtils.isEmpty(input.getText().toString())) {
            return true;
        }
        return false;
    }
    public void checkGuess(View view) {

        EditText editText = (EditText) findViewById(R.id.editText);

        String message;
        if (checkIfEmpty(editText)) {
            message = "Please enter a valid number between 1 and 20";
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            return;
        }

        Log.i("Current Random Num", Integer.toString(randomNum));

        int guessedNum = Integer.parseInt(editText.getText().toString());

        if (guessedNum < randomNum) {
            message = "Higher!";
        } else if (guessedNum > randomNum) {
            message = "Lower!";
        } else {
            message = "You got it!! Try again ;D";
            generateRandomNum();
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        Log.i("Input", Integer.toString(guessedNum));
        Log.i("New Random Num", Integer.toString(randomNum));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateRandomNum();
    }
}
