package com.example.faixaetaria;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnVerificarFaixaEtaria;
    TextView tvClassificacaoFaixaEtaria;
    EditText edtIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnVerificarFaixaEtaria = (Button) findViewById(R.id.cmdVerificarFaixaEtaria);
        tvClassificacaoFaixaEtaria = (TextView) findViewById(R.id.lblClassificacaoFaixaEtaria);
        edtIdade = (EditText) findViewById(R.id.txtIdade);

        btnVerificarFaixaEtaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idade;
                String classificacaoFaixaEtaria;

                idade = Integer.parseInt(edtIdade.getText().toString());
                if (idade > 0 && idade <= 12) {
                    classificacaoFaixaEtaria = "Criança";
                } else if (idade > 12 && idade <= 17) {
                    classificacaoFaixaEtaria = "Adolescente";
                } else if (idade > 17 && idade < 60) {
                    classificacaoFaixaEtaria = "Adulto";
                } else {
                    classificacaoFaixaEtaria = "Idoso";
                }

                tvClassificacaoFaixaEtaria.setText(classificacaoFaixaEtaria);
            }
        });
    }
}