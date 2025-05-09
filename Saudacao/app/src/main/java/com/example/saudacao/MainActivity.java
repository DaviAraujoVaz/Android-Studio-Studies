package com.example.saudacao;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView tvSaudacao;
    Button btnSaudacao;
    EditText edtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tvSaudacao = (TextView) findViewById(R.id.lblSaudacao);
        edtNome = (EditText) findViewById(R.id.txtNome);
        btnSaudacao = (Button) findViewById(R.id.cmdSaudacao);

        btnSaudacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome, saudacao;
                nome = edtNome.getText().toString();
                saudacao = nome + ", seja bem-vindo ao curso de PDM!!!";
                tvSaudacao.setText(saudacao);
            }
        });
    }
}