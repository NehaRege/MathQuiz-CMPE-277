package com.test.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.test.myapplication.QuizActivities.AddActivity;
import com.test.myapplication.QuizActivities.AddQuizActivity;
import com.test.myapplication.QuizActivities.MulQuizActivity;
import com.test.myapplication.QuizActivities.SubQuizActivity;

public class MainActivity extends AppCompatActivity {

    private Button addButton;
    private Button subButton;
    private Button multpButton;

    public static int REQUEST_CODE_ADD = 200;
    public static int REQUEST_CODE_SUB = 78;
    public static int REQUEST_CODE_MUL = 43;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        if(getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);

        }

        addButton = (Button) findViewById(R.id.add_button);
        subButton = (Button) findViewById(R.id.sub_button);
        multpButton = (Button) findViewById(R.id.multp_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent addIntent = new Intent(MainActivity.this, AddActivity.class);
                addIntent.putExtra("key_add", "add");
                startActivityForResult(addIntent,REQUEST_CODE_ADD);
//                startActivity(addIntent);

            }
        });

        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent subIntent = new Intent(MainActivity.this, SubQuizActivity.class);
                subIntent.putExtra("key_sub","sub");
                startActivityForResult(subIntent,REQUEST_CODE_SUB);
//                startActivity(subIntent);

            }
        });

        multpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent mulIntent = new Intent(MainActivity.this,MulQuizActivity.class);
                mulIntent.putExtra("key_mul","mul");
//                startActivity(mulIntent);
                startActivityForResult(mulIntent,REQUEST_CODE_MUL);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_ADD){
            if(resultCode == RESULT_OK){

                int score = data.getIntExtra("score",-1);
                Toast.makeText(MainActivity.this, "Addition score = "+score, Toast.LENGTH_SHORT).show();

            }
        }

        if(requestCode == REQUEST_CODE_SUB){
            if(resultCode == RESULT_OK){

                int score = data.getIntExtra("score",-1);
                Toast.makeText(MainActivity.this, "Subtraction score = "+score, Toast.LENGTH_SHORT).show();

            }
        }

        if(requestCode == REQUEST_CODE_MUL){
            if(resultCode == RESULT_OK){

                int score = data.getIntExtra("score",-1);
                Toast.makeText(MainActivity.this, "Production score = "+score, Toast.LENGTH_SHORT).show();

            }
        }


    }
}
