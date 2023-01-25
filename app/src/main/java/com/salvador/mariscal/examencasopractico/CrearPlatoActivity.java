package com.salvador.mariscal.examencasopractico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.salvador.mariscal.examencasopractico.modelo.Platos;

public class CrearPlatoActivity extends AppCompatActivity {

    Button buttonGuardaPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_plato);

        buttonGuardaPersona=(Button) findViewById(R.id.btn_crear);
        buttonGuardaPersona.setOnClickListener(l->guardaPersona());
    }

    private void guardaPersona(){
        EditText editTextNombre=(EditText) findViewById(R.id.editTextNombre);
        EditText editTextTipo=(EditText) findViewById(R.id.editTextTipo);
        EditText editTextIngredientes=(EditText) findViewById(R.id.editTextIngredientes);
        EditText editTextCosto=(EditText) findViewById(R.id.editTextCosto);
        EditText editTextPVP=(EditText) findViewById(R.id.editTextPVP);
        Platos platos= new Platos();
        platos.setNombre(editTextNombre.getText().toString());
        platos.setTipo(editTextTipo.getText().toString());
        platos.setIngredientes(editTextIngredientes.getText().toString());
        platos.setCosto(Double.parseDouble(editTextCosto.getText().toString()));
        platos.setPVP(Double.parseDouble(editTextPVP.getText().toString()));
        Toast.makeText(getApplicationContext(),"PERSONA CREADA SATISFACTORIAMENTE",Toast.LENGTH_LONG).show();
    }

}