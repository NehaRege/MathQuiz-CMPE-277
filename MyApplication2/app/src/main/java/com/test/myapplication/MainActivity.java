package com.test.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button addButton;
    private Button subButton;
    private Button multpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = (Button) findViewById(R.id.add_button);
        subButton = (Button) findViewById(R.id.sub_button);
        multpButton = (Button) findViewById(R.id.multp_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent addIntent = new Intent(MainActivity.this, AddQuizActivity.class);
                addIntent.putExtra("key_add", "add");
                startActivity(addIntent);

            }
        });

        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent subIntent = new Intent(MainActivity.this, QuizActivity.class);
//                subIntent.putExtra(getString(R.string.key_sub),"sub");
                subIntent.putExtra("key_sub","sub");
                startActivity(subIntent);

            }
        });

        multpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent mulIntent = new Intent(MainActivity.this,MulQuizActivity.class);
                mulIntent.putExtra("key_mul","mul");
                startActivity(mulIntent);

            }
        });

    }
}
