package com.example.emflashcard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE =
            "com.example.android.emflashcard.extra.MESSAGE";
    Button r1;
    Button r2;
    Button r3;
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
        q1 = findViewById(R.id.question_1);
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

    public void repons_true(View view) {
        Intent intent = new Intent(this, reponse.class);
        String message = r1.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
//        l1.setVisibility(View.GONE);
//        bt1.setVisibility(View.GONE);
//        q1.setText(R.string.repons1);
    }

    public void Repons_f(View view) {
        r2.setVisibility(View.INVISIBLE);
        bt1.setVisibility(View.INVISIBLE);


    }

    public void repons_f2(View view) {
        r3.setVisibility(View.INVISIBLE);
        bt1.setVisibility(View.INVISIBLE);
    }
}

