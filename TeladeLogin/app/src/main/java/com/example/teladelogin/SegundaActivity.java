package com.example.teladelogin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import dominio.Usuario;

public class SegundaActivity extends AppCompatActivity {

    TextView lblLogin, lblSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segunda);

        lblLogin = (TextView) findViewById(R.id.lblLogin);
        lblSenha = (TextView) findViewById(R.id.lblSenha);

        Intent intent = getIntent();
        Usuario usuario = (Usuario) intent.getSerializableExtra("objetoUsuario");

        lblLogin.setText(usuario.getLogin());
        lblSenha.setText(usuario.getSenha());
    }
}