package com.example.makharij_al_huruf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button practiceBtn;
    Button examBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        practiceBtn = findViewById(R.id.practiceBtn);
        examBtn = findViewById(R.id.examBtn);

        practiceBtn.setBackgroundColor(getResources().getColor(R.color.green));
        examBtn.setBackgroundColor(getResources().getColor(R.color.green));

        practiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PracticeActivity.class );
                startActivity(intent);
            }
        });

        examBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ExamActivity.class );
                startActivity(intent);
            }
        });

    }
}