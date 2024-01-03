package com.example.guess_the_pic;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;


import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.os.Bundle;

public class ResultActivity extends AppCompatActivity {

    private Button button;

    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        Intent intent = getIntent();
        int correctCount = intent.getIntExtra("correctCount", 0);
        int incorrectCount = intent.getIntExtra("incorrectCount", 0);

        TextView correctTextView = findViewById(R.id.correctTextView);
        TextView incorrectTextView = findViewById(R.id.incorrectTextView);

        correctTextView.setText("Correct: " + correctCount);
        incorrectTextView.setText("Incorrect: " + incorrectCount);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this,MainActivity.class);
                startActivity(intent);
                finish();



            }});
    }
}