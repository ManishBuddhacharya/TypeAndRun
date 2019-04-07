package com.typeandrun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSave;
    private EditText etMake, etColor, etYear, etPrice, etEngine;
    private TextView tvOutput;

    double price, engine;
    String make, color, res;
    int year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = findViewById(R.id.btnSave);
        etMake= findViewById(R.id.etMake);
        etPrice= findViewById(R.id.etPrice);
        etYear= findViewById(R.id.etYear);
        etEngine= findViewById(R.id.etEngine);
        etColor= findViewById(R.id.etColor);
        tvOutput = findViewById(R.id.tvOutput);

        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnSave) {
            if (validation()) {
                price = Double.parseDouble(etPrice.getText().toString());
                engine = Double.parseDouble(etEngine.getText().toString());
                year = Integer.parseInt(etYear.getText().toString());
                color = etColor.getText().toString();
                make = etMake.getText().toString();
                TypeAndRun obj = new TypeAndRun();
                obj.setMake(make);
                obj.setColor(color);
                obj.setYear(year);
                obj.setEngine(engine);
                obj.setPrice(price);
                res = obj.runCmd();
                tvOutput.append(res);


            }
        }



    }

    public boolean validation(){
        boolean flag = true;
        if (TextUtils.isEmpty(etMake.getText().toString())){
            etMake.setError("Please enter Height");
            etMake.requestFocus();
            flag = false;
        }
        else if (TextUtils.isEmpty(etYear.getText().toString())){
            etYear.setError("Please enter Height");
            etYear.requestFocus();
            flag = false;
        }
        else if (TextUtils.isEmpty(etColor.getText().toString())){
            etColor.setError("Please enter Height");
            etColor.requestFocus();
            flag = false;
        }
        else if (TextUtils.isEmpty(etEngine.getText().toString())){
            etEngine.setError("Please enter Height");
            etEngine.requestFocus();
            flag = false;
        }
        else if (TextUtils.isEmpty(etPrice.getText().toString())){
            etPrice.setError("Please enter Height");
            etPrice.requestFocus();
            flag = false;
        }
        return flag;
    }
}
