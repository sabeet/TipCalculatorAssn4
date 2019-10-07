package com.example.tipcalculatorone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText checkAmountValue;
    private EditText partySizeValue;
    private EditText fifteenPercentTipValue;
    private EditText twentyPercentTipValue;
    private EditText twentyfivePercentTipValue;
    private EditText fifteenPercentTotalValue;
    private EditText twentyPercentTotalValue;
    private EditText twentyfivePercentTotalValue;
    private Button buttonCompute;
    String toastText = "Empty and/or incorrect values";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkAmountValue = findViewById(R.id.checkAmountValue);
        partySizeValue = findViewById(R.id.partySizeValue);
        twentyPercentTipValue = findViewById(R.id.twentyPercentTipValue);
        fifteenPercentTipValue = findViewById(R.id.fifteenPercentTipValue);
        twentyfivePercentTipValue = findViewById(R.id.twentyfivePercentTipValue);
        fifteenPercentTotalValue = findViewById(R.id.fifteenPercentTotalValue);
        twentyPercentTotalValue = findViewById(R.id.twentyPercentTotalValue);
        twentyfivePercentTotalValue = findViewById(R.id.twentyfivePercentTotalValue);
        buttonCompute = findViewById(R.id.buttonCompute);

        buttonCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(checkAmountValue.getText().toString()) || TextUtils.isEmpty(partySizeValue.getText().toString())
                   || Integer.parseInt(checkAmountValue.getText().toString()) <= 0 || Integer.parseInt(partySizeValue.getText().toString()) <= 0) {
                    Toast.makeText(getApplicationContext(), toastText, Toast.LENGTH_LONG).show();
                    return;
                }

                else {

                    int chAm = Integer.parseInt(checkAmountValue.getText().toString());
                    int paSi = Integer.parseInt(partySizeValue.getText().toString());
                    double divisionResult = chAm / paSi;

                    double fifteenPCTipresult = divisionResult * .15;
                    double twentyPCTipresult = divisionResult * .2;
                    double twentyfivePCTipresult = divisionResult * .25;

                    double fifteenPCTotalResult = divisionResult + fifteenPCTipresult;
                    double twentyPCTotalResult = divisionResult + twentyPCTipresult;
                    double twentyfivePCTotalResult = divisionResult + twentyfivePCTipresult;

                    fifteenPercentTipValue.setText(String.valueOf(fifteenPCTipresult));
                    twentyPercentTipValue.setText(String.valueOf(twentyPCTipresult));
                    twentyfivePercentTipValue.setText(String.valueOf(twentyfivePCTipresult));

                    fifteenPercentTotalValue.setText(String.valueOf(fifteenPCTotalResult));
                    twentyPercentTotalValue.setText(String.valueOf(twentyPCTotalResult));
                    twentyfivePercentTotalValue.setText(String.valueOf(twentyfivePCTotalResult));

                }

                /*if(checkAmountValue.equals("")) {

                    checkAmountValue.setText((nullString));
                    Toast.makeText(getApplicationContext(), empty, Toast.LENGTH_LONG).show();
                }

                else if(partySizeValue.equals("")) {
                    partySizeValue.setText((nullString));
                    Toast.makeText(getApplicationContext(), empty, Toast.LENGTH_LONG).show();
                }

                else if(chAm <= 0 || paSi <= 0){
                    Toast.makeText(getApplicationContext(), toastText, Toast.LENGTH_LONG).show();
                }*/



            }
        });

    }
}
