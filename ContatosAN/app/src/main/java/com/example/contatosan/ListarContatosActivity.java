package com.example.contatosan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import adapter.AdapterContato;
import model.Contato;
import persistency.ContatoDAO;

public class ListarContatosActivity extends AppCompatActivity {
    RecyclerView recyclerViewContatos;
    Button btnAdicionarContato;
    private AdapterContato adapterContato;
    private List<Contato> listaContato = new ArrayList<>();

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

    public void carregarListaContato() {
        ContatoDAO contatoDAO = new ContatoDAO(getApplicationContext());
        listaContato = contatoDAO.listar();
        // Configurar o adapter com os dados que vão vir do SQLite database
        adapterContato = new AdapterContato(listaContato);
        // Configurar o listener dos clicks diretamente no adapter
        adapterContato.setOnItemClickListener(new AdapterContato.OnItemClickListener() {
            @Override
            public void onItemClick(Contato contato, int position) {
                Intent intent = new Intent(ListarContatosActivity.this, AdicionarContatoActivity.class);
                intent.putExtra("contatoSelecionado", contato);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(Contato contato, int position) {
                mostrarDialogoExclusao(contato);
            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewContatos.setLayoutManager(layoutManager);
        recyclerViewContatos.setHasFixedSize(true);
        recyclerViewContatos.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerViewContatos.setAdapter(adapterContato);
    }

    private void mostrarDialogoExclusao(Contato contato) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(ListarContatosActivity.this);
        dialog.setTitle("Confirma a Exclusão");
        dialog.setMessage("Deseja excluir o contato: " + contato.getNomeContato() + "?");
        dialog.setPositiveButton("Sim", (dialogInterface, i) -> {
            ContatoDAO contatoDAO = new ContatoDAO(getApplicationContext());
            if (contatoDAO.excluir(contato)) {
                carregarListaContato();
                Toast.makeText(ListarContatosActivity.this, "Sucesso ao excluir o registro", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(ListarContatosActivity.this, "Erro ao excluir o registro", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setNegativeButton("Não", null);
        dialog.create();
        dialog.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        carregarListaContato();
    }
}