package com.example.exemplobccintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnAbrirSegunda, btnAbrirTerceira, btnAbrirQuarta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnAbrirSegunda = (Button) findViewById(R.id.btnAbrirSegundaActivity);
        btnAbrirTerceira = (Button) findViewById(R.id.btnAbrirTerceiraActivity);
        btnAbrirQuarta = (Button) findViewById(R.id.btnAbrirQuartaActivity);

        btnAbrirSegunda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
                startActivity(intent);
            }
        });

        btnAbrirTerceira.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TerceiraActivity.class);
                startActivity(intent);
            }
        });

        btnAbrirQuarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuartaActivity.class);
                startActivity(intent);
            }
        });
    }
}