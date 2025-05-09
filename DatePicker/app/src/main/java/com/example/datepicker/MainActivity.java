package com.example.datepicker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView tvData;
    DatePicker datePickerData;
    Button btnCapturarData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tvData = (TextView) findViewById(R.id.lblData);
        datePickerData = (DatePicker) findViewById(R.id.dpData);
        btnCapturarData = (Button) findViewById(R.id.cmdCapturarData);

        btnCapturarData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data;
                data = datePickerData.getDayOfMonth() + "/"
                        + (datePickerData.getMonth() + 1) + "/"
                        + datePickerData.getYear();
                tvData.setText(data);
            }
        });
    }
}