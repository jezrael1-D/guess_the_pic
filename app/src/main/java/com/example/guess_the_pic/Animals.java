package com.example.guess_the_pic;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import android.os.Bundle;

public class Animals extends AppCompatActivity {

    private ImageView imageView;
    private EditText guessEditText;
    private Button guessButton;
    private int correctCount = 0;
    private int incorrectCount = 0;


    private int currentImageIndex = 0;
    private int[] images = {R.drawable.dog, R.drawable.cat, R.drawable.lion,R.drawable.panda,R.drawable.shark,R.drawable.tiger,R.drawable.bg};
    private String[] answers = {"dog", "cat", "lion","panda","shark","tiger"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);

        imageView = findViewById(R.id.myimage);
        guessEditText = findViewById(R.id.guessEditText);
        guessButton = findViewById(R.id.guessButton);

        loadNextImage();

        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkGuess();
            }
        });
    }

    private void loadNextImage() {
        if (currentImageIndex <= images.length) {
            imageView.setImageResource(images[currentImageIndex]);
            guessEditText.setText(""); // Clear the previous guess
            currentImageIndex++;
        }
        if (currentImageIndex == images.length) {
            // Game Over. Start ResultActivity and pass counts
            Intent intent = new Intent(Animals.this, ResultActivity.class);
            intent.putExtra("correctCount", correctCount);
            intent.putExtra("incorrectCount", incorrectCount);
            startActivity(intent);
            finish(); // Optional: Close the page2
        }

    }

    private void checkGuess() {
        if (currentImageIndex <= answers.length) {
            String correctAnswer = answers[currentImageIndex - 1];
            String userGuess = guessEditText.getText().toString().trim();

            if (!userGuess.isEmpty()) {
                if (userGuess.equalsIgnoreCase(correctAnswer)) {
                    Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
                    correctCount++;
                } else {
                    Toast.makeText(this, "Incorrect. Try again!", Toast.LENGTH_SHORT).show();
                    incorrectCount++;
                }
            } else {
                Toast.makeText(this, "Please enter a guess.", Toast.LENGTH_SHORT).show();
            }
        }

        loadNextImage();
    }
}