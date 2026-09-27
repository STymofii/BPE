package com.bulka.bpe;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textHello;
    private int clickCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textHello = findViewById(R.id.textHello);
        Button btnGreet = findViewById(R.id.btnGreet);
        Button btnReset = findViewById(R.id.btnReset);

        btnGreet.setOnClickListener(v -> {
            clickCount++;
            textHello.setText("Hello: " + clickCount);
        });

        btnReset.setOnClickListener(v -> {
            clickCount = 0;
            textHello.setText(R.string.hello_text);
        });
    }
}