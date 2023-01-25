package com.salvador.mariscal.examencasopractico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_menu = findViewById(R.id.btn_continuar);

        btn_menu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this, Menu_Restaurant.class));
            }
        });

    }

    //public void onClick(View view) {
    //   startActivity(new Intent(MainActivity.this, Menu_Restaurant.class));
    //}

}