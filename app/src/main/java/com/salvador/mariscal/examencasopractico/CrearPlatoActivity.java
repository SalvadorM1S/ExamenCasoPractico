package com.salvador.mariscal.examencasopractico;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.salvador.mariscal.examencasopractico.modelo.BaseSQLiteHelper;
import com.salvador.mariscal.examencasopractico.modelo.Platos;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CrearPlatoActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_plato);
        imageView=(ImageView) findViewById(R.id.imgView);

        final BaseSQLiteHelper developeru = new BaseSQLiteHelper(getApplicationContext());

        Button buttonGuardaPersona=(Button) findViewById(R.id.btn_crear);
        buttonGuardaPersona.setOnClickListener(l->guardaPersona());
    }

    final int Captura_Imagen=1;

    public void tomarFoto(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //if (intent.resolveActivity(this.getPackageManager())!=null){
        startActivityForResult(intent, Captura_Imagen);
        //}
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==Captura_Imagen && resultCode==RESULT_OK){

            Bundle bundle=data.getExtras();

            Bitmap imagen=(Bitmap)bundle.get("data");

            imageView.setImageBitmap(imagen);

            try{
                FileOutputStream fos = openFileOutput(crearNombreArchivoJPG(), Context.MODE_PRIVATE);
                imagen.compress(Bitmap.CompressFormat.JPEG,100,fos);
                fos.close();
            }catch (Exception e){

            }
        }
    }

    private String crearNombreArchivoJPG() {
        String fecha =  new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return fecha+".jpg";
    }


    private void guardaPersona(){
        EditText editTextNombre=(EditText) findViewById(R.id.editTextNombre);
        EditText editTextTipo=(EditText) findViewById(R.id.editTextTipo);
        EditText editTextIngredientes=(EditText) findViewById(R.id.editTextIngredientes);
        EditText editTextCosto=(EditText) findViewById(R.id.editTextCosto);
        EditText editTextPVP=(  EditText) findViewById(R.id.editTextPVP);

        //String NombreT=editTextNombre.getText().toString().trim();
        //String TipoT=editTextTipo.getText().toString().trim();
        //String IngredientesT=editTextIngredientes.getText().toString().trim();
        //String CostoT=editTextCosto.getText().toString().trim();
        //String PVPT=editTextPVP.getText().toString().trim();

        Platos platos= new Platos();
        platos.setNombre(editTextNombre.getText().toString());
        platos.setTipo(editTextTipo.getText().toString());
        platos.setIngredientes(editTextIngredientes.getText().toString());
        platos.setCosto(Double.parseDouble(editTextCosto.getText().toString()));
        platos.setPVP(Double.parseDouble(editTextPVP.getText().toString()));
        //if(NombreT.isEmpty() && TipoT.isEmpty() && IngredientesT.isEmpty()&& CostoT.isEmpty()&& PVPT.isEmpty()) {
            //Toast.makeText(getApplicationContext(), "Error al ingresar", Toast.LENGTH_LONG).show();

            platos.guardarGestion(getApplicationContext());
            Toast.makeText(getApplicationContext(), "PLATO CREADA SATISFACTORIAMENTE", Toast.LENGTH_LONG).show();

    }




}