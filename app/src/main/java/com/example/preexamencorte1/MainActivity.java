package com.example.preexamencorte1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnIngresar, btnCerrar;
    private EditText txtTrabajador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarComponentes();

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresar();
            }
        });

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void iniciarComponentes() {
        btnIngresar = findViewById(R.id.btnEntrar);
        btnCerrar = findViewById(R.id.btnSalir);
        txtTrabajador = findViewById(R.id.txtTrabajador);
    }

    private void ingresar() {
        String strTrabajador = "Evaristo Toscano";

        if(txtTrabajador.getText().toString().equals(strTrabajador)) {
            Bundle bundle = new Bundle();
            bundle.putString("trabajador", strTrabajador);

            Intent intent = new Intent(MainActivity.this, ReciboNominaActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Trabajador no válido", Toast.LENGTH_LONG).show();
        }
    }
}