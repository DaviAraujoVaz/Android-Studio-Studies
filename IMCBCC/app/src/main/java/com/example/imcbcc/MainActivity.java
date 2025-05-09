package com.example.imcbcc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView tvIMC, tvClassificacaoIMC;
    EditText edtPeso, edtAltura;
    Button btnClassificarIMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tvIMC = (TextView) findViewById(R.id.tvImc);
        tvClassificacaoIMC = (TextView) findViewById(R.id.tvClassificacaoImc);

        edtPeso = (EditText) findViewById(R.id.txtPeso);
        edtAltura = (EditText) findViewById(R.id.txtAltura);

        btnClassificarIMC = (Button) findViewById(R.id.btnClassificarImc);

        btnClassificarIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double imc, peso, altura;
                    String classificacaoImc, resultado;

                    peso = Double.parseDouble(edtPeso.getText().toString());
                    altura = Double.parseDouble(edtAltura.getText().toString());

                    imc = peso / Math.pow(altura, 2);

                    if (imc <= 18.5) {
                        classificacaoImc = "Abaixo do peso";
                    } else if (imc > 18.5 && imc <= 24.9) {
                        classificacaoImc = "Peso normal";
                    } else if (imc >= 25 && imc <= 29.9) {
                        classificacaoImc = "Sobrepeso";
                    } else if (imc >= 30 && imc <= 34.9) {
                        classificacaoImc = "Obesidade grau I";
                    } else {
                        classificacaoImc = "Sem futuro";
                    }

                    resultado = String.format("%.2f", imc);

                    tvIMC.setText(String.valueOf(resultado));
                    tvClassificacaoIMC.setText(classificacaoImc);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
