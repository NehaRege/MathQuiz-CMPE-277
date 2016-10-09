package com.test.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by NehaRege on 10/7/16.
 */
public class QuizActivity extends AppCompatActivity {

    private TextView tvCurrentQno;
    private TextView tvNum1;
    private TextView tvNum2;
    private TextView tvOperation;
    private EditText etUserInput;

    private String quizOp;
    private String addOp;
    private String subOp;
    private String mulOp;

    private Button keypadNext;

    private int counter = 0;
    private int score = 0;
    private int totalQuesCount = 10;

    String TAG = "QuizActivity.class";

    private int num1;
    private int num2;


    private Intent intent;

    int i=0;

    int[] a;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_quiz);

        intent = getIntent();

        Log.i(TAG, "onCreate: received intent = "+intent.getStringExtra("key_sub"));

        tvCurrentQno = (TextView) findViewById(R.id.current_quest_no);
        tvNum1 = (TextView) findViewById(R.id.number_1);
        tvNum2 = (TextView) findViewById(R.id.number_2);
        tvOperation = (TextView) findViewById(R.id.operation);
        etUserInput = (EditText) findViewById(R.id.result);
        keypadNext = (Button) findViewById(R.id.keypad_next);


        if(intent.getStringExtra("key_sub").equals("sub")) {
            tvOperation.setText("-");

//            for(int i=0;i<totalQuesCount;i++) {

//                String curr = String.valueOf(i+1);
//                tvCurrentQno.setText(curr);

                a = setQuestionView();

            keypadNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Log.i(TAG, "onClick: clicked ");

                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] - a[1]))) {
                        Toast.makeText(QuizActivity.this, "Correct Answer !", Toast.LENGTH_SHORT).show();
                        score++;
                        Intent intent = new Intent(QuizActivity.this,QuizActivity.class);
                        intent.putExtra("key_sub","sub");
                        startActivity(intent);

                    } else {
                        Toast.makeText(QuizActivity.this, "Incorrect Answer !", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(QuizActivity.this,QuizActivity.class);
                        intent.putExtra("key_sub","sub");
                        startActivity(intent);

                    }

                }
            });
//        }

            Log.i(TAG, "onCreate: i= "+i);


//            Toast.makeText(QuizActivity.this,"Your Final Score is = "+score,Toast.LENGTH_LONG).show();
            score = 0;












        } else if (intent.getStringExtra(getString(R.string.key_mul)).equals("mul")) {
            tvOperation.setText("X");



        } else if (intent.getStringExtra(getString(R.string.Key_add)).equals("add")) {
            tvOperation.setText("+");



        }

    }

    public int[] setQuestionView() {

        int max = 9;
        int min = 0;

        num2 = (int) (Math.random() * (max - min) + min ); // num1>num2
        num1 = (int) (Math.random() * (max - num2) + num2 );

        int[] a={num1,num2};

        Log.i(TAG, "setQuestionView: num1 = "+num1);
        Log.i(TAG, "setQuestionView: num2 = "+num2);



        String sNum1 = String.valueOf(num1);
        String sNum2 = String.valueOf(num2);

        Log.i(TAG, "setQuestionView: snum1 = "+sNum1);
        Log.i(TAG, "setQuestionView: snum2 = "+sNum2);

        tvNum1.setText(sNum1);
        tvNum2.setText(sNum2);

        return a;



//        if (operation.equals("sub")) {
//            tvOperation.setText("-");
//        } else if (operation.equals("add")) {
//            tvOperation.setText("+");
//        } else if (operation.equals("mul")) {
//            tvOperation.setText("X");
//        }

    }
}
