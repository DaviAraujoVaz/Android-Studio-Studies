package com.example.componentes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import model.Usuario;

public class DadosUsuarioActivity extends AppCompatActivity {

    TextView tvNome, tvSexo, tvAreaAtuacao, tvNotificacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dados_usuario);

        tvNome = (TextView) findViewById(R.id.lblNome);
        tvSexo = (TextView) findViewById(R.id.lblSexo);
        tvAreaAtuacao = (TextView) findViewById(R.id.lblAreaAtuacao);
        tvNotificacao = (TextView) findViewById(R.id.lblNotificacao);

        Usuario usuario = (Usuario) getIntent().getSerializableExtra("objetoUsuario");

        tvNome.setText(usuario.getNome());
        tvSexo.setText(usuario.getSexo());
        tvAreaAtuacao.setText(usuario.getAreaAtuacao());
        tvNotificacao.setText(usuario.getNotificacao());
    }
}