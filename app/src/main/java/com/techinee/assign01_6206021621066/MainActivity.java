package com.techinee.assign01_6206021621066;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editnumber1 , editnumber2;
    private Button btncal;
    private TextView sum , min , max;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editnumber1 = (EditText) findViewById(R.id.editnumber1);
        editnumber2 = (EditText) findViewById(R.id.editnumber2);
        btncal = (Button) findViewById(R.id.btncal);
        sum = (TextView) findViewById(R.id.sum);
        min = (TextView) findViewById(R.id.min);
        max = (TextView) findViewById(R.id.max);

        btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editnumber1ToString = editnumber1.getText().toString();
                String editnumber2ToString = editnumber2.getText().toString();

                if(editnumber1ToString.matches("")){
                    Toast.makeText(MainActivity.this,"กรุณากรอกตัวเลขค้าบบ",Toast.LENGTH_LONG).show();
                    return;
                }
                if(editnumber2ToString.matches("")){
                    Toast.makeText(MainActivity.this,"กรุณากรอกตัวเลขค้าบบ",Toast.LENGTH_LONG).show();
                    return;
                }

                int editnumber1Toint = Integer.parseInt(editnumber1ToString);
                int editnumber2Toint = Integer.parseInt(editnumber2ToString);

                sum.setText(sumCal(editnumber1Toint,editnumber2Toint));
                min.setText(minCal(editnumber1Toint,editnumber2Toint));
                max.setText(maxCal(editnumber1Toint,editnumber2Toint));
            }
        });

    }

    private String sumCal(int editnumber1Toint , int editnumber2Toint){
        return Integer.toString(editnumber1Toint + editnumber2Toint) ;
    }

    private String minCal(int editnumber1Toint , int editnumber2Toint){
        int min = editnumber1Toint;
        if(editnumber2Toint<editnumber1Toint)min = editnumber2Toint;
        return Integer.toString(min);
    }
    private String maxCal(int editnumber1Toint , int editnumber2Toint){
        int max = editnumber1Toint;
        if(editnumber2Toint>editnumber1Toint)max = editnumber2Toint;
        return Integer.toString(max);
    }
}