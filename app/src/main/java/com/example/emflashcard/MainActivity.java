package com.example.emflashcard;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE =
            "com.example.android.emflashcard.extra.MESSAGE";
    Button r1;
    int i;
    Button r2;
    Button r3;
    TextView q1;
    Button bt1;
    LinearLayout l1;
    String editTxtQ;
    String reponsv;
    String reponsf1;
    String reponsf2;
    ImageView nextBtn;
    ImageView privBtn;
    DBHandler dbHandler;
    private int questionCounter=0;
    private int questionTotal;
    private QuestionModal currentQuestion;
    private ArrayList<QuestionModal> questionModalArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r1 = findViewById(R.id.repons_1);
        r2 = findViewById(R.id.repons_2);
        r3 = findViewById(R.id.repons_3);
        q1 = findViewById(R.id.question_1);
        l1 = findViewById(R.id.l1);
        nextBtn = (ImageView) findViewById(R.id.imgNext);
        privBtn = (ImageView) findViewById(R.id.imgPriv);
        dbHandler = new DBHandler(MainActivity.this);
        questionModalArrayList = dbHandler.readQuestion();
        questionTotal = questionModalArrayList.size();
        showNextQuestion();





        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                questionCounter++;
                showNextQuestion();
                }
            });
        privBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                questionCounter--;
                showPriviousQuestion();
            }
        });
    }

    public void repons_true(View view) {
        Intent intent = new Intent(this, reponse.class);
        String message = r1.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        Toast.makeText(MainActivity.this, "Bonne reponse", Toast.LENGTH_SHORT).show();
    }

    public void Repons_f(View view) {
        Toast.makeText(MainActivity.this, "Mauvaise reponse", Toast.LENGTH_SHORT).show();


    }

    public void repons_f2(View view) {
        Toast.makeText(MainActivity.this, "Mauvaise reponse", Toast.LENGTH_SHORT).show();
    }

    ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {

                if (result.getResultCode() == Activity.RESULT_OK){
                    Intent data = result.getData();
                    assert data != null;
                    editTxtQ = data.getExtras().getString("qestion");
                    reponsv = data.getExtras().getString("reponsv");
                    reponsf1 = data.getStringExtra("reponsf1");
                    reponsf2= data.getStringExtra("reponsf2");
                    dbHandler.addNewQuestion(editTxtQ, reponsv, reponsf1, reponsf2);
                    q1.setText(editTxtQ);
                    r1.setText(reponsv);
                    r2.setText(reponsf1);
                    r3.setText(reponsf2);
                    Toast.makeText(MainActivity.this, "Question ajouter", Toast.LENGTH_SHORT).show();

                    }
                        Log.i("MainActivity", "string1: $string1");
                        Log.i("MainActivity", "string2: $string2");

                }



    });

    public void NewQuestion(View view) {
        Intent intent2 = new Intent(this, question.class);
        resultLauncher.launch(intent2);
    }

    private void showNextQuestion(){
        if (questionCounter < questionTotal){
            currentQuestion = questionModalArrayList.get(questionCounter);
            q1.setText(currentQuestion.getQuestion());
            r1.setText(currentQuestion.getReponsv());
            r2.setText(currentQuestion.getReponsf1());
            r3.setText(currentQuestion.getReponsf2());
            questionCounter++;
        }else {
            Toast.makeText(this, "No more question", Toast.LENGTH_SHORT).show();}

    }
    private void showPriviousQuestion(){
        if (questionCounter > 0 ) {
            questionCounter--;
            currentQuestion = questionModalArrayList.get(questionCounter);
            q1.setText(currentQuestion.getQuestion());
            r1.setText(currentQuestion.getReponsv());
            r2.setText(currentQuestion.getReponsf1());
            r3.setText(currentQuestion.getReponsf2());

        }else {
        Toast.makeText(this, "No privious question", Toast.LENGTH_SHORT).show();}
    }

}

