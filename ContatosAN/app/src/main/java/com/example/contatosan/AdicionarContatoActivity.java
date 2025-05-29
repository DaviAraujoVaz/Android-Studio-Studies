package com.example.contatosan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class AdicionarContatoActivity extends AppCompatActivity {
    EditText edtNomeContato, edtTelefoneContato;
    Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adicionar_contato);

        edtNomeContato = findViewById(R.id.txtNomeContato);
        edtTelefoneContato = findViewById(R.id.txtTelefoneContato);
        btnSalvar = findViewById(R.id.cmdSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}