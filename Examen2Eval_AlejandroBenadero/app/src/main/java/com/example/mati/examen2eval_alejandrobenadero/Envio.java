package com.example.mati.examen2eval_alejandrobenadero;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.mati.examen2eval_alejandrobenadero.R;

public class Envio extends Activity {

    TextView mostrar;
    double resultado;
    double peso;
    String tarifa;
    String zona;
    String decoracion;
    String continente;
    String texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envio);

        mostrar = (TextView) findViewById(R.id.mostrar);

        mostrar.setText("Resultado: ");
        Bundle bundle = getIntent().getExtras();
        resultado = bundle.getDouble("resultado");
        peso = bundle.getDouble("peso");
        tarifa = bundle.getString("tarifa");
        zona = bundle.getString("zona");
        decoracion = bundle.getString("decoracion");
        continente = bundle.getString("continente");

        texto = "Zona: "+zona+" ("+continente+")\nTarifa: "+tarifa+"\nPeso: "+peso+" kg\n\nDecoracion: "+decoracion+"\nCOSTE FINAL: "+resultado;

        mostrar.setText(texto);


    }


}
