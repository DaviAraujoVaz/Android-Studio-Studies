package com.example.datepickerdialog;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView tvData;
    Button btnCapturarData;
    EditText edtData;
    DatePickerDialog dpData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tvData = (TextView) findViewById(R.id.lblData);
        btnCapturarData = (Button) findViewById(R.id.cmdCapturarData);
        edtData = (EditText) findViewById(R.id.txtData);

        edtData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendario = Calendar.getInstance();
                int ano = calendario.get(calendario.YEAR);
                int mes = calendario.get(calendario.MONTH);
                int dia = calendario.get(calendario.DAY_OF_MONTH);
                dpData = new DatePickerDialog(MainActivity.this, R.style.DatePickerDialogTheme, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String data = dayOfMonth + "/" + (month + 1) + "/" + year;
                        edtData.setText(data);
                    }
                }, ano, mes, dia);
                dpData.show();
            }
        });

        btnCapturarData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvData.setText(edtData.getText());
            }
        });
    }
}