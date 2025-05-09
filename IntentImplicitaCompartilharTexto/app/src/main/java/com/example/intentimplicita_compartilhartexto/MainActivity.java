package com.example.intentimplicita_compartilhartexto;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnCompartilharTexto;
    EditText txtTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnCompartilharTexto = (Button) findViewById(R.id.btnCompartilharTexto);
        txtTexto = (EditText) findViewById(R.id.txtTexto);

        btnCompartilharTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = txtTexto.getText().toString();
                if (!texto.isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT, texto);

                    Intent sharedIntent = Intent.createChooser(intent, "Compartilhar via");

                    startActivity(sharedIntent);
                } else {
                    Toast.makeText(MainActivity.this, "Digite um texto que deseja compartilhar...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}