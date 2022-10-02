package com.example.educaition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void recordedLectures(View view){
        Intent i = new Intent(this, RecordedLectures.class);
        startActivity(i);
    }

    public void Courses(View view){
        Intent i = new Intent(this, Courses.class);
        startActivity(i);
    }

    public void startAssistant(View view){
        Intent i = new Intent(this, VirtualAi.class);
        startActivity(i);
    }

    public void openModel(View view){
        Intent i = new Intent(this, PredictionModel.class);
        startActivity(i);
    }
}