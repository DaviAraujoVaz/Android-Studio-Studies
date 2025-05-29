package com.example.contatosan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class ListarContatosActivity extends AppCompatActivity {
    RecyclerView recyclerViewContatos;
    Button btnAdicionarContato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_listar_contatos);

        recyclerViewContatos = findViewById(R.id.rvListaContatos);
        btnAdicionarContato = findViewById(R.id.cmdNovoContato);

        btnAdicionarContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListarContatosActivity.this, AdicionarContatoActivity.class);
                startActivity(intent);
            }
        });
    }
}