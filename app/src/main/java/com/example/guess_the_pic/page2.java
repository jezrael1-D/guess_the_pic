package com.example.guess_the_pic;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.os.Bundle;

public class page2 extends AppCompatActivity {

    private ImageView imageView;
    private EditText guessEditText;
    private Button guessButton;
    private int correctCount = 0;
    private int incorrectCount = 0;


    private int currentImageIndex = 0;
    private int[] images = {R.drawable.apple, R.drawable.grape, R.drawable.orange,R.drawable.coco,R.drawable.avocado,R.drawable.mango,R.drawable.bg};
    private String[] answers = {"apple", "grapes", "orange","coconut","avocado","mango"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

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
            Intent intent = new Intent(page2.this, ResultActivity.class);
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
                    Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
                    incorrectCount++;
                }
            } else {
                Toast.makeText(this, "Please enter a guess.", Toast.LENGTH_SHORT).show();
            }
        }

        loadNextImage();
    }


}