package com.example.mati.dibujoareas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MenuPrincipal extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        Button calcular = (Button) findViewById(R.id.calcular);
        Button dibujar = (Button) findViewById(R.id.dibujar);

        calcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent = new Intent(MenuPrincipal.this, Area.class);
                startActivity(miIntent);
            }
        });

        dibujar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent miIntent = new Intent(MenuPrincipal.this, Dibujar.class);
                startActivity(miIntent);
            }
        });

    }
}




