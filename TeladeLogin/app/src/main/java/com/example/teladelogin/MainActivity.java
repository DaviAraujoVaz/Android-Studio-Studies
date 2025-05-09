package com.example.teladelogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import dominio.Usuario;

public class MainActivity extends AppCompatActivity {

    Button btnAbrir;
    EditText txtLogin, txtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txtLogin = (EditText) findViewById(R.id.txtLogin);
        txtSenha = (EditText) findViewById(R.id.txtSenha);

        btnAbrir = (Button) findViewById(R.id.btnAbrir);

        btnAbrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SegundaActivity.class);

                Usuario usuario = new Usuario();
                usuario.setLogin(txtLogin.getText().toString());
                usuario.setSenha(txtSenha.getText().toString());

                intent.putExtra("objetoUsuario", usuario);

                startActivity(intent);
            }
        });
    }
}