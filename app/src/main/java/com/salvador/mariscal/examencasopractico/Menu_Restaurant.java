package com.salvador.mariscal.examencasopractico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.salvador.mariscal.examencasopractico.modelo.BaseSQLiteHelper;
import com.salvador.mariscal.examencasopractico.modelo.Platos;

public class Menu_Restaurant extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_restaurant);

        final BaseSQLiteHelper developeru = new BaseSQLiteHelper(getApplicationContext());

        Button buttonListar=(Button) findViewById(R.id.button_Listar);
        buttonListar.setOnClickListener(l->listaPlatos());

        Button btn_agregar = findViewById(R.id.btn_agregar);
        btn_agregar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(Menu_Restaurant.this, CrearPlatoActivity.class));
            }
        });

    }
    private void listaPlatos(){
        ListView listPlatos=(ListView) findViewById(R.id.listViewPersonas);
        Cursor cursor = Platos.listaGestion(getApplicationContext());
        String[] from = new String[]{"id","nombre","tipo","ingredientes","costos","PVP"};
        int[] to = new int[]{R.id.txtID,R.id.txtNombre,R.id.txtTipos,R.id.txtIngredientes,R.id.txtCostos,R.id.txtPVP};
        try {
            CursorAdapter cursorAdapter = new SimpleCursorAdapter(
                    getApplicationContext(),
                    R.layout.detalle_plato,
                    cursor, from, to, 0
            );
            listPlatos.setAdapter(cursorAdapter);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Error en el listar",Toast.LENGTH_LONG).show();
        }
    }



}