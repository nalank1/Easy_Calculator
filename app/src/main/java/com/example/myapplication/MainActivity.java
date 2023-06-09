package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String oldNumber = "";
    String op = "+";
    TextView resultTxt;
    boolean isNewOp = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTxt = findViewById(R.id.resultText);
    }
    public void numberEvent(View view){
        //you are getting rid of 0 (that is coming at the beginning of the number
        if(isNewOp){
            resultTxt.setText("");
        }
        isNewOp = false;
        //we want to check the number is created, each time we press, the number pops up
        String number = resultTxt.getText().toString();
        int id = view.getId();
        if (id == R.id.btn01) {
            number += "1";
        } else if (id == R.id.btn02) {
            number += "2";
        } else if (id == R.id.btn03) {
            number += "3";
        } else if (id == R.id.btn04) {
            number += "4";
        } else if (id == R.id.btn05) {
            number += "5";
        } else if (id == R.id.btn06) {
            number += "6";
        } else if (id == R.id.btn07) {
            number += "7";
        } else if (id == R.id.btn08) {
            number += "8";
        } else if (id == R.id.btn09) {
            number += "9";
        } else if (id == R.id.btn00) {
            number += "0";
        } else if (id == R.id.btnDot) {
            number += ".";
        }
        resultTxt.setText(number);
    }
    public void operatorEvent(View view){
        isNewOp = true;
        oldNumber = resultTxt.getText().toString();

        if(view.getId() == R.id.btnDivide ) {
            op = "/";
        } else if (view.getId() == R.id.btnMinus) {
            op = "-";
        } else if (view.getId() == R.id.btnMultiply) {
            op = "*";
        } else if (view.getId() == R.id.btnAdd) {
           op = "+";
        }

    }

    public void equalsEvent(View view){
        String newNumber = resultTxt.getText().toString();
        double result = 0.0;
        if(op == "+"){
            result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
        } else if (op == "-") {
            result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
        } else if (op == "*") {
            result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
        } else{
            result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
        } resultTxt.setText(result + "");

    }

    public void cEvent(View view){
        resultTxt.setText("0");
        isNewOp = true;
    }

}