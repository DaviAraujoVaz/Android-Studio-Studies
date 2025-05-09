package com.example.componentes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import model.Usuario;

public class MainActivity extends AppCompatActivity {

    EditText edtNome;
    Button btnEnviar;
    CheckBox checkBackEnd, checkFrontEnd;
    RadioGroup radioSexo;
    RadioButton radioMasculino, radioFeminino;
    Switch switchNotificacao;

//    ToggleButton toggleNotificacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtNome = (EditText) findViewById(R.id.txtNome);

        btnEnviar = (Button) findViewById(R.id.cmdEnviar);

        checkBackEnd = (CheckBox) findViewById(R.id.ckbBackEnd);
        checkFrontEnd = (CheckBox) findViewById(R.id.ckbFrontEnd);

        radioSexo = (RadioGroup) findViewById(R.id.rdGrupoSexo);
        radioMasculino = (RadioButton) findViewById(R.id.rdMasculino);
        radioFeminino = (RadioButton) findViewById(R.id.rdFeminino);

        switchNotificacao = (Switch) findViewById(R.id.swNotificacao);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DadosUsuarioActivity.class);

                Usuario usuario = new Usuario();
                usuario.setNome(edtNome.getText().toString());

                String areaAtuacao = "";

                if (radioSexo.getCheckedRadioButtonId() == R.id.rdFeminino) {
                    usuario.setSexo("Feminino");
                } else {
                    usuario.setSexo("Masculino");
                }

                if (checkBackEnd.isChecked()) {
                    areaAtuacao += "| Back-End | ";
                }
                if (checkFrontEnd.isChecked()) {
                    areaAtuacao += "| Front-End | ";
                }
                usuario.setAreaAtuacao(areaAtuacao);

                if (switchNotificacao.isChecked()) {
                    usuario.setNotificacao("SIM");
                } else {
                    usuario.setNotificacao("NÃO");
                }

                intent.putExtra("objetoUsuario", usuario);
                startActivity(intent);
            }
        });
    }
}