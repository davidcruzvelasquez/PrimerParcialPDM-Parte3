package com.example.primerparcialpdmp3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtNombre, edtGenero, edtEdad, edtDireccion;
    TextView lblValidacion;
    CheckBox chbTerminos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNombre = (EditText) findViewById(R.id.txbNombre);
        edtGenero = (EditText) findViewById(R.id.txbGenero);
        edtEdad = (EditText) findViewById(R.id.txbEdad);
        edtDireccion = (EditText) findViewById(R.id.txbDireccion);
        chbTerminos = (CheckBox) findViewById(R.id.cbxTerminos);
        lblValidacion = (TextView) findViewById(R.id.txvValidacion);
    }

    public void registrarDatos(View view){
        try {
            if (view.getId()==R.id.btnRegistrar){
                int varEdad = Integer.parseInt(edtEdad.getText().toString());
                String varNombre = edtNombre.getText().toString();

                if (varEdad>=18){
                    if(chbTerminos.isChecked()){
                        lblValidacion.setTextColor(Color.BLUE);
                        lblValidacion.setText("BIENVENIDO" + " " + varNombre);
                    }else{
                        lblValidacion.setTextColor(Color.RED);
                        lblValidacion.setText("DEBE ACEPTAR LOS\nTERMINOS Y CONDICIONES");
                    }
                }else if(varEdad<18){
                    if(chbTerminos.isChecked()){
                        lblValidacion.setTextColor(Color.RED);
                        lblValidacion.setText("USTED ES MENOR DE EDAD,\nNO SE PUEDE REGISTRAR");
                    }else{
                        lblValidacion.setTextColor(Color.RED);
                        lblValidacion.setText("DEBE ACEPTAR LOS\nTERMINOS Y CONDICIONES");
                    }
                }
            }

        }catch (Exception e){
            lblValidacion.setTextColor(Color.RED);
            lblValidacion.setText("ERROR: NO HA PODIDO\n REGISTRARSE");
        }
    }

    public void cancelarRegistro(View view){
        try {
            if (view.getId()==R.id.btnCancelar) {
                //Limpiar
                edtNombre.setText("");
                edtGenero.setText("");
                edtEdad.setText("");
                edtDireccion.setText("");
                chbTerminos.setChecked(false);
                lblValidacion.setText("");
            }//fin if
        }catch (Exception e){
            lblValidacion.setTextColor(Color.RED);
            lblValidacion.setText("ERROR: NO HA PODIDO\n REGISTRARSE");
        }
    }
}