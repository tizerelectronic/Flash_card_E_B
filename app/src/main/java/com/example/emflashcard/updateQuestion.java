package com.example.emflashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class updateQuestion extends AppCompatActivity {
    private EditText mEditQuestion,mEditReponsV, mEditReponsf1, mEditReponsf2;
    private ImageView mBtnUpdate, mBtnDelete;
    private DBHandler dbHandler;
    String question, reponsv, reponsf1, reponsf2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_question);
        mEditQuestion = findViewById(R.id.idEdtQuestionName);
        mEditReponsV = findViewById(R.id.idEdtReponsV);
        mEditReponsf1 = findViewById(R.id.idEdtRepons2);
        mEditReponsf2 = findViewById(R.id.idEdtRepons3);
        mBtnUpdate = findViewById(R.id.idBtnUpdateQuestion);
        mBtnDelete = findViewById(R.id.idBtnDelete);

        dbHandler = new DBHandler(this);

        question = getIntent().getStringExtra("question");
        reponsv = getIntent().getStringExtra("reponsv");
        reponsf1 = getIntent().getStringExtra("reponsf1");
        reponsf2 = getIntent().getStringExtra("reponsf2");

        mEditQuestion.setText(question);
        mEditReponsV.setText(reponsv);
        mEditReponsf1.setText(reponsf1);
        mEditReponsf2.setText(reponsf2);

        mBtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler.updateQuestion(question, mEditQuestion.getText().toString(), mEditReponsV.getText().toString(),mEditReponsf1.getText().toString(),mEditReponsf2.getText().toString());
                Toast.makeText(updateQuestion.this, "Question Updated..", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(updateQuestion.this,MainActivity.class);
                startActivity(i);
            }
        });
        mBtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler.deleteQuestion(question);
                Toast.makeText(updateQuestion.this, "Deleted the Question", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(updateQuestion.this, MainActivity.class);
                startActivity(i);
            }
        });

    }

    public void btnclose(View view) {
        finish();
    }
}