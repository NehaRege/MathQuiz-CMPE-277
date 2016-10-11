package com.test.myapplication.QuizActivities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.test.myapplication.MainActivity;
import com.test.myapplication.R;

/**
 * Created by NehaRege on 10/7/16.
 */
public class SubQuizActivity extends AppCompatActivity implements View.OnClickListener {

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
    private Button key1;
    private Button key2;
    private Button key3;
    private Button key4;
    private Button key5;
    private Button key6;
    private Button key7;
    private Button key8;
    private Button key9;
    private Button key0;


    private int currentQuesCounter=0;
    private int score = 0;
    private int totalQuesCount = 10;

    String TAG = "QuizActivity.class";

    private int num1;
    private int num2;


    private Intent intent;

    int i=0;

    private TextView tvTimer;
    private Timer timer;

    int[] a;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        if(getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);

        }

        intent = getIntent();

        Log.i(TAG, "onCreate: received intent = "+intent.getStringExtra("key_sub"));

        setViews();

        if(intent.getStringExtra("key_sub").equals("sub")) {
            tvOperation.setText("-");

            currentQuesCounter++;
            a = setQuestionView(currentQuesCounter);
            tvCurrentQno.setText(String.valueOf("1"));

//            if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] - a[1]))) {
//
//                Log.i(TAG, "onCreate: inside if statement of self check");
//
//
//                etUserInput.getText().clear();
//
//
//
//                Toast.makeText(QuizActivity.this, "Correct Answer !", Toast.LENGTH_SHORT).show();
//                score++;
//                currentQuesCounter++;
//
//                Log.i(TAG, "onClick: score = "+score);
//
//                a = setQuestionView(currentQuesCounter);
//
//
//            }


            keypadNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Log.i(TAG, "onClick: a[0] = "+a[0]);
                    Log.i(TAG, "onClick: a[1] = "+a[1]);

                    Log.i(TAG, "onClick: user input = "+etUserInput.getEditableText());


                    Log.i(TAG, "onClick: clicked ");

                    if (currentQuesCounter < totalQuesCount) {


                        if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] - a[1]))) {

                            etUserInput.getText().clear();


                            Log.i(TAG, "onClick: user input = "+etUserInput.getEditableText());

                            Log.i(TAG, "onClick: a0 - a1 = "+ (a[0]-a[1]));

                            Log.i(TAG, "onClick: a[0] = " + a[0]);
                            Log.i(TAG, "onClick: a[1] = " + a[1]);
                            Toast.makeText(SubQuizActivity.this, "Correct Answer !", Toast.LENGTH_SHORT).show();
                            score++;
                            currentQuesCounter++;

                            Log.i(TAG, "onClick: score = "+score);

                        a = setQuestionView(currentQuesCounter);


                        } else {

                            etUserInput.getText().clear();


                            Log.i(TAG, "onClick: inside else of incorrect ans ");

                            Toast.makeText(SubQuizActivity.this, "Incorrect Answer !", Toast.LENGTH_SHORT).show();

                            currentQuesCounter++;
                            a = setQuestionView(currentQuesCounter);



                        }

                    } else {

                        if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] - a[1]))) {
                            score++;
                            Toast.makeText(SubQuizActivity.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                            Toast.makeText(SubQuizActivity.this, "FINAL SCORE = "+(score), Toast.LENGTH_SHORT).show();
                        }

                        AlertDialog.Builder builder = new AlertDialog.Builder(SubQuizActivity.this);
                        builder.setMessage("FINAL SCORE = "+(score)+" on 10")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent intent = new Intent(SubQuizActivity.this,MainActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(intent);
                                        finish();
                                    }
                                });

                        AlertDialog dialog = builder.create();
                        dialog.show();

                    }
                }
            });
//        }

            Log.i(TAG, "onCreate: i= "+i);


//            Toast.makeText(QuizActivity.this,"Your Final Score is = "+score,Toast.LENGTH_LONG).show();
            score = 0;












        } else if (intent.getStringExtra("key_mul").equals("mul")) {
            tvOperation.setText("X");



        } else if (intent.getStringExtra("key_add").equals("add")) {
            tvOperation.setText("+");



        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:

                AlertDialog.Builder builder = new AlertDialog.Builder(SubQuizActivity.this);
                builder.setMessage("ARE YOU SURE YOU WANT TO EXIT QUIZ ?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Intent intent = new Intent(SubQuizActivity.this,MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                finish();

                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();

                return true;



        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.keypad_1:

                etUserInput.append(String.valueOf("1"));

                if(currentQuesCounter<totalQuesCount) {

                    if ("1".equals(Integer.toString(a[0] - a[1]))) {
                        etUserInput.getText().clear();


                        Log.i(TAG, "onClick: user input = " + etUserInput.getEditableText());

                        Log.i(TAG, "onClick: a0 - a1 = " + (a[0] - a[1]));

                        Log.i(TAG, "onClick: a[0] = " + a[0]);
                        Log.i(TAG, "onClick: a[1] = " + a[1]);
                        Toast.makeText(SubQuizActivity.this, "Correct Answer !", Toast.LENGTH_SHORT).show();
                        score++;
                        currentQuesCounter++;

                        Log.i(TAG, "onClick: score = " + score);

                        a = setQuestionView(currentQuesCounter);

                    }
                } else {
                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] - a[1]))) {
                        score++;
                        Toast.makeText(SubQuizActivity.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                        Toast.makeText(SubQuizActivity.this, "FINAL SCORE = "+(score), Toast.LENGTH_SHORT).show();
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(SubQuizActivity.this);
                    builder.setMessage("FINAL SCORE = "+(score)+" on 10")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(SubQuizActivity.this,MainActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);
                                    finish();
                                }
                            });

                    AlertDialog dialog = builder.create();
                    dialog.show();


//                    finish();
                }

                break;

            case R.id.keypad_2:
                etUserInput.append(String.valueOf("2"));

                if(currentQuesCounter<totalQuesCount) {


                    if ("2".equals(Integer.toString(a[0] - a[1]))) {
                        etUserInput.getText().clear();


                        Log.i(TAG, "onClick: user input = " + etUserInput.getEditableText());

                        Log.i(TAG, "onClick: a0 - a1 = " + (a[0] - a[1]));

                        Log.i(TAG, "onClick: a[0] = " + a[0]);
                        Log.i(TAG, "onClick: a[1] = " + a[1]);
                        Toast.makeText(SubQuizActivity.this, "Correct Answer !", Toast.LENGTH_SHORT).show();
                        score++;
                        currentQuesCounter++;

                        Log.i(TAG, "onClick: score = " + score);

                        a = setQuestionView(currentQuesCounter);

                    }
                } else {
                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] - a[1]))) {
                        score++;
                        Toast.makeText(SubQuizActivity.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                        Toast.makeText(SubQuizActivity.this, "FINAL SCORE = "+(score), Toast.LENGTH_SHORT).show();
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(SubQuizActivity.this);
                    builder.setMessage("FINAL SCORE = "+(score)+" on 10")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(SubQuizActivity.this,MainActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);
                                    finish();
                                }
                            });

                    AlertDialog dialog = builder.create();
                    dialog.show();


//                    finish();
                }


                break;

            case R.id.keypad_3:
                etUserInput.append(String.valueOf("3"));

                if(currentQuesCounter<totalQuesCount) {


                    if ("3".equals(Integer.toString(a[0] - a[1]))) {
                        etUserInput.getText().clear();


                        Log.i(TAG, "onClick: user input = " + etUserInput.getEditableText());

                        Log.i(TAG, "onClick: a0 - a1 = " + (a[0] - a[1]));

                        Log.i(TAG, "onClick: a[0] = " + a[0]);
                        Log.i(TAG, "onClick: a[1] = " + a[1]);
                        Toast.makeText(SubQuizActivity.this, "Correct Answer !", Toast.LENGTH_SHORT).show();
                        score++;
                        currentQuesCounter++;

                        Log.i(TAG, "onClick: score = " + score);

                        a = setQuestionView(currentQuesCounter);

                    }
                } else {
                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] - a[1]))) {
                        score++;
                        Toast.makeText(SubQuizActivity.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                        Toast.makeText(SubQuizActivity.this, "FINAL SCORE = "+(score), Toast.LENGTH_SHORT).show();
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(SubQuizActivity.this);
                    builder.setMessage("FINAL SCORE = "+(score)+" on 10")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(SubQuizActivity.this,MainActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);
                                    finish();
                                }
                            });

                    AlertDialog dialog = builder.create();
                    dialog.show();

//                    finish();
                }

                break;

            case R.id.keypad_4:
                etUserInput.append(String.valueOf("4"));

                if(currentQuesCounter<totalQuesCount) {


                    if ("4".equals(Integer.toString(a[0] - a[1]))) {
                        etUserInput.getText().clear();


                        Log.i(TAG, "onClick: user input = " + etUserInput.getEditableText());

                        Log.i(TAG, "onClick: a0 - a1 = " + (a[0] - a[1]));

                        Log.i(TAG, "onClick: a[0] = " + a[0]);
                        Log.i(TAG, "onClick: a[1] = " + a[1]);
                        Toast.makeText(SubQuizActivity.this, "Correct Answer !", Toast.LENGTH_SHORT).show();
                        score++;
                        currentQuesCounter++;

                        Log.i(TAG, "onClick: score = " + score);

                        a = setQuestionView(currentQuesCounter);

                    }
                } else {
                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] - a[1]))) {
                        score++;
                        Toast.makeText(SubQuizActivity.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                        Toast.makeText(SubQuizActivity.this, "FINAL SCORE = "+(score), Toast.LENGTH_SHORT).show();
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(SubQuizActivity.this);
                    builder.setMessage("FINAL SCORE = "+(score)+" on 10")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(SubQuizActivity.this,MainActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);
                                    finish();
                                }
                            });

                    AlertDialog dialog = builder.create();
                    dialog.show();

//                    finish();
                }

                break;

            case R.id.keypad_5:
                etUserInput.append(String.valueOf("5"));

                if(currentQuesCounter<totalQuesCount) {


                    if ("5".equals(Integer.toString(a[0] - a[1]))) {
                        etUserInput.getText().clear();


                        Log.i(TAG, "onClick: user input = " + etUserInput.getEditableText());

                        Log.i(TAG, "onClick: a0 - a1 = " + (a[0] - a[1]));

                        Log.i(TAG, "onClick: a[0] = " + a[0]);
                        Log.i(TAG, "onClick: a[1] = " + a[1]);
                        Toast.makeText(SubQuizActivity.this, "Correct Answer !", Toast.LENGTH_SHORT).show();
                        score++;
                        currentQuesCounter++;

                        Log.i(TAG, "onClick: score = " + score);

                        a = setQuestionView(currentQuesCounter);

                    }
                } else {
                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] - a[1]))) {
                        score++;
                        Toast.makeText(SubQuizActivity.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                        Toast.makeText(SubQuizActivity.this, "FINAL SCORE = "+(score), Toast.LENGTH_SHORT).show();
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(SubQuizActivity.this);
                    builder.setMessage("FINAL SCORE = "+(score)+" on 10")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(SubQuizActivity.this,MainActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);
                                    finish();
                                }
                            });

                    AlertDialog dialog = builder.create();
                    dialog.show();

//                    finish();
                }
                break;

            case R.id.keypad_6:
                etUserInput.append(String.valueOf("6"));

                if(currentQuesCounter<totalQuesCount) {

                    if ("6".equals(Integer.toString(a[0] - a[1]))) {
                        etUserInput.getText().clear();


                        Log.i(TAG, "onClick: user input = " + etUserInput.getEditableText());

                        Log.i(TAG, "onClick: a0 - a1 = " + (a[0] - a[1]));

                        Log.i(TAG, "onClick: a[0] = " + a[0]);
                        Log.i(TAG, "onClick: a[1] = " + a[1]);
                        Toast.makeText(SubQuizActivity.this, "Correct Answer !", Toast.LENGTH_SHORT).show();
                        score++;
                        currentQuesCounter++;

                        Log.i(TAG, "onClick: score = " + score);

                        a = setQuestionView(currentQuesCounter);

                    }
                } else {
                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] - a[1]))) {
                        score++;
                        Toast.makeText(SubQuizActivity.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                        Toast.makeText(SubQuizActivity.this, "FINAL SCORE = "+(score), Toast.LENGTH_SHORT).show();
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(SubQuizActivity.this);
                    builder.setMessage("FINAL SCORE = "+(score)+" on 10")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(SubQuizActivity.this,MainActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);
                                    finish();
                                }
                            });

                    AlertDialog dialog = builder.create();
                    dialog.show();

//                    finish();
                }

                break;

            case R.id.keypad_7:
                etUserInput.append(String.valueOf("7"));

                if(currentQuesCounter<totalQuesCount) {


                    if ("7".equals(Integer.toString(a[0] - a[1]))) {
                        etUserInput.getText().clear();


                        Log.i(TAG, "onClick: user input = " + etUserInput.getEditableText());

                        Log.i(TAG, "onClick: a0 - a1 = " + (a[0] - a[1]));

                        Log.i(TAG, "onClick: a[0] = " + a[0]);
                        Log.i(TAG, "onClick: a[1] = " + a[1]);
                        Toast.makeText(SubQuizActivity.this, "Correct Answer !", Toast.LENGTH_SHORT).show();
                        score++;
                        currentQuesCounter++;

                        Log.i(TAG, "onClick: score = " + score);

                        a = setQuestionView(currentQuesCounter);

                    }
                } else {
                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] - a[1]))) {
                        score++;
                        Toast.makeText(SubQuizActivity.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                        Toast.makeText(SubQuizActivity.this, "FINAL SCORE = "+(score), Toast.LENGTH_SHORT).show();
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(SubQuizActivity.this);
                    builder.setMessage("FINAL SCORE = "+(score)+" on 10")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(SubQuizActivity.this,MainActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);
                                    finish();
                                }
                            });

                    AlertDialog dialog = builder.create();
                    dialog.show();

//                    finish();
                }
                break;

            case R.id.keypad_8:
                etUserInput.append(String.valueOf("8"));

                if(currentQuesCounter<totalQuesCount) {

                    if ("8".equals(Integer.toString(a[0] - a[1]))) {
                        etUserInput.getText().clear();


                        Log.i(TAG, "onClick: user input = " + etUserInput.getEditableText());

                        Log.i(TAG, "onClick: a0 - a1 = " + (a[0] - a[1]));

                        Log.i(TAG, "onClick: a[0] = " + a[0]);
                        Log.i(TAG, "onClick: a[1] = " + a[1]);
                        Toast.makeText(SubQuizActivity.this, "Correct Answer !", Toast.LENGTH_SHORT).show();
                        score++;
                        currentQuesCounter++;

                        Log.i(TAG, "onClick: score = " + score);

                        a = setQuestionView(currentQuesCounter);

                    }
                } else {
                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] - a[1]))) {
                        score++;
                        Toast.makeText(SubQuizActivity.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                        Toast.makeText(SubQuizActivity.this, "FINAL SCORE = "+(score), Toast.LENGTH_SHORT).show();
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(SubQuizActivity.this);
                    builder.setMessage("FINAL SCORE = "+(score)+" on 10")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(SubQuizActivity.this,MainActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);
                                    finish();
                                }
                            });

                    AlertDialog dialog = builder.create();
                    dialog.show();


//                    finish();
                }
                break;

            case R.id.keypad_9:
                etUserInput.append(String.valueOf("9"));

                if(currentQuesCounter<totalQuesCount) {

                    if ("9".equals(Integer.toString(a[0] - a[1]))) {
                        etUserInput.getText().clear();


                        Log.i(TAG, "onClick: user input = " + etUserInput.getEditableText());

                        Log.i(TAG, "onClick: a0 - a1 = " + (a[0] - a[1]));

                        Log.i(TAG, "onClick: a[0] = " + a[0]);
                        Log.i(TAG, "onClick: a[1] = " + a[1]);
                        Toast.makeText(SubQuizActivity.this, "Correct Answer !", Toast.LENGTH_SHORT).show();
                        score++;
                        currentQuesCounter++;

                        Log.i(TAG, "onClick: score = " + score);

                        a = setQuestionView(currentQuesCounter);

                    }
                } else {
                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] - a[1]))) {
                        score++;
                        Toast.makeText(SubQuizActivity.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                        Toast.makeText(SubQuizActivity.this, "FINAL SCORE = "+(score), Toast.LENGTH_SHORT).show();
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(SubQuizActivity.this);
                    builder.setMessage("FINAL SCORE = "+(score)+" on 10")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(SubQuizActivity.this,MainActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);
                                    finish();
                                }
                            });

                    AlertDialog dialog = builder.create();
                    dialog.show();

//                    finish();
                }
                break;

            case R.id.keypad_0:
                etUserInput.append(String.valueOf("0"));

                if(currentQuesCounter<totalQuesCount) {

                    if ("0".equals(Integer.toString(a[0] - a[1]))) {
                        etUserInput.getText().clear();


                        Log.i(TAG, "onClick: user input = " + etUserInput.getEditableText());

                        Log.i(TAG, "onClick: a0 - a1 = " + (a[0] - a[1]));

                        Log.i(TAG, "onClick: a[0] = " + a[0]);
                        Log.i(TAG, "onClick: a[1] = " + a[1]);
                        Toast.makeText(SubQuizActivity.this, "Correct Answer !", Toast.LENGTH_SHORT).show();
                        score++;
                        currentQuesCounter++;

                        Log.i(TAG, "onClick: score = " + score);

                        a = setQuestionView(currentQuesCounter);

                    }
                } else {
                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] - a[1]))) {
                        score++;
                        Toast.makeText(SubQuizActivity.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                        Toast.makeText(SubQuizActivity.this, "FINAL SCORE = "+(score), Toast.LENGTH_SHORT).show();
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(SubQuizActivity.this);
                    builder.setMessage("FINAL SCORE = "+(score)+" on 10")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(SubQuizActivity.this,MainActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);
                                    finish();
                                }
                            });

                    AlertDialog dialog = builder.create();
                    dialog.show();

//                    finish();
                }
                break;






        }



    }

    public int[] setQuestionView(int curr) {

        if(timer != null) {
            timer.cancel();
        }

        int max = 9;
        int min = 0;

        num2 = (int) (Math.random() * (max - min) + min ); // num1>num2
        num1 = (int) (Math.random() * (max - num2) + num2 );

        int[] a={num1,num2};

        String sNum1 = String.valueOf(num1);
        String sNum2 = String.valueOf(num2);

        tvNum1.setText(sNum1);
        tvNum2.setText(sNum2);

        String sCurr = String.valueOf(curr);

        tvCurrentQno.setText(sCurr);

        timer = new Timer(5000,1000);
        timer.start();

        return a;

    }


    public void setViews() {

        tvCurrentQno = (TextView) findViewById(R.id.current_quest_no);
        tvNum1 = (TextView) findViewById(R.id.number_1);
        tvNum2 = (TextView) findViewById(R.id.number_2);
        tvOperation = (TextView) findViewById(R.id.operation);
        etUserInput = (EditText) findViewById(R.id.result);

        tvTimer = (TextView) findViewById(R.id.text_view_timer);

        keypadNext = (Button) findViewById(R.id.keypad_next);
        key1 = (Button) findViewById(R.id.keypad_1);
        key2 = (Button) findViewById(R.id.keypad_2);
        key3 = (Button) findViewById(R.id.keypad_3);
        key4 = (Button) findViewById(R.id.keypad_4);
        key5 = (Button) findViewById(R.id.keypad_5);
        key6 = (Button) findViewById(R.id.keypad_6);
        key7 = (Button) findViewById(R.id.keypad_7);
        key8 = (Button) findViewById(R.id.keypad_8);
        key9 = (Button) findViewById(R.id.keypad_9);
        key0 = (Button) findViewById(R.id.keypad_0);

        key1.setOnClickListener(this);
        key2.setOnClickListener(this);
        key3.setOnClickListener(this);
        key4.setOnClickListener(this);
        key5.setOnClickListener(this);
        key6.setOnClickListener(this);
        key7.setOnClickListener(this);
        key8.setOnClickListener(this);
        key9.setOnClickListener(this);
        key0.setOnClickListener(this);

    }



    public class Timer extends CountDownTimer {


        public Timer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {
            int progress = (int) (l / 1000);
            tvTimer.setText(Integer.toString(progress));

        }

        @Override
        public void onFinish() {

            if (currentQuesCounter < totalQuesCount) {

                if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] * a[1]))) {
                    etUserInput.getText().clear();

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            Toast.makeText(SubQuizActivity.this, "Correct Answer !", Toast.LENGTH_SHORT).show();
                            score++;
                            currentQuesCounter++;


                        }
                    }, 9000);

                    a = setQuestionView(currentQuesCounter);

                } else {

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            etUserInput.getText().clear();
                            Toast.makeText(SubQuizActivity.this, "Incorrect Answer !", Toast.LENGTH_SHORT).show();
                        }
                    },9000);

                    currentQuesCounter++;

                    a = setQuestionView(currentQuesCounter);

                }

            } else {


                if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] * a[1]))) {
                    score++;
                    Toast.makeText(SubQuizActivity.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(SubQuizActivity.this, "FINAL SCORE = " + (score), Toast.LENGTH_SHORT).show();
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(SubQuizActivity.this);
                builder.setMessage("FINAL SCORE = " + (score) + " on 10")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Intent intent = new Intent(SubQuizActivity.this,MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                finish();
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();


            }
        }


    }
}
