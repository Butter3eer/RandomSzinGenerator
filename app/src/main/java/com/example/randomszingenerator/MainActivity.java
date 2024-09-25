package com.example.randomszingenerator;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout main;
    private TextView rgb_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        Random random = new Random();

        main.setOnClickListener(view -> {
            int green = random.nextInt(255);
            int red = random.nextInt(255);
            int blue = random.nextInt(255);

            main.setBackgroundColor(Color.rgb(red, green, blue));

            double luminance = (0.299 * red + 0.587 * green + 0.114 * blue);
            // rgb_text.setTextColor(luminance > 186 ? Color.BLACK : Color.WHITE);

            if (luminance < 186) {
                // rgb_text.setTextColor(getColor(R.color.Narancs));   // érdekességnek
                rgb_text.setTextColor(Color.WHITE);
            } else {
                rgb_text.setTextColor(Color.BLACK);
            }

            // rgb_text.setText("(" + red + ", " + green + ", " + blue + ")");
            rgb_text.setText(String.format("( %d, %d, %d )", red, green, blue));
        });
    }

    public void init() {
        main = findViewById(R.id.main);
        rgb_text = findViewById(R.id.rgb_text);
    }
}