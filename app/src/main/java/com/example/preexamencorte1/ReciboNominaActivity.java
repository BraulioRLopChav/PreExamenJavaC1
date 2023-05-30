package com.example.preexamencorte1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ReciboNominaActivity extends AppCompatActivity {
    private Button btnCalcular, btnLimpiar, btnRegresar;

    private EditText txtNumRecibo, txtNombre, txtHorasTrabajadas, txtHorasExtras,
            txtSubTotal, txtImpuestos, txtTotalPagar;

    private CheckBox checkBoxAuxiliar, checkBoxAlbanil, checkBoxIng;

    private ReciboNomina nomina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibo);
        iniciarComponentes();

        if(checkBoxAuxiliar.isChecked() == true) {
            checkBoxAlbanil.setEnabled(false);
            checkBoxIng.setEnabled(false);
        }

        if(checkBoxAlbanil.isChecked() == true) {
            checkBoxAuxiliar.setEnabled(false);
            checkBoxIng.setEnabled(false);
        }

        if(checkBoxIng.isChecked() == true) {
            checkBoxAuxiliar.setEnabled(false);
            checkBoxAlbanil.setEnabled(false);
        }

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnCalcular();
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresar();
            }
        });

        checkBoxAuxiliar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBoxAlbanil.setChecked(false);
                    checkBoxIng.setChecked(false);
                }
            }
        });

        checkBoxAlbanil.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBoxAuxiliar.setChecked(false);
                    checkBoxIng.setChecked(false);
                }
            }
        });

        checkBoxIng.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBoxAuxiliar.setChecked(false);
                    checkBoxAlbanil.setChecked(false);
                }
            }
        });
    }

    private void iniciarComponentes() {
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnRegresar = findViewById(R.id.btnRegresar);
        txtNumRecibo = findViewById(R.id.txtNumRecibo);
        txtNombre = findViewById(R.id.txtNombre);
        txtHorasTrabajadas = findViewById(R.id.txtHorasTrabajadas);
        txtHorasExtras = findViewById(R.id.txtHorasExtras);
        txtSubTotal = findViewById(R.id.txtSubtotal);
        txtImpuestos = findViewById(R.id.txtImpuestos);
        txtTotalPagar = findViewById(R.id.txtTotalPagar);
        checkBoxAuxiliar = findViewById(R.id.checkBoxAuxiliar);
        checkBoxAlbanil = findViewById(R.id.checkBoxAlbanil);
        checkBoxIng = findViewById(R.id.checkBoxIng);

        nomina = new ReciboNomina();
    }

    private void limpiar() {
        txtNumRecibo.setText("");
        txtNombre.setText("");
        txtHorasTrabajadas.setText("");
        txtHorasExtras.setText("");
        txtSubTotal.setText("");
        txtImpuestos.setText("");
        txtTotalPagar.setText("");
        checkBoxAuxiliar.setChecked(false);
        checkBoxAlbanil.setChecked(false);
        checkBoxIng.setChecked(false);
    }

    private void regresar() {
        AlertDialog.Builder confirmar = new AlertDialog.Builder(this);
        confirmar.setTitle("Nomina");
        confirmar.setMessage("¿Deseas regresar?");
        confirmar.setPositiveButton("Confirmar", (dialogInterface, which) -> finish());
        confirmar.setNegativeButton("Cancelar", (dialogInterface, which) -> {}).show();
    }

    private void btnCalcular() {
        if(validar() != -1) {
            nomina.setHorasTrabNormal(Float.parseFloat(txtHorasTrabajadas.getText().toString()));
            nomina.setHorasTrabExtras(Float.parseFloat(txtHorasExtras.getText().toString()));

            validarCheckBox();
            txtSubTotal.setText(String.valueOf(nomina.calcularSubtotal()));
            txtImpuestos.setText(String.valueOf(nomina.calcularImpuesto()));
            txtTotalPagar.setText(String.valueOf(nomina.calcularTotal()));
        }
    }

    private void validarCheckBox() {
        if(checkBoxAuxiliar.isChecked() == true) {
            nomina.setPuesto(1);
        }
        if(checkBoxAlbanil.isChecked() == true) {
            nomina.setPuesto(2);
        }
        if(checkBoxIng.isChecked() == true) {
            nomina.setPuesto(3);
        }
    }

    private int  validar() {
        if(txtNumRecibo.getText().toString().matches("") || txtNombre.getText().toString().matches("")
                || txtHorasTrabajadas.getText().toString().matches("") || txtHorasExtras.getText().toString().matches("")) {
            Toast.makeText(getApplicationContext(), "Faltan datos", Toast.LENGTH_LONG).show();
            return -1;
        }
        return 0;
    }
}

