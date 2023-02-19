package com.example.emflashcard;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView r1;
    TextView r2;
    TextView r3;
    TextView q1;
    Button bt1;
    LinearLayout l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r1 = findViewById(R.id.repons_1);
        r2 = findViewById(R.id.repons_2);
        r3 = findViewById(R.id.repons_3);
        q1 = findViewById(R.id.question1);
        bt1 = findViewById(R.id.but1);
        l1 = findViewById(R.id.l1);

        bt1.setOnClickListener(v -> {
            if(l1.getVisibility() == View.VISIBLE){
                l1.setVisibility(View.INVISIBLE);
            }
            else   {
                l1.setVisibility(View.VISIBLE);
            }
        });
    }
}

