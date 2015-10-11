package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnRest;
    TextView textResult;
    float result = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);

        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        btnRest = (Button) findViewById(R.id.BtnRest);

        textResult = (TextView) findViewById(R.id.TextResult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String num1 = edit1.getText().toString();
                String num2 = edit2.getText().toString();


                if (num1.equals("") || num2.equals(""))
                    Toast.makeText(MainActivity.this, "숫자를 입력하세요", Toast.LENGTH_SHORT).show();

                else {

                    float n1 = Float.parseFloat(num1);
                    float n2 = Float.parseFloat(num2);
                    result = n1 + n2;
                    textResult.setText("계산 결과 : " + result);
                }

            }


        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1 = edit1.getText().toString();
                String num2 = edit2.getText().toString();

                if (num1.equals("") || num2.equals(""))
                    Toast.makeText(MainActivity.this, "숫자를 입력하세요", Toast.LENGTH_SHORT).show();

                else {

                    float n1 = Float.parseFloat(num1);
                    float n2 = Float.parseFloat(num2);
                    result = n1 - n2;
                    textResult.setText("계산 결과 : " + result);
                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1 = edit1.getText().toString();
                String num2 = edit2.getText().toString();

                if (num1.equals("") || num2.equals(""))
                    Toast.makeText(MainActivity.this, "숫자를 입력하세요", Toast.LENGTH_SHORT).show();

                else {
                    float n1 = Float.parseFloat(num1);
                    float n2 = Float.parseFloat(num2);
                    result = n1 * n2;
                    textResult.setText("계산 결과 : " + result);
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1 = edit1.getText().toString();
                String num2 = edit2.getText().toString();

                if (num1.equals("") || num2.equals(""))
                    Toast.makeText(MainActivity.this, "숫자를 입력하세요", Toast.LENGTH_SHORT).show();
                else if (num2.equals("0"))
                    Toast.makeText(MainActivity.this, "0으로 나눌 수 없습니다", Toast.LENGTH_SHORT).show();

                else {
                    float n1 = Float.parseFloat(num1);
                    float n2 = Float.parseFloat(num2);
                    result = n1 / n2;
                    textResult.setText("계산 결과 : " + result);
                }
            }
        });

        btnRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1 = edit1.getText().toString();
                String num2 = edit2.getText().toString();

                if (num1.equals("") || num2.equals(""))
                    Toast.makeText(MainActivity.this, "숫자를 입력하세요", Toast.LENGTH_SHORT).show();

                else {
                    float n1 = Float.parseFloat(num1);
                    float n2 = Float.parseFloat(num2);
                    result = n1 % n2;
                    textResult.setText("계산 결과 : " + result);
                }
            }
        });
    }
}
