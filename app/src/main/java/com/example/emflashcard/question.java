package com.example.emflashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;

public class question extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        ImageView btn_submit = (ImageView) findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent data = new Intent(question.this, MainActivity.class);
                String q1 = ((EditText) findViewById(R.id.editTextQ)).getText().toString();
                String r1 = ((EditText) findViewById(R.id.editTextR)).getText().toString();
                String r2 = ((EditText) findViewById(R.id.editTextR2)).getText().toString();
                String r3 = ((EditText) findViewById(R.id.editTextR3)).getText().toString();
                data.putExtra("qestion", q1);
                data.putExtra("reponsv", r2);
                data.putExtra("reponsf1", r1);
                data.putExtra("reponsf2", r3);
                setResult(RESULT_OK, data);
                Snackbar.make(findViewById(R.id.flashcard),
                                "Flash card creer",
                                Snackbar.LENGTH_SHORT)
                        .show();

                finish();
            }
        });


    }


    public void close_a(View view) {
        Intent i = new Intent(question.this, MainActivity.class);
        question.this.startActivity(i);
        finish();
    }
}


