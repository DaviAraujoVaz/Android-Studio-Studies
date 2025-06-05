package com.example.contatosan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import model.Contato;
import persistency.ContatoDAO;

public class AdicionarContatoActivity extends AppCompatActivity {
    EditText edtNomeContato, edtTelefoneContato;
    Button btnSalvar;
    private Contato contatoAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adicionar_contato);

        edtNomeContato = findViewById(R.id.txtNomeContato);
        edtTelefoneContato = findViewById(R.id.txtTelefoneContato);
        btnSalvar = findViewById(R.id.cmdSalvar);
        contatoAtual = (Contato) getIntent().getSerializableExtra("contatoSelecionado");

        if (contatoAtual != null) {
            edtNomeContato.setText(contatoAtual.getNomeContato());
            edtTelefoneContato.setText(contatoAtual.getTelContato());
        }

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContatoDAO contatoDAO = new ContatoDAO(getApplicationContext());
                String nomeContato = edtNomeContato.getText().toString();
                String telContato = edtTelefoneContato.getText().toString();

                // Validação do campo obrigatório
                if (nomeContato.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "O campo nome é obrigatório", Toast.LENGTH_SHORT).show();
                    return;
                }

                Contato contato = new Contato();
                contato.setNomeContato(nomeContato);
                contato.setTelContato(telContato);

                if (contatoAtual != null) {
                    // ATUALIZAR contato existente
                    contato.setId(contatoAtual.getId());

                    if (contatoDAO.atualizar(contato)) {
                        Toast.makeText(getApplicationContext(), "Sucesso ao atualizar o registro", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Erro ao atualizar o registro", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // SALVAR novo contato (NÃO definir ID - será auto incrementado)

                    if (contatoDAO.salvar(contato)) {
                        Toast.makeText(getApplicationContext(), "Sucesso ao salvar o registro", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Erro ao salvar o registro", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}