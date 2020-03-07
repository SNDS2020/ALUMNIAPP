package com.example.alumniapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
   public Button button1;
   public Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open2Activity();
            }
        });
        button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open3Activity();
            }
        });
    }
    public void open2Activity(){
        Intent intent = new Intent(this,Main2Activity.class);
                startActivity(intent);
    }
    public void open3Activity(){
        Intent intent1 = new Intent(this,Main3Activity.class);
        startActivity(intent1);
    }

}
