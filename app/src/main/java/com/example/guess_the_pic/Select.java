package com.example.guess_the_pic;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class Select extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        button = findViewById(R.id.fruitbutton);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Select.this,page2.class);
                startActivity(intent);
                finish();



            }});

        button = findViewById(R.id.animalsbutton);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Select.this,Animals.class);
                startActivity(intent);
                finish();



            }});

    }
}