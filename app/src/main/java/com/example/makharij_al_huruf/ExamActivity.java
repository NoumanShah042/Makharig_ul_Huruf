package com.example.makharij_al_huruf;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class ExamActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    Button buttonA, buttonB, buttonC, buttonD;
    Handler handler;
    int totalQuestions = 7;
    int questionIndex = 0;
    char answer;
    int score = 0;


    String[] questions = {
            "How many makharij are there for the letters of arabic alphabets",
            "Sound of ہ أ  Produced from ",
            "Category of  ح ع",
            "Word produced from Outer part of both lips touch each other",
            "Word produced from Tip of the tongue comes between the front top and bottom teeth ",
            "Category of  ل / ن / ر",
            "Category of  ی ش ج"


    };
    String[][] options = {
            {"17", "18", "16", "21"},
            {"Start of Throat", "End of Throat ", "Middle of Throat ", "None"},
            {"Lahatiyah", "Shajariyah", "Tarfiyah", "Halqiyah"},
            {"ف", "ب", "م", "و"},
            {"ص / ز / س", "ل / ن / ر", "ج / ش / ی ", "و"},
            {"Lahatiyah", "Shajariyah", "Tarfiyah", "Halqiyah"},
            {"Lahatiyah", "Shajariyah", "Tarfiyah", "Halqiyah"}

    };
    char[] answers = {
            'A',
            'B',
            'D',
            'C',
            'A',
            'C',
            'B'

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        // handler = new Handler(getApplicationContext().getMainLooper());
        handler = new Handler();  //  // Default constructor associates this handler with the Looper for the current thread.

        textView = findViewById(R.id.textView);
        buttonA = findViewById(R.id.buttonA);
        buttonB = findViewById(R.id.buttonB);
        buttonC = findViewById(R.id.buttonC);
        buttonD = findViewById(R.id.buttonD);

        buttonA.setOnClickListener(this);
        buttonB.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonD.setOnClickListener(this);


        nextQuestion();
    }

    public void nextQuestion() {
        if (questionIndex < totalQuestions) {

            buttonA.setEnabled(true);
            buttonB.setEnabled(true);
            buttonC.setEnabled(true);
            buttonD.setEnabled(true);
            buttonA.setBackgroundColor(getResources().getColor(R.color.purple_500));
            buttonB.setBackgroundColor(getResources().getColor(R.color.purple_500));
            buttonC.setBackgroundColor(getResources().getColor(R.color.purple_500));
            buttonD.setBackgroundColor(getResources().getColor(R.color.purple_500));

            textView.setText(questions[questionIndex]);
            buttonA.setText(options[questionIndex][0]);
            buttonB.setText(options[questionIndex][1]);
            buttonC.setText(options[questionIndex][2]);
            buttonD.setText(options[questionIndex][3]);

        } else {
            Intent myIntent = new Intent(ExamActivity.this, ScoreActivity.class);
            myIntent.putExtra("score", score);
            startActivity(myIntent);
            this.finish();
        }
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        //Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
        switch (v.getId()) {
            case R.id.buttonA:
                answer = 'A';
                if (answers[questionIndex] == answer) {
                    buttonA.setBackgroundColor(Color.GREEN);
                    score += 1;
                } else {
                    buttonA.setBackgroundColor(Color.RED);
                }
                break;
            case R.id.buttonB:
                answer = 'B';
                if (answers[questionIndex] == answer) {
                    buttonB.setBackgroundColor(Color.GREEN);
                    score += 1;
                } else {
                    buttonB.setBackgroundColor(Color.RED);
                }
                break;
            case R.id.buttonC:
                answer = 'C';
                if (answers[questionIndex] == answer) {
                    buttonC.setBackgroundColor(Color.GREEN);
                    score += 1;
                } else {
                    buttonC.setBackgroundColor(Color.RED);
                }
                break;
            case R.id.buttonD:
                answer = 'D';
                if (answers[questionIndex] == answer) {
                    buttonD.setBackgroundColor(Color.GREEN);
                    score += 1;
                } else {
                    buttonD.setBackgroundColor(Color.RED);
                }
                break;
        }

        //  if answer is wrong it shows the answer in green color
        displayAnswer();
        questionIndex += 1;

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1000);

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            nextQuestion();
                        }
                    });
                }
            }
        };

        thread.start();


    }


    public void displayAnswer() {
        if ('A' == answers[questionIndex])
            buttonA.setBackgroundColor(Color.GREEN);

        if ('B' == answers[questionIndex])
            buttonB.setBackgroundColor(Color.GREEN);

        if ('C' == answers[questionIndex])
            buttonC.setBackgroundColor(Color.GREEN);

        if ('D' == answers[questionIndex])
            buttonD.setBackgroundColor(Color.GREEN);
    }
}