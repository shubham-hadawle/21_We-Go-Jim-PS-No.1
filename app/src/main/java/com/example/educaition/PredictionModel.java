package com.example.educaition;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationBarView;

import org.w3c.dom.Text;

public class PredictionModel extends AppCompatActivity{
    int i = 1;
    Spinner S1,S2,S3,S4,S5,S6,S7,S8,S9,S10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prediction_model);

        S1 = findViewById(R.id.textSpinner);
        String mGender = S1.getSelectedItem().toString();

        S2 = findViewById(R.id.textSpinner2);
        String mAge = S2.getSelectedItem().toString();

        S3 = findViewById(R.id.textSpinner3);
        String f2fClasses = S3.getSelectedItem().toString();

        S4 = findViewById(R.id.textSpinner4);
        String deterioration = S4.getSelectedItem().toString();

        S5 = findViewById(R.id.textSpinner5);
        String mealsInAWeak = S5.getSelectedItem().toString();

        S6 = findViewById(R.id.textSpinner6);
        String internetConnection = S6.getSelectedItem().toString();

        S7 = findViewById(R.id.textSpinner7);
        String missClassDueToElectricity = S7.getSelectedItem().toString();

        S8 = findViewById(R.id.textSpinner8);
        String electricityDeficit = S8.getSelectedItem().toString();

        S9 = findViewById(R.id.textSpinner9);
        String internetDeficit = S9.getSelectedItem().toString();

        S10 = findViewById(R.id.textSpinner10);
        String financial = S10.getSelectedItem().toString();
    }

    public void clickButton(View view){
        int m = give();

        TextView text = findViewById(R.id.someButton);
        if(m == 1){
        text.setText("Scholarship Granted!");}
        else{
            text.setText("Scholarship Denied");
        }
    }

    public int give(){
        if(i==1){
            i = 0;
            return 0;
        }
        else{
            i = 1;
            return 1;
        }
    }

}
