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
 * Created by NehaRege on 10/9/16.
 */
public class MulQuizActivity extends AppCompatActivity implements View.OnClickListener {


    private Button keypadNext;
    private Button keypadClear;
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

    private TextView tvCurrentQno;
    private TextView tvNum1;
    private TextView tvNum2;
    private TextView tvOperation;

    private EditText etUserInput;

    private int currentQuesCounter=0;
    private int score = 0;
    private int totalQuesCount = 10;

    private int num1;
    private int num2;

    int[] a;

    private TextView tvTimer;
    private Timer timer;

    private String TAG = "AddQuizActivity";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_quiz);

        if(getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);

        }

        Intent intent = getIntent();

        setViews();


        tvOperation.setText("X");

        currentQuesCounter++;
        a = setQuestionView(currentQuesCounter);
        tvCurrentQno.setText(String.valueOf("1"));



        keypadNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (currentQuesCounter < totalQuesCount) {


                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] * a[1]))) {
                        etUserInput.getText().clear();

                        Log.i(TAG, "onClick: user input = " + etUserInput.getEditableText());

                        Log.i(TAG, "onClick: a0 * a1 = " + (a[0] * a[1]));

                        Log.i(TAG, "onClick: a[0] = " + a[0]);
                        Log.i(TAG, "onClick: a[1] = " + a[1]);
                        Toast.makeText(MulQuizActivity.this, "Correct Answer !", Toast.LENGTH_SHORT).show();
                        score++;
                        currentQuesCounter++;

                        Log.i(TAG, "onClick: score = " + score);

                        a = setQuestionView(currentQuesCounter);


                    } else {

                        etUserInput.getText().clear();

                        Toast.makeText(MulQuizActivity.this, "Incorrect Answer !", Toast.LENGTH_SHORT).show();

                        currentQuesCounter++;

                        a = setQuestionView(currentQuesCounter);

                    }
                } else {

                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] * a[1]))) {
                        score++;
                        Toast.makeText(MulQuizActivity.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                        Toast.makeText(MulQuizActivity.this, "FINAL SCORE = "+(score), Toast.LENGTH_SHORT).show();
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(MulQuizActivity.this);
                    builder.setMessage("FINAL SCORE = "+(score)+" on 10")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            });

                    AlertDialog dialog = builder.create();
                    dialog.show();


                }



            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:

                AlertDialog.Builder builder = new AlertDialog.Builder(MulQuizActivity.this);
                builder.setMessage("Are you sure you want to exit the quiz?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Intent intent = new Intent(MulQuizActivity.this,MainActivity.class);
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

                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] * a[1]))) {
                        etUserInput.getText().clear();


                        Log.i(TAG, "onClick: user input = " + etUserInput.getEditableText());

                        Log.i(TAG, "onClick: a0 * a1 = " + (a[0] * a[1]));

                        Log.i(TAG, "onClick: a[0] = " + a[0]);
                        Log.i(TAG, "onClick: a[1] = " + a[1]);
                        Toast.makeText(MulQuizActivity.this, "Correct Answer !", Toast.LENGTH_SHORT).show();
                        score++;
                        currentQuesCounter++;

                        Log.i(TAG, "onClick: score = " + score);

                        a = setQuestionView(currentQuesCounter);

                    }
                } else {
                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] * a[1]))) {
                        score++;
                        Toast.makeText(MulQuizActivity.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                        Toast.makeText(MulQuizActivity.this, "FINAL SCORE = "+(score), Toast.LENGTH_SHORT).show();
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(MulQuizActivity.this);
                    builder.setMessage("FINAL SCORE = "+(score)+" on 10")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
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


                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] * a[1]))) {
                        etUserInput.getText().clear();


                        Log.i(TAG, "onClick: user input = " + etUserInput.getEditableText());

                        Log.i(TAG, "onClick: a0 - a1 = " + (a[0] - a[1]));

                        Log.i(TAG, "onClick: a[0] = " + a[0]);
                        Log.i(TAG, "onClick: a[1] = " + a[1]);
                        Toast.makeText(MulQuizActivity.this, "Correct Answer !", Toast.LENGTH_SHORT).show();
                        score++;
                        currentQuesCounter++;

                        Log.i(TAG, "onClick: score = " + score);

                        a = setQuestionView(currentQuesCounter);

                    }
                } else {
                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] * a[1]))) {
                        score++;
                        Toast.makeText(MulQuizActivity.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                        Toast.makeText(MulQuizActivity.this, "FINAL SCORE = "+(score), Toast.LENGTH_SHORT).show();
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(MulQuizActivity.this);
                    builder.setMessage("FINAL SCORE = "+(score)+" on 10")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
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


                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] * a[1]))) {
                        etUserInput.getText().clear();


                        Log.i(TAG, "onClick: user input = " + etUserInput.getEditableText());

                        Log.i(TAG, "onClick: a0 - a1 = " + (a[0] - a[1]));

                        Log.i(TAG, "onClick: a[0] = " + a[0]);
                        Log.i(TAG, "onClick: a[1] = " + a[1]);
                        Toast.makeText(MulQuizActivity.this, "Correct Answer !", Toast.LENGTH_SHORT).show();
                        score++;
                        currentQuesCounter++;

                        Log.i(TAG, "onClick: score = " + score);

                        a = setQuestionView(currentQuesCounter);

                    }
                } else {
                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] * a[1]))) {
                        score++;
                        Toast.makeText(MulQuizActivity.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                        Toast.makeText(MulQuizActivity.this, "FINAL SCORE = "+(score), Toast.LENGTH_SHORT).show();
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(MulQuizActivity.this);
                    builder.setMessage("FINAL SCORE = "+(score)+" on 10")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            });

                    AlertDialog dialog = builder.create();
                    dialog.show();

                }

                break;

            case R.id.keypad_4:
                etUserInput.append(String.valueOf("4"));

                if(currentQuesCounter<totalQuesCount) {


                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] * a[1]))) {
                        etUserInput.getText().clear();


                        Log.i(TAG, "onClick: user input = " + etUserInput.getEditableText());

                        Log.i(TAG, "onClick: a0 - a1 = " + (a[0] - a[1]));

                        Log.i(TAG, "onClick: a[0] = " + a[0]);
                        Log.i(TAG, "onClick: a[1] = " + a[1]);
                        Toast.makeText(MulQuizActivity.this, "Correct Answer !", Toast.LENGTH_SHORT).show();
                        score++;
                        currentQuesCounter++;

                        Log.i(TAG, "onClick: score = " + score);

                        a = setQuestionView(currentQuesCounter);

                    }
                } else {
                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] * a[1]))) {
                        score++;
                        Toast.makeText(MulQuizActivity.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                        Toast.makeText(MulQuizActivity.this, "FINAL SCORE = "+(score), Toast.LENGTH_SHORT).show();
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(MulQuizActivity.this);
                    builder.setMessage("FINAL SCORE = "+(score)+" on 10")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
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


                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] * a[1]))) {
                        etUserInput.getText().clear();


                        Log.i(TAG, "onClick: user input = " + etUserInput.getEditableText());

                        Log.i(TAG, "onClick: a0 - a1 = " + (a[0] - a[1]));

                        Log.i(TAG, "onClick: a[0] = " + a[0]);
                        Log.i(TAG, "onClick: a[1] = " + a[1]);
                        Toast.makeText(MulQuizActivity.this, "Correct Answer !", Toast.LENGTH_SHORT).show();
                        score++;
                        currentQuesCounter++;

                        Log.i(TAG, "onClick: score = " + score);

                        a = setQuestionView(currentQuesCounter);

                    }
                } else {
                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] * a[1]))) {
                        score++;
                        Toast.makeText(MulQuizActivity.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                        Toast.makeText(MulQuizActivity.this, "FINAL SCORE = "+(score), Toast.LENGTH_SHORT).show();
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(MulQuizActivity.this);
                    builder.setMessage("FINAL SCORE = "+(score)+" on 10")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
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


                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] * a[1]))) {
                        etUserInput.getText().clear();


                        Log.i(TAG, "onClick: user input = " + etUserInput.getEditableText());

                        Log.i(TAG, "onClick: a0 - a1 = " + (a[0] - a[1]));

                        Log.i(TAG, "onClick: a[0] = " + a[0]);
                        Log.i(TAG, "onClick: a[1] = " + a[1]);
                        Toast.makeText(MulQuizActivity.this, "Correct Answer !", Toast.LENGTH_SHORT).show();
                        score++;
                        currentQuesCounter++;

                        Log.i(TAG, "onClick: score = " + score);

                        a = setQuestionView(currentQuesCounter);

                    }
                } else {
                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] * a[1]))) {
                        score++;
                        Toast.makeText(MulQuizActivity.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                        Toast.makeText(MulQuizActivity.this, "FINAL SCORE = "+(score), Toast.LENGTH_SHORT).show();
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(MulQuizActivity.this);
                    builder.setMessage("FINAL SCORE = "+(score)+" on 10")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
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


                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] * a[1]))) {
                        etUserInput.getText().clear();



                        Toast.makeText(MulQuizActivity.this, "Correct Answer !", Toast.LENGTH_SHORT).show();
                        score++;
                        currentQuesCounter++;

                        Log.i(TAG, "onClick: score = " + score);

                        a = setQuestionView(currentQuesCounter);

                    }
                } else {
                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] * a[1]))) {
                        score++;
                        Toast.makeText(MulQuizActivity.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                        Toast.makeText(MulQuizActivity.this, "FINAL SCORE = "+(score), Toast.LENGTH_SHORT).show();
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(MulQuizActivity.this);
                    builder.setMessage("FINAL SCORE = "+(score)+" on 10")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
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


                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] * a[1]))) {
                        etUserInput.getText().clear();


                        Log.i(TAG, "onClick: user input = " + etUserInput.getEditableText());

                        Log.i(TAG, "onClick: a0 - a1 = " + (a[0] - a[1]));

                        Log.i(TAG, "onClick: a[0] = " + a[0]);
                        Log.i(TAG, "onClick: a[1] = " + a[1]);
                        Toast.makeText(MulQuizActivity.this, "Correct Answer !", Toast.LENGTH_SHORT).show();
                        score++;
                        currentQuesCounter++;

                        Log.i(TAG, "onClick: score = " + score);

                        a = setQuestionView(currentQuesCounter);

                    }
                } else {
                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] * a[1]))) {
                        score++;
                        Toast.makeText(MulQuizActivity.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                        Toast.makeText(MulQuizActivity.this, "FINAL SCORE = "+(score), Toast.LENGTH_SHORT).show();
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(MulQuizActivity.this);
                    builder.setMessage("FINAL SCORE = "+(score)+" on 10")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
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


                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] * a[1]))) {
                        etUserInput.getText().clear();


                        Log.i(TAG, "onClick: user input = " + etUserInput.getEditableText());

                        Log.i(TAG, "onClick: a0 - a1 = " + (a[0] - a[1]));

                        Log.i(TAG, "onClick: a[0] = " + a[0]);
                        Log.i(TAG, "onClick: a[1] = " + a[1]);
                        Toast.makeText(MulQuizActivity.this, "Correct Answer !", Toast.LENGTH_SHORT).show();
                        score++;
                        currentQuesCounter++;

                        Log.i(TAG, "onClick: score = " + score);

                        a = setQuestionView(currentQuesCounter);

                    }
                } else {
                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] * a[1]))) {
                        score++;
                        Toast.makeText(MulQuizActivity.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                        Toast.makeText(MulQuizActivity.this, "FINAL SCORE = "+(score), Toast.LENGTH_SHORT).show();
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(MulQuizActivity.this);
                    builder.setMessage("FINAL SCORE = "+(score)+" on 10")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
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


                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] * a[1]))) {
                        etUserInput.getText().clear();


                        Log.i(TAG, "onClick: user input = " + etUserInput.getEditableText());

                        Log.i(TAG, "onClick: a0 - a1 = " + (a[0] - a[1]));

                        Log.i(TAG, "onClick: a[0] = " + a[0]);
                        Log.i(TAG, "onClick: a[1] = " + a[1]);
                        Toast.makeText(MulQuizActivity.this, "Correct Answer !", Toast.LENGTH_SHORT).show();
                        score++;
                        currentQuesCounter++;

                        Log.i(TAG, "onClick: score = " + score);

                        a = setQuestionView(currentQuesCounter);

                    }
                } else {
                    if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] * a[1]))) {
                        score++;
                        Toast.makeText(MulQuizActivity.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                        Toast.makeText(MulQuizActivity.this, "FINAL SCORE = "+(score), Toast.LENGTH_SHORT).show();
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(MulQuizActivity.this);
                    builder.setMessage("FINAL SCORE = "+(score)+" on 10")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            });

                    AlertDialog dialog = builder.create();
                    dialog.show();


//                    finish();
                }
                break;

//            case R.id.keypad_clear:
//                etUserInput.getEditableText().clear();
//                break;






        }

    }


    public void setViews() {

        tvCurrentQno = (TextView) findViewById(R.id.current_quest_no);
        tvNum1 = (TextView) findViewById(R.id.number_1);
        tvNum2 = (TextView) findViewById(R.id.number_2);
        tvOperation = (TextView) findViewById(R.id.operation);

        tvTimer = (TextView) findViewById(R.id.text_view_timer);


        etUserInput = (EditText) findViewById(R.id.result);

        keypadNext = (Button) findViewById(R.id.keypad_next);
        keypadClear = (Button) findViewById(R.id.keypad_clear);
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

    public int[] setQuestionView(int curr) {

        if(timer != null) {
            timer.cancel();
        }

        int max = 9;
        int min = 0;

        num2 = (int) (Math.random() * (max - min) + min );
        num1 = (int) (Math.random() * (max - min) + min );

        int[] a={num1,num2};

        Log.i(TAG, "setQuestionView: num1 = "+num1);
        Log.i(TAG, "setQuestionView: num2 = "+num2);



        String sNum1 = String.valueOf(num1);
        String sNum2 = String.valueOf(num2);

        Log.i(TAG, "setQuestionView: snum1 = "+sNum1);
        Log.i(TAG, "setQuestionView: snum2 = "+sNum2);

        tvNum1.setText(sNum1);
        tvNum2.setText(sNum2);

        String sCurr = String.valueOf(curr);

        tvCurrentQno.setText(sCurr);

        timer = new Timer(5000,1000);
        timer.start();

        return a;

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

                            Toast.makeText(MulQuizActivity.this, "Correct Answer !", Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(MulQuizActivity.this, "Incorrect Answer !", Toast.LENGTH_SHORT).show();
                        }
                    },9000);

                    currentQuesCounter++;

                    a = setQuestionView(currentQuesCounter);

                }

            } else {


                if (etUserInput.getEditableText().toString().equals(Integer.toString(a[0] * a[1]))) {
                    score++;
                    Toast.makeText(MulQuizActivity.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MulQuizActivity.this, "FINAL SCORE = " + (score), Toast.LENGTH_SHORT).show();
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(MulQuizActivity.this);
                builder.setMessage("FINAL SCORE = " + (score) + " on 10")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();


            }
        }


    }



}
